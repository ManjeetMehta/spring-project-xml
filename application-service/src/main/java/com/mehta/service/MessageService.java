package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.MessageVo;

public interface MessageService {
	public Integer createMessageService(MessageVo messageVo, String loggedUserId);

	public void updateMessageService(MessageVo messageVo, String loggedUserId);

	public MessageVo readMessageService(Integer id);

	public List<MessageVo> listMessageService();
}
