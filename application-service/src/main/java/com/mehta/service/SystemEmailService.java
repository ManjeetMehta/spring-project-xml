package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.SystemEmailVo;

public interface SystemEmailService {
	Integer createSystemEmailService(SystemEmailVo systemEmailVo, String loggedUserId) ;

	void updateSystemEmailService(SystemEmailVo systemEmailVo, String loggedUserId) ;

	SystemEmailVo readSystemEmailService(Integer id);

	List<SystemEmailVo> listSystemEmailService();
}
