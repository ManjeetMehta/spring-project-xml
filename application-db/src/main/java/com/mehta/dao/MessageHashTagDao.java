
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.MessageHashTag;

public interface MessageHashTagDao extends GenericDao<MessageHashTag, Integer> {
	List<MessageHashTag> findAll();
}
