package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.PrincipalHasTaggedDocumentPermissionsVo;

public interface PrincipalHasTaggedDocumentPermissionsService {

	Integer principalHasTaggedDocumentPermissionsCreate(
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo, String userId);

	void principalHasTaggedDocumentPermissionsUpdate(
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo, String userId);

	PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsRead(Integer id);

	List<PrincipalHasTaggedDocumentPermissionsVo> principalHasTaggedDocumentPermissionsList();
}
