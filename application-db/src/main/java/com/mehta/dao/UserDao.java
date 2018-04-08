
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.User;

public interface UserDao extends GenericDao<User, Integer> {
	List<User> findAll();
}
