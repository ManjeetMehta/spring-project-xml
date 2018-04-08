package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.MessageHashTagVo;

public interface MessageHashTagService {
	public Integer createMessageHashTagService(MessageHashTagVo messageHashTagVo, String loggedUserId);

	public void updateMessageHashTagService(MessageHashTagVo messageHashTagVo, String loggedUserId);

	public MessageHashTagVo readMessageHashTagService(Integer id);

	public List<MessageHashTagVo> listMessageHashTagService();
}
