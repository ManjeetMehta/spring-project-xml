package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.CfgDocumentClassRoleVo;

public interface CfgDocumentClassRoleService {
	Integer create(CfgDocumentClassRoleVo cfgDocumentClassRoleVo);

	void update(CfgDocumentClassRoleVo cfgDocumentClassRoleVo);

	CfgDocumentClassRoleVo read(Integer id);

	List<CfgDocumentClassRoleVo> list();
}
