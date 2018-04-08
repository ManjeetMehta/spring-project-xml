package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.MessageThread;

public interface MessageThreadDao extends GenericDao<MessageThread, Integer> {
	List<MessageThread> findAll();

}
