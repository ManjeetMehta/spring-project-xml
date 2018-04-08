
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.Principal;

public interface PrincipalDao extends GenericDao<Principal, Integer> {
	List<Principal> findAll();
}
