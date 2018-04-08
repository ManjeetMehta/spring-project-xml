package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.ProcessInstanceUntaggedDocumentsVo;

public interface ProcessInstanceUntaggedDocumentsService {
	Long createProcessInstanceUntaggedDocumentsService(
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo, String loggedUserId);

	void updateProcessInstanceUntaggedDocumentsService(
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo, String loggedUserId);

	ProcessInstanceUntaggedDocumentsVo readProcessInstanceUntaggedDocumentsService(Long id);

	List<ProcessInstanceUntaggedDocumentsVo> listProcessInstanceUntaggedDocumentsService();
}
