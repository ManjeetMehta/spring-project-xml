package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.CfgRelationshipTypeVo;

public interface CfgRelationshipTypeService {

	Integer create(CfgRelationshipTypeVo cfgRelationshipTypeVo);

	void update(CfgRelationshipTypeVo cfgRelationshipTypeVo);

	CfgRelationshipTypeVo read(Integer id);

	void delete(Integer id);

	List<CfgRelationshipTypeVo> list();

}
