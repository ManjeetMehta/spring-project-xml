package com.mehta.service;

import java.util.List;
import java.util.Set;

import com.mehta.common.vo.PrincipalVo;

public interface PrincipalService {
	Integer create(PrincipalVo principalVo);

	Set<Integer> createList(Set<PrincipalVo> principalVoSet);

	void update(PrincipalVo principalVo);

	void merge(PrincipalVo principalVo);

	void executeQuery(PrincipalVo principalVo);

	void executeQueryMap(PrincipalVo principalVo);

	PrincipalVo read(Integer id);

	void delete(Integer id);

	List<PrincipalVo> list();
}
