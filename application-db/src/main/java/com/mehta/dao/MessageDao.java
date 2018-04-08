
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.Message;

public interface MessageDao extends GenericDao<Message, Integer> {
	List<Message> findAll();
}
