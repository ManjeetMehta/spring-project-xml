
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.SystemEmail;

public interface SystemEmailDao extends GenericDao<SystemEmail, Integer> {
	List<SystemEmail> findAll();
}
