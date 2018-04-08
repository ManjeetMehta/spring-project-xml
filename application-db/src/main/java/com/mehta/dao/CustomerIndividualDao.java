package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CustomerIndividual;

public interface CustomerIndividualDao extends GenericDao<CustomerIndividual, Integer> {

	List<CustomerIndividual> findAll();	
}
