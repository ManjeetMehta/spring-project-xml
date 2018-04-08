package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CfgRelationshipType;

public interface CfgRelationshipTypeDao extends GenericDao< CfgRelationshipType, Integer> {
	List<CfgRelationshipType> findAll();	
}
