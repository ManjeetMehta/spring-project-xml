package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.PrincipalHasTaggedDocumentPermissions;

public interface PrincipalHasTaggedDocumentPermissionsDao
		extends GenericDao<PrincipalHasTaggedDocumentPermissions, Integer> {

	List<PrincipalHasTaggedDocumentPermissions> findAll();
}
