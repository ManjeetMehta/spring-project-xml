package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.CustomerCorporateHasTaggedDocumentPermissionsVo;

public interface CustomerCorporateHasTaggedDocumentPermissionsService {

	Integer customerCorporateHasTaggedDocumentPermissionsCreate(
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo,
			String userId);

	void customerCorporateHasTaggedDocumentPermissionsUpdate(
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo,
			String userId);

	CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsRead(Integer id);

	List<CustomerCorporateHasTaggedDocumentPermissionsVo> customerCorporateHasTaggedDocumentPermissionsList();
}
