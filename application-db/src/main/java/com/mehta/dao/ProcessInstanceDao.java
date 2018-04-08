
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.ProcessInstance;

public interface ProcessInstanceDao extends GenericDao<ProcessInstance, Long> {
	List<ProcessInstance> findAll();
}
