package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.AgentSponsoredHasTaggedDocumentPermissions;

public interface AgentSponsoredHasTaggedDocumentPermissionsDao extends GenericDao<AgentSponsoredHasTaggedDocumentPermissions, Integer> {

	List<AgentSponsoredHasTaggedDocumentPermissions> findAll();	
}
