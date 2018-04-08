package com.mehta.dao.framework.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mehta.dao.framework.GenericDao;
import com.mehta.dao.framework.finder.FinderArgumentTypeFactory;
import com.mehta.dao.framework.finder.FinderExecutor;
import com.mehta.dao.framework.finder.FinderNamingStrategy;
import com.mehta.dao.framework.finder.impl.SimpleFinderArgumentTypeFactoryImpl;
import com.mehta.dao.framework.finder.impl.SimpleFinderNamingStrategyImpl;

@Transactional
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK>, FinderExecutor<T> {

	private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategyImpl();
	private FinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactoryImpl();
	private static final Logger logger = LoggerFactory.getLogger(GenericDaoHibernateImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private final Class<T> type;

	public GenericDaoHibernateImpl(Class<T> type) {

		this.type = type;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PK create(T o) {

		Session session = sessionFactory.getCurrentSession();
		PK pk = (PK) session.save(o);
		session.flush();
		return pk;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Set<PK> createList(Set<T> objSet) {
		Session session = sessionFactory.getCurrentSession();
		Set<PK> pkSet = new HashSet<PK>();
		for (T obj : objSet) {
			pkSet.add((PK) session.save(obj));
		}
		session.flush();
		return pkSet;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PK> createGenericBatch(Map<Class, List<Object>> objectVoMap) {
		Session session = sessionFactory.getCurrentSession();
		List<PK> pk = new ArrayList<>();
		List<Object> innerList = null;
		for (Class classType : objectVoMap.keySet()) {
			innerList = objectVoMap.get(classType);
			for (Object obj : innerList) {
				pk.add((PK) session.save(classType.cast(obj)));
			}
		}
		session.flush();
		return pk;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T read(PK id) {

		Session session = sessionFactory.getCurrentSession();
		T t = (T) session.get(type, id);
		session.flush();
		return t;
	}

	@Override
	public void update(T o) {

		Session session = sessionFactory.getCurrentSession();
		session.update(o);
		session.flush();
	}

	@Override
	public void saveOrUpdate(T o) {

		Session session = sessionFactory.getCurrentSession();
		session.evict(o);
		session.flush();
		session.saveOrUpdate(o);
	}

	@Override
	public void executeQuery(String sql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		System.out.println(query.getQueryString());
		query.executeUpdate();
		session.flush();
	}

	@Override
	public void executeQueryMap(Map<String, Object> objectMap) {
		Object id = objectMap.get("id");
		String sql = "Update " + objectMap.get("tableName").toString() + " set id='" + id + "'";
		objectMap.remove("id");
		objectMap.remove("tableName");
		for (String key : objectMap.keySet()) {
			sql = sql + ", " + key + "= '" + objectMap.get(key) + "'";
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		sql = sql + ", last_modified=date('" + df.format(new Date()) + "')";

		sql = sql + " where id = '" + id + "'";

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(sql);
		System.out.println(query.getQueryString());
		query.executeUpdate();
		session.flush();
	}

	@Override
	public void merge(T o) {

		Session session = sessionFactory.getCurrentSession();
		session.merge(o);
		session.flush();
	}

	@Override
	public void evict(T o) {

		Session session = sessionFactory.getCurrentSession();
		session.evict(o);
		session.flush();
	}

	@Override
	public void flush() {

		Session session = sessionFactory.getCurrentSession();
		session.flush();
	}

	@Override
	public void delete(T o) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(o);
		session.flush();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> executeFinder(Method method, final Object[] queryArgs) {

		final Query namedQuery = prepareQuery(method, queryArgs);
		return namedQuery.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterator<T> iterateFinder(Method method, final Object[] queryArgs) {

		final Query namedQuery = prepareQuery(method, queryArgs);
		return namedQuery.iterate();
	}

	@Override
	public List<Object> convertToObjectList(List<Object[]> objArrayList, Object object, List<String> excludedFieldNames,
			List<String> includedFieldNames)
					throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		List<Object> ObjectList = new ArrayList<>();

		for (Object[] obj : objArrayList) {
			Class<?> cls = object.getClass();
			object = cls.newInstance();
			Field[] fields = cls.getDeclaredFields();

			int i = 0;
			for (Field field : fields) {
				if (includedFieldNames != null) {
					if (includedFieldNames.contains(field.getName())) {
						field.setAccessible(true);
						field.set(object, obj[i]);
						i++;
					}
				} else {
					if ("serialVersionUID".equalsIgnoreCase(field.getName())
							|| (excludedFieldNames != null && excludedFieldNames.contains(field.getName()))) {
						continue;
					}
					field.setAccessible(true);
					field.set(object, obj[i]);
					i++;
				}
			}

			ObjectList.add(object);
		}

		return ObjectList;
	}

	private Query prepareQuery(Method method, Object[] queryArgs) {

		final String queryName = getNamingStrategy().queryNameFromMethod(type, method);

		Session session = sessionFactory.getCurrentSession();
		Query namedQuery = session.getNamedQuery(queryName);
		String[] namedParameters = namedQuery.getNamedParameters();

		String sortSuffix = setSortSuffix(method, namedParameters, queryArgs, namedQuery);
		if (sortSuffix != null && sortSuffix.length() > 0) {
			namedQuery = session.createQuery(namedQuery.getQueryString() + sortSuffix);
		}

		if (namedParameters.length == 0) {
			setPositionalParams(queryArgs, namedQuery);
		} else {
			setNamedParams(method, namedParameters, queryArgs, namedQuery);
		}
		// session.re

		return namedQuery;
	}

	private String setSortSuffix(Method method, String[] namedParameters, Object[] queryArgs, Query namedQuery) {

		String sortSuffix = "";

		if (namedParameters != null) {
			boolean isOrderBy = false;
			boolean isOrderSort = false;
			for (String namedParameter : namedParameters) {
				if ("__orderBy".equalsIgnoreCase(namedParameter)) {
					isOrderBy = true;
				} else if ("__orderSort".equalsIgnoreCase(namedParameter)) {
					isOrderSort = true;
				}
			}
			if (!isOrderBy || !isOrderSort) {
				return sortSuffix;
			}
			Arrays.sort(namedParameters);
		}

		if (queryArgs != null) {
			String orderBy = null;
			String orderSort = null;

			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				Type argType = getArgumentTypeFactory().getArgumentType(arg);
				if (argType != null) {
				} else {
					if (!(arg instanceof Collection)) {
						if (namedParameters != null && namedParameters.length > i) {
							if (namedParameters[i].equalsIgnoreCase("__orderBy") && arg instanceof String) {
								orderBy = (String) arg;
							} else if (namedParameters[i].equalsIgnoreCase("__orderSort") && arg instanceof String) {
								orderSort = (String) arg;
							}
						}
					}
				}
			}
			if (orderBy != null && orderSort != null) {
				sortSuffix = " ORDER BY " + orderBy + " " + orderSort;
			}
		}
		return sortSuffix;
	}

	private void setPositionalParams(Object[] queryArgs, Query namedQuery) {

		/*- Set parameter. Use custom Hibernate Type if necessary -*/
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				Type argType = getArgumentTypeFactory().getArgumentType(arg);
				if (argType != null) {
					namedQuery.setParameter(i, arg, argType);
				} else {
					namedQuery.setParameter(i, arg);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private void setNamedParams(Method method, String[] namedParameters, Object[] queryArgs, Query namedQuery) {

		if (namedParameters != null) {
			Arrays.sort(namedParameters);
		}

		/*- method.get Set parameter. Use custom Hibernate Type if necessary -*/
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				Type argType = getArgumentTypeFactory().getArgumentType(arg);
				if (argType != null) {
					namedQuery.setParameter(namedParameters[i], arg, argType);
				} else {
					if (arg instanceof Collection) {
						namedQuery.setParameterList(namedParameters[i], (Collection) arg);
					} else {
						if (namedParameters[i].equalsIgnoreCase("_0_returnVO") && arg instanceof String) {
							try {
								namedQuery.setResultTransformer(Transformers.aliasToBean(Class.forName((String) arg)));
							} catch (ClassNotFoundException e) {
								throw new IllegalArgumentException(
										"Bad naming of Result Transformer: " + e.getLocalizedMessage());
							}
						} else if (namedParameters[i].equalsIgnoreCase("__limitFirstResult")
								&& arg instanceof Integer) {
							namedQuery.setFirstResult((Integer) arg);
						} else if (namedParameters[i].equalsIgnoreCase("__limitMaxResults") && arg instanceof Integer) {
							namedQuery.setMaxResults((Integer) arg);
						}
						namedQuery.setParameter(namedParameters[i], arg);
					}
				}
			}
		}
	}

	public FinderNamingStrategy getNamingStrategy() {

		return namingStrategy;
	}

	public void setNamingStrategy(FinderNamingStrategy namingStrategy) {

		this.namingStrategy = namingStrategy;
	}

	public FinderArgumentTypeFactory getArgumentTypeFactory() {

		return argumentTypeFactory;
	}

	public void setArgumentTypeFactory(FinderArgumentTypeFactory argumentTypeFactory) {

		this.argumentTypeFactory = argumentTypeFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

}
