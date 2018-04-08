package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.MessageVo;
import com.mehta.dao.MessageDao;
import com.mehta.dao.MessageHashTagDao;
import com.mehta.dao.UserDao;
import com.mehta.model.Message;
import com.mehta.model.MessageHashTag;
import com.mehta.model.User;
import com.mehta.service.MessageService;

@Component
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private MessageHashTagDao messageHashTagDao;

	@Autowired
	private UserDao userDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Integer createMessageService(MessageVo messageVo, String loggedUserId) {
		if (messageVo != null) {
			String message = messageVo.getMessage();
			Boolean isReopened = messageVo.getIsReopened();
			Integer groupId = messageVo.getGroupId();
			Date created = new Date();
			Long createdByTaskId = Long.parseLong(loggedUserId);

			User user = null;
			if (messageVo.getUserId() != null) {
				user = userDao.read(messageVo.getUserId());
				if (user == null) {
					logger.warn("Parent Id of (User) is Not Matched.... (Record Not Created)");
					return null;
				}
			} else {
				logger.warn("Parent Id of (user) is null.... ");
				return null;
			}

			User taggedUser = null;
			if (messageVo.getTaggedUser() != null) {
				taggedUser = userDao.read(messageVo.getTaggedUser());
				if (taggedUser == null) {
					logger.warn("Parent Id of (taggedUser) is Not Matched.... (Record Not Created)");
					return null;
				}
			} else
				logger.warn("Parent Id of (taggedUser) is null.... ");

			MessageHashTag messageHashTag = null;
			if (messageVo.getMessageHashTagId() != null) {
				messageHashTag = messageHashTagDao.read(messageVo.getMessageHashTagId());
				if (messageHashTag == null) {
					logger.warn("Parent Id of (messageHashTag) is Not Matched.... (Record Not Created)");
					return null;
				}
			} else
				logger.warn("Parent Id of (messageHashTag) is null.... ");

			if (message == null) {
				logger.warn("message is not available...");
				return null;
			}

			Message messageObj = new Message(message, isReopened, user, messageHashTag, groupId, taggedUser, created,
					createdByTaskId);

			return messageDao.create(messageObj);
		}
		return null;

	}

	@Override
	public void updateMessageService(MessageVo messageVo, String loggedUserId) {

		Message message = messageDao.read(messageVo.getId());

		if (message != null) {

			User user = null;
			if (messageVo.getUserId() != null) {
				user = userDao.read(messageVo.getUserId());
				if (user == null) {
					logger.warn("Parent Id of (User) is Not Matched.... (Record Not Created)");
					return;
				} else
					message.setUser(user);
			} else
				logger.warn("Parent Id of (user) is null....");

			User taggedUser = null;
			if (messageVo.getTaggedUser() != null) {
				taggedUser = userDao.read(messageVo.getTaggedUser());
				if (taggedUser == null) {
					logger.warn("Parent Id of (User) is Not Matched.... (Record Not Created)");
					return;
				} else
					message.setUser(taggedUser);
			} else
				logger.warn("Parent Id of (user) is null....");

			MessageHashTag messageHashTag = null;
			if (messageVo.getMessageHashTagId() != null) {
				messageHashTag = messageHashTagDao.read(messageVo.getMessageHashTagId());
				if (messageHashTag == null) {
					logger.warn("Parent Id of (messageHashTag) is Not Matched.... (Record Not Created)");
					return;
				} else
					message.setMessageHashTag(messageHashTag);
			} else
				logger.warn("Parent Id of (messageHashTag) is null....");

			if (messageVo.getMessage() != null)
				message.setMessage(messageVo.getMessage());
			if (messageVo.getIsReopened() != null)
				message.setIsReopened(messageVo.getIsReopened());
			if (messageVo.getGroupId() != null)
				message.setGroupId(messageVo.getGroupId());

			messageDao.update(message);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}
	}

	@Override
	public MessageVo readMessageService(Integer id) {
		Message message = messageDao.read(id);

		if (message != null) {

			MessageVo messageVo = new MessageVo(message.getId());

			messageVo.setMessage(message.getMessage());
			messageVo.setIsReopened(message.getIsReopened());
			messageVo.setGroupId(message.getGroupId());

			if (message.getUser() != null)
				messageVo.setUserId(message.getUser().getId());
			if (message.getTaggedUser() != null)
				messageVo.setTaggedUser(message.getTaggedUser().getId());
			if (message.getMessageHashTag() != null)
				messageVo.setMessageHashTagId(message.getMessageHashTag().getId());

			return messageVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<MessageVo> listMessageService() {
		List<Message> messageList = messageDao.findAll();

		List<MessageVo> messageVoList = null;

		if (messageList.size() > 0) {
			messageVoList = new ArrayList<MessageVo>();

			for (Message message : messageList) {

				MessageVo messageVo = new MessageVo(message.getId());

				messageVo.setMessage(message.getMessage());
				messageVo.setIsReopened(message.getIsReopened());
				messageVo.setGroupId(message.getGroupId());

				if (message.getUser() != null)
					messageVo.setUserId(message.getUser().getId());
				if (message.getTaggedUser() != null)
					messageVo.setTaggedUser(message.getTaggedUser().getId());
				if (message.getMessageHashTag() != null)
					messageVo.setMessageHashTagId(message.getMessageHashTag().getId());

				messageVoList.add(messageVo);
			}

		} else {
			messageVoList = new ArrayList<MessageVo>(0);

		}
		return messageVoList;
	}

}
