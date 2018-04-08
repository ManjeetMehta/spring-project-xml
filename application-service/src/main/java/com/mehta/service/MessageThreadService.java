package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.MessageThreadVo;

public interface MessageThreadService {
	public Integer createMessageThreadService(MessageThreadVo messageThreadVo, String loggedUserId);

	public void updateMessageThreadService(MessageThreadVo messageThreadVo, String loggedUserId);

	public MessageThreadVo readMessageThreadService(Integer id);

	public List<MessageThreadVo> listMessageThreadService();
}
