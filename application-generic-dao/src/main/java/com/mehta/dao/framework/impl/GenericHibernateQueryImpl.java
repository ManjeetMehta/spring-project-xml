package com.mehta.dao.framework.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericHibernateQueryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public void executeQuery() {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("");
		sqlQuery.list();
	}
}
