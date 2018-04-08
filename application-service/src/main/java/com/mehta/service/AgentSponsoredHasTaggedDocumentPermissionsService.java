package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.AgentSponsoredHasTaggedDocumentPermissionsVo;

public interface AgentSponsoredHasTaggedDocumentPermissionsService {

	Integer create(AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsvo,
			String userId);

	void update(AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo,
			String userId);

	AgentSponsoredHasTaggedDocumentPermissionsVo read(Integer id);

	List<AgentSponsoredHasTaggedDocumentPermissionsVo> list();
}
