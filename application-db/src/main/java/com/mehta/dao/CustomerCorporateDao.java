package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CustomerCorporate;

public interface CustomerCorporateDao extends GenericDao<CustomerCorporate, Integer> {

	List<CustomerCorporate> findAll();	
}
