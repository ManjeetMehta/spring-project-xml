package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CfgDocumentClass;

public interface CfgDocumentClassDao extends GenericDao<CfgDocumentClass, Integer> {

	public List<CfgDocumentClass> findAll();
}
