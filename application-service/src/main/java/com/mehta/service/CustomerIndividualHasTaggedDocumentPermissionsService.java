package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.CustomerIndividualHasTaggedDocumentPermissionsVo;

public interface CustomerIndividualHasTaggedDocumentPermissionsService {

	Integer customerIndividualHasTaggedDocumentPermissionsCreate(
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo,
			String userId);

	void customerIndividualHasTaggedDocumentPermissionsUpdate(
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo,
			String userId);

	CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsRead(Integer id);

	List<CustomerIndividualHasTaggedDocumentPermissionsVo> customerIndividualHasTaggedDocumentPermissionsList();
}
