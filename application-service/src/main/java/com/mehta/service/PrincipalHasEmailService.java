package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.PrincipalHasEmailVo;

public interface PrincipalHasEmailService {
	Integer create(PrincipalHasEmailVo principalHasEmailVo);

	void update(PrincipalHasEmailVo principalHasEmailVo);

	PrincipalHasEmailVo read(Integer id);

	void delete(Integer id);

	List<PrincipalHasEmailVo> list();
}
