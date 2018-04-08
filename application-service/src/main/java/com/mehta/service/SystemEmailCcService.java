package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.SystemEmailCcVo;

public interface SystemEmailCcService {
	Integer createSystemEmailCcService(SystemEmailCcVo systemEmailCcVo, String loggedUserId) ;

	void updateSystemEmailCcService(SystemEmailCcVo systemEmailCcVo, String loggedUserId) ;

	SystemEmailCcVo readSystemEmailCcService(Integer id);

	List<SystemEmailCcVo> listSystemEmailCcService();
}
