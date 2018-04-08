package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.MessageHashTagVo;
import com.mehta.dao.MessageHashTagDao;
import com.mehta.dao.UserDao;
import com.mehta.model.MessageHashTag;
import com.mehta.service.MessageHashTagService;

@Component
public class MessageHashTagServiceImpl implements MessageHashTagService {

	@Autowired
	private MessageHashTagDao messageHashTagDao;

	@Autowired
	private UserDao userDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Integer createMessageHashTagService(MessageHashTagVo messageHashTagVo, String loggedUserId) {
		if (messageHashTagVo != null) {
			String tagName = messageHashTagVo.getTagName();
			String category = messageHashTagVo.getCategory();
			String subCategory = messageHashTagVo.getSubCategory();
			String token = messageHashTagVo.getToken();
			String description = messageHashTagVo.getDescription();
			Date created = new Date();
			Long createdBy = Long.parseLong(loggedUserId);
			Date lastModified = new Date();
			Long lastModifiedBy = Long.parseLong(loggedUserId);
			Long createdByTaskId = Long.parseLong(loggedUserId);

			MessageHashTag messageHashTag = new MessageHashTag(tagName, category, subCategory, token, description,
					created, createdBy, lastModified, lastModifiedBy, createdByTaskId);

			return messageHashTagDao.create(messageHashTag);

		} else {
			logger.warn("Object is Null...");
			return null;
		}
	}

	@Override
	public void updateMessageHashTagService(MessageHashTagVo messageHashTagVo, String loggedUserId) {

		if (messageHashTagVo != null && messageHashTagVo.getId() > 0) {
			MessageHashTag messageHashTag = messageHashTagDao.read(messageHashTagVo.getId());

			if (messageHashTag != null) {
				if (messageHashTagVo.getTagName() != null)
					messageHashTag.setTagName(messageHashTagVo.getTagName());

				if (messageHashTagVo.getCategory() != null)
					messageHashTag.setCategory(messageHashTagVo.getCategory());

				if (messageHashTagVo.getSubCategory() != null)
					messageHashTag.setSubCategory(messageHashTagVo.getSubCategory());

				if (messageHashTagVo.getToken() != null)
					messageHashTag.setToken(messageHashTagVo.getToken());

				if (messageHashTagVo.getDescription() != null)
					messageHashTag.setDescription(messageHashTagVo.getDescription());

				messageHashTag.setLastModified(new Date());
				messageHashTag.setLastModifiedBy(Long.parseLong(loggedUserId));

				messageHashTagDao.update(messageHashTag);
			} else
				logger.warn("Record not Found for updatation...");
		}
		logger.warn("object is null...");
	}

	@Override
	public MessageHashTagVo readMessageHashTagService(Integer id) {
		MessageHashTag messageHashTag = messageHashTagDao.read(id);

		if (messageHashTag != null) {

			MessageHashTagVo messageHashTagVo = new MessageHashTagVo(messageHashTag.getId());
			messageHashTagVo.setTagName(messageHashTag.getTagName());
			messageHashTagVo.setCategory(messageHashTag.getCategory());
			messageHashTagVo.setSubCategory(messageHashTag.getSubCategory());
			messageHashTagVo.setToken(messageHashTag.getToken());
			messageHashTagVo.setDescription(messageHashTag.getDescription());

			return messageHashTagVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<MessageHashTagVo> listMessageHashTagService() {
		List<MessageHashTag> messageHashTagList = messageHashTagDao.findAll();

		List<MessageHashTagVo> messageHashTagVoList = null;

		if (messageHashTagList.size() > 0) {
			messageHashTagVoList = new ArrayList<MessageHashTagVo>();

			for (MessageHashTag messageHashTag : messageHashTagList) {
				MessageHashTagVo messageHashTagVo = new MessageHashTagVo(messageHashTag.getId());
				messageHashTagVo.setTagName(messageHashTag.getTagName());
				messageHashTagVo.setCategory(messageHashTag.getCategory());
				messageHashTagVo.setSubCategory(messageHashTag.getSubCategory());
				messageHashTagVo.setToken(messageHashTag.getToken());
				messageHashTagVo.setDescription(messageHashTag.getDescription());

				messageHashTagVoList.add(messageHashTagVo);
			}

		} else {
			messageHashTagVoList = new ArrayList<MessageHashTagVo>(0);

		}
		return messageHashTagVoList;
	}

}
