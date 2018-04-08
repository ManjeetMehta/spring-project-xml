
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CfgDocumentClassRole;

public interface CfgDocumentClassRoleDao extends GenericDao<CfgDocumentClassRole, Integer> {
	List<CfgDocumentClassRole> 	findAll();	
}
