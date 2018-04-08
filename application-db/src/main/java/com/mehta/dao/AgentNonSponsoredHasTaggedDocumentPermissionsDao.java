package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.AgentNonSponsoredHasTaggedDocumentPermissions;

public interface AgentNonSponsoredHasTaggedDocumentPermissionsDao extends GenericDao<AgentNonSponsoredHasTaggedDocumentPermissions, Integer> {

	List<AgentNonSponsoredHasTaggedDocumentPermissions> findAll();	
}
