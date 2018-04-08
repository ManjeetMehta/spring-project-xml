package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.Cdr;

public interface CdrDao extends GenericDao<Cdr, Integer>{
	
	List<Object[]> findAllByDate(String dateString);

}
