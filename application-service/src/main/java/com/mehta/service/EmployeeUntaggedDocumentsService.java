package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.EmployeeUntaggedDocumentsVo;

public interface EmployeeUntaggedDocumentsService {
	Long createEmployeeUntaggedDocumentsService(EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo,
			String loggedUserId);

	void updateEmployeeUntaggedDocumentsService(EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo,
			String loggedUserId);

	EmployeeUntaggedDocumentsVo readEmployeeUntaggedDocumentsService(Long id);

	List<EmployeeUntaggedDocumentsVo> listEmployeeUntaggedDocumentsService();
}
