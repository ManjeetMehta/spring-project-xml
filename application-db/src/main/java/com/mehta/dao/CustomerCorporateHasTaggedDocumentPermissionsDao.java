package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CustomerCorporateHasTaggedDocumentPermissions;

public interface CustomerCorporateHasTaggedDocumentPermissionsDao extends GenericDao<CustomerCorporateHasTaggedDocumentPermissions, Integer> {

	List<CustomerCorporateHasTaggedDocumentPermissions> findAll();	
}
