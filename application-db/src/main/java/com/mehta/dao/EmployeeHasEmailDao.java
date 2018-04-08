
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.EmployeeHasEmail;

public interface EmployeeHasEmailDao extends GenericDao<EmployeeHasEmail, Integer> {
	List<EmployeeHasEmail> 	findAll();	
}
