
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.PrincipalHasEmail;

public interface PrincipalHasEmailDao extends GenericDao<PrincipalHasEmail, Integer> {
	List<PrincipalHasEmail> findAll();
}
