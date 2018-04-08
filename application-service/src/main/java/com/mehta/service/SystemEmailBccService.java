package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.SystemEmailBccVo;

public interface SystemEmailBccService {
	Integer createSystemEmailBccService(SystemEmailBccVo systemEmailBccVo, String loggedUserId);

	void updateSystemEmailBccService(SystemEmailBccVo systemEmailBccVo, String loggedUserId);

	SystemEmailBccVo readSystemEmailBccService(Integer id);

	List<SystemEmailBccVo> listSystemEmailBccService();
}
