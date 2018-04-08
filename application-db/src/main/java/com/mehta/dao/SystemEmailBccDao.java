
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.SystemEmailBcc;

public interface SystemEmailBccDao extends GenericDao<SystemEmailBcc, Integer> {
	List<SystemEmailBcc> findAll();
}
