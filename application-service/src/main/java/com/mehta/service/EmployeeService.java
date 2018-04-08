package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.EmployeeVo;

public interface EmployeeService {

	Integer create(EmployeeVo employeeVo);

	void update(EmployeeVo employeeVo);

	EmployeeVo read(Integer id);

	void delete(Integer id);

	List<EmployeeVo> list();
}
