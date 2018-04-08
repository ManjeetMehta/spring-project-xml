package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.Role;

public interface RoleDao extends GenericDao<Role, Integer> {
	public List<Role> findAll();

}
