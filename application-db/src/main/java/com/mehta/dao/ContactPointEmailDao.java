package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.ContactPointEmail;

public interface ContactPointEmailDao extends GenericDao<ContactPointEmail, Integer>{

	List<ContactPointEmail> findAll();	
}
