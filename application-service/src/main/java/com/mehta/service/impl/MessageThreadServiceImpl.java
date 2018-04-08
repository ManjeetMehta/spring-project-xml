package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.MessageThreadVo;
import com.mehta.dao.MessageDao;
import com.mehta.dao.MessageHashTagDao;
import com.mehta.dao.MessageThreadDao;
import com.mehta.dao.UserDao;
import com.mehta.model.Message;
import com.mehta.model.MessageHashTag;
import com.mehta.model.MessageThread;
import com.mehta.model.User;
import com.mehta.service.MessageThreadService;

@Component
public class MessageThreadServiceImpl implements MessageThreadService {

	@Autowired
	private MessageThreadDao messageThreadDao;

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private MessageHashTagDao messageHashTagDao;

	private static final Logger logger = LoggerFactory.getLogger(MessageThreadServiceImpl.class);

	@Override
	public Integer createMessageThreadService(MessageThreadVo messageThreadVo, String loggedUserId) {

		Message messageId = null;
		if (messageThreadVo.getMessageId() != null) {
			messageId = messageDao.read(messageThreadVo.getMessageId());
			if (messageId == null) {
				logger.warn("Parent Id Of(Message Id) Not Matched (Record Not Created)");
				return null;
			}
		} else {
			logger.warn(" Message Id Not Be Null (Record Not Created)");
			return null;
		}

		String message = messageThreadVo.getMessage();

		MessageHashTag messageHashTag = null;
		if (messageThreadVo.getMessageHashTag() != null) {
			messageHashTag = messageHashTagDao.read(messageThreadVo.getMessageHashTag());
			if (messageHashTag == null) {
				logger.warn("Parent Id Of(Message Hash Tag Id)Not Matched (Record Not Created)");
				return null;
			}
		}
		Boolean isReopened = messageThreadVo.getIsReopened();

		User user = null;
		if (messageThreadVo.getUserId() != null) {
			user = userDao.read(messageThreadVo.getUserId());
			if (user == null) {
				logger.warn("Parent Id Of(User Id) Not Matched (Record Not Created)");
				return null;
			}
		} else {
			logger.warn(" User Id Not Be Null (Record Not Created)");
			return null;
		}

		User taggedUser = null;
		if (messageThreadVo.getTaggedUser() != null) {
			taggedUser = userDao.read(messageThreadVo.getTaggedUser());
			if (taggedUser == null) {
				logger.warn("Parent Id  Of(User Id) Not Matched (Record Not Created)");
				return null;
			}
		}

		Date created = new Date();
		Long createdByTaskId = Long.parseLong(loggedUserId);

		MessageThread messageThread = new MessageThread(messageId, message, messageHashTag, isReopened, user,
				taggedUser, created, createdByTaskId);

		Integer id = messageThreadDao.create(messageThread);
		if (id <= 0) {
			logger.warn("Record Not Created");
			return null;
		} else {
			logger.info("Record  Created For Message Thread");
			return id;
		}

	}

	@Override
	public void updateMessageThreadService(MessageThreadVo messageThreadVo, String loggedUserId) {

		if (messageThreadVo != null && messageThreadVo.getId() != null) {
			MessageThread messageThread = messageThreadDao.read(messageThreadVo.getId());

			Message messageId = null;
			if (messageThreadVo.getMessageId() != null) {
				messageId = messageDao.read(messageThreadVo.getMessageId());
				if (messageId == null) {
					logger.warn("Parent Id Of(Message Id) Not Matched (Record Not Updated)");
					return;
				} else {
					messageThread.setMessageId(messageId);
				}
			}

			if (messageThreadVo.getMessage() != null)
				messageThread.setMessage(messageThreadVo.getMessage());

			MessageHashTag messageHashTag = null;
			if (messageThreadVo.getMessageHashTag() != null) {
				messageHashTag = messageHashTagDao.read(messageThreadVo.getMessageHashTag());
				if (messageHashTag == null) {
					logger.warn("Parent Id Of(Message Hash Tag Id)Not Matched (Record Not Updated)");
					return;
				} else {
					messageThread.setMessageHashTag(messageHashTag);
				}
			}

			if (messageThreadVo.getIsReopened() != null)
				messageThread.setIsReopened(messageThreadVo.getIsReopened());

			User user = null;
			if (messageThreadVo.getUserId() != null) {
				user = userDao.read(messageThreadVo.getUserId());
				if (user == null) {
					logger.warn("Parent Id Of(User Id) Not Matched (Record Not Updated)");
					return;
				} else {
					messageThread.setUser(user);
				}
			}
			User taggedUser = null;
			if (messageThreadVo.getTaggedUser() != null) {
				taggedUser = userDao.read(messageThreadVo.getTaggedUser());
				if (taggedUser == null) {
					logger.warn("Parent Id  Of(User Id) Not Matched (Record Not Updated)");
					return;
				} else {
					messageThread.setTaggedUser(taggedUser);
				}
			}
			messageThreadDao.update(messageThread);
			logger.info(" Record  Updated For Message Thread");
		} else {
			logger.warn("Message Thread And Id Can Not Be Null ,Record Not Updated");
			return;
		}
	}

	@Override
	public MessageThreadVo readMessageThreadService(Integer id) {

		if (id != null) {
			MessageThread messageThread = messageThreadDao.read(id);

			if (messageThread != null) {

				MessageThreadVo messageThreadVo = new MessageThreadVo(id);

				if (messageThread.getMessageId() != null && messageThread.getMessageId().getId() != null) {
					messageThreadVo.setMessageId(messageThread.getMessageId().getId());
				} else {
					messageThreadVo.setMessageId(null);
				}

				messageThreadVo.setMessage(messageThread.getMessage());

				if (messageThread.getMessageHashTag() != null && messageThread.getMessageHashTag().getId() != null) {
					messageThreadVo.setMessageHashTag(messageThread.getMessageHashTag().getId());
				} else {
					messageThreadVo.setMessageHashTag(null);
				}

				messageThreadVo.setIsReopened(messageThread.getIsReopened());

				if (messageThread.getUser() != null && messageThread.getUser().getId() != null) {
					messageThreadVo.setUserId(messageThread.getUser().getId());
				} else {
					messageThreadVo.setUserId(null);
				}

				if (messageThread.getTaggedUser() != null && messageThread.getTaggedUser().getId() != null) {
					messageThreadVo.setTaggedUser(messageThread.getTaggedUser().getId());
				} else {
					messageThreadVo.setTaggedUser(null);
				}

				logger.info(" Record Read For Message Thread ");

				return messageThreadVo;
			} else {
				logger.warn(" Record Not Read For Message Thread ");
				return null;
			}
		} else {
			logger.warn(" Id Can Not be Null ,Record Not Read For Message Thread ");
			return null;

		}
	}

	@Override
	public List<MessageThreadVo> listMessageThreadService() {
		List<MessageThread> messageThreadList = messageThreadDao.findAll();

		List<MessageThreadVo> messageThreadVoList = null;

		if (messageThreadList.size() > 0) {
			messageThreadVoList = new ArrayList<MessageThreadVo>();

			for (MessageThread messageThread : messageThreadList) {

				MessageThreadVo messageThreadVo = new MessageThreadVo(messageThread.getId());

				if (messageThread.getMessageId() != null && messageThread.getMessageId().getId() != null) {
					messageThreadVo.setMessageId(messageThread.getMessageId().getId());
				} else {
					messageThreadVo.setMessageId(null);
				}

				messageThreadVo.setMessage(messageThread.getMessage());

				if (messageThread.getMessageHashTag() != null && messageThread.getMessageHashTag().getId() != null) {
					messageThreadVo.setMessageHashTag(messageThread.getMessageHashTag().getId());
				} else {
					messageThreadVo.setMessageHashTag(null);
				}

				messageThreadVo.setIsReopened(messageThread.getIsReopened());

				if (messageThread.getUser() != null && messageThread.getUser().getId() != null) {
					messageThreadVo.setUserId(messageThread.getUser().getId());
				} else {
					messageThreadVo.setUserId(null);
				}

				if (messageThread.getTaggedUser() != null && messageThread.getTaggedUser().getId() != null) {
					messageThreadVo.setTaggedUser(messageThread.getTaggedUser().getId());
				} else {
					messageThreadVo.setTaggedUser(null);
				}

				messageThreadVoList.add(messageThreadVo);
			}

		} else {
			messageThreadVoList = new ArrayList<MessageThreadVo>(0);

		}
		return messageThreadVoList;
	}

}
