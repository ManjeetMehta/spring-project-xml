package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.ProcessInstanceHasTaggedDocumentPermissions;

public interface ProcessInstanceHasTaggedDocumentPermissionsDao
		extends GenericDao<ProcessInstanceHasTaggedDocumentPermissions, Integer> {

	List<ProcessInstanceHasTaggedDocumentPermissions> findAll();
}
