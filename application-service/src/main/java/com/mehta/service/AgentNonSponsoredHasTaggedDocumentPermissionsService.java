package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.AgentNonSponsoredHasTaggedDocumentPermissionsVo;

public interface AgentNonSponsoredHasTaggedDocumentPermissionsService {

	Integer agentNonSponsoredHasTaggedDocumentPermissionsCreate(
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo,
			String userId);

	void agentNonSponsoredHasTaggedDocumentPermissionsUpdate(
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo,
			String userId);

	AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsRead(Integer id);

	List<AgentNonSponsoredHasTaggedDocumentPermissionsVo> agentNonSponsoredHasTaggedDocumentPermissionsList();
}
