
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {
	List<Employee> 	findAll();	
}
