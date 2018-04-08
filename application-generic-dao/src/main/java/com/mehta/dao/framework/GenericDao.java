
package com.mehta.dao.framework;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GenericDao<T, PK extends Serializable> {

	public PK create(T newInstance);

	public Set<PK> createList(Set<T> newInstanceSet);

	@SuppressWarnings("rawtypes")
	public List<PK> createGenericBatch(Map<Class, List<Object>> objectVoMap);

	public T read(PK id);

	void update(T transientObject);

	public void saveOrUpdate(T object);

	public void merge(T object);

	public void executeQuery(String sqlQuery);

	public void executeQueryMap(Map<String, Object> objectMap);

	public void evict(T object);

	public void flush();

	public void delete(T persistentObject);

	/**
	 *
	 * @param objArrayList
	 * @param object
	 * @param excludedFieldNames
	 * @param includedFieldNames
	 * @return List<Object>
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public List<Object> convertToObjectList(List<Object[]> objArrayList, Object object, List<String> excludedFieldNames,
			List<String> includedFieldNames)
					throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
