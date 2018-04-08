
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.SystemEmailCc;

public interface SystemEmailCcDao extends GenericDao<SystemEmailCc, Integer> {
	List<SystemEmailCc> findAll();
}
