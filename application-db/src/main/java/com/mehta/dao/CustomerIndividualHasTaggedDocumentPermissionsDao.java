package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.CustomerIndividualHasTaggedDocumentPermissions;

public interface CustomerIndividualHasTaggedDocumentPermissionsDao extends GenericDao<CustomerIndividualHasTaggedDocumentPermissions, Integer> {

	List<CustomerIndividualHasTaggedDocumentPermissions> findAll();	
}
