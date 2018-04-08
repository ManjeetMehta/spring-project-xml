package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.EmployeeHasEmailVo;

public interface EmployeeHasEmailService {

	Integer create(EmployeeHasEmailVo employeeHasEmailVo);

	void update(EmployeeHasEmailVo employeeHasEmailVo);

	EmployeeHasEmailVo read(Integer id);

	void delete(Integer id);

	List<EmployeeHasEmailVo> list();
}
