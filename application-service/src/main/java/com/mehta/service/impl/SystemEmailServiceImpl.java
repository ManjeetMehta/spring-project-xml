package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.SystemEmailVo;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.service.SystemEmailService;

@Component
public class SystemEmailServiceImpl implements SystemEmailService {

	@Autowired
	private SystemEmailDao systemEmailDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemEmailServiceImpl.class);

	@Override
	public Integer createSystemEmailService(SystemEmailVo systemEmailVo, String loggedUserId) {
		Integer id = null;
		if (systemEmailVo != null) {
			String subject = systemEmailVo.getSubject();
			String subjectUniqueId = systemEmailVo.getSubjectUniqueId();
			String body = systemEmailVo.getBody();
			String contentType = systemEmailVo.getContentType();
			String senderEmailId = systemEmailVo.getSenderEmailId();
			Date receiveTime = systemEmailVo.getReceiveTime();
			Date sendTime = systemEmailVo.getSendTime();
			Integer attachmentCount = systemEmailVo.getAttachmentCount();
			Date pullTime = systemEmailVo.getPullTime();
			String status = systemEmailVo.getStatus();
			String quartzJobId = systemEmailVo.getQuartzJobId();
			Integer parentId = systemEmailVo.getParentId();
			String subjectRefToken = systemEmailVo.getSubjectRefToken();
			Boolean tagged = systemEmailVo.getTagged();
			Boolean archrived = systemEmailVo.getArchrived();
			Boolean classified = systemEmailVo.getClassified();
			Boolean fallbackLocked = systemEmailVo.getFallbackLocked();
			Integer inOutFlag = systemEmailVo.getInOutFlag();
			Date created = new Date();
			Long createdBy = Long.parseLong(loggedUserId);
			Date lastModified = new Date();
			Long lastModifiedBy = Long.parseLong(loggedUserId);
			Long createdByTaskId = Long.parseLong(loggedUserId);

			SystemEmail systemEmail = new SystemEmail(subject, subjectUniqueId, body, contentType, senderEmailId,
					receiveTime, sendTime, attachmentCount, pullTime, status, quartzJobId, parentId, subjectRefToken,
					tagged, archrived, classified, fallbackLocked, inOutFlag, created, createdBy, lastModified,
					lastModifiedBy, createdByTaskId);

			id = systemEmailDao.create(systemEmail);
		} else if (id == null || !(id >= 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmail");
			return null;
		}

		return id;

	}

	@Override
	public void updateSystemEmailService(SystemEmailVo systemEmailVo, String loggedUserId) {
		if (systemEmailVo != null && systemEmailVo.getId() != null) {
			SystemEmail systemEmail = systemEmailDao.read(systemEmailVo.getId());

			if (systemEmail != null) {
				systemEmail.setSubject(
						systemEmailVo.getSubject() != null ? systemEmailVo.getSubject() : systemEmail.getSubject());
				systemEmail.setSubjectUniqueId(systemEmailVo.getSubjectUniqueId() != null
						? systemEmailVo.getSubjectUniqueId() : systemEmail.getSubjectUniqueId());
				systemEmail.setBody(systemEmailVo.getBody() != null ? systemEmailVo.getBody() : systemEmail.getBody());
				systemEmail.setContentType(systemEmailVo.getContentType() != null ? systemEmailVo.getContentType()
						: systemEmail.getContentType());
				systemEmail.setSenderEmailId(systemEmailVo.getSenderEmailId() != null ? systemEmailVo.getSenderEmailId()
						: systemEmail.getSenderEmailId());
				systemEmail.setReceiveTime(systemEmailVo.getReceiveTime() != null ? systemEmailVo.getReceiveTime()
						: systemEmail.getReceiveTime());
				systemEmail.setSendTime(
						systemEmailVo.getSendTime() != null ? systemEmailVo.getSendTime() : systemEmail.getSendTime());
				systemEmail.setAttachmentCount(systemEmailVo.getAttachmentCount() != null
						? systemEmailVo.getAttachmentCount() : systemEmail.getAttachmentCount());
				systemEmail.setPullTime(
						systemEmailVo.getPullTime() != null ? systemEmailVo.getPullTime() : systemEmail.getPullTime());
				systemEmail.setStatus(
						systemEmailVo.getStatus() != null ? systemEmailVo.getStatus() : systemEmail.getStatus());
				systemEmail.setQuartzJobId(systemEmailVo.getQuartzJobId() != null ? systemEmailVo.getQuartzJobId()
						: systemEmail.getQuartzJobId());
				systemEmail.setParentId(
						systemEmailVo.getParentId() != null ? systemEmailVo.getParentId() : systemEmail.getParentId());
				systemEmail.setSubjectRefToken(systemEmailVo.getSubjectRefToken() != null
						? systemEmailVo.getSubjectRefToken() : systemEmail.getSubjectRefToken());
				systemEmail.setTagged(
						systemEmailVo.getTagged() != null ? systemEmailVo.getTagged() : systemEmail.getTagged());
				systemEmail.setArchrived(systemEmailVo.getArchrived() != null ? systemEmailVo.getArchrived()
						: systemEmail.getArchrived());
				systemEmail.setClassified(systemEmailVo.getClassified() != null ? systemEmailVo.getClassified()
						: systemEmail.getClassified());
				systemEmail.setFallbackLocked(systemEmailVo.getFallbackLocked() != null
						? systemEmailVo.getFallbackLocked() : systemEmail.getFallbackLocked());
				systemEmail.setInOutFlag(systemEmailVo.getInOutFlag() != null ? systemEmailVo.getInOutFlag()
						: systemEmail.getInOutFlag());
				systemEmail.setLastModified(new Date());
				systemEmail.setLastModifiedBy(Long.parseLong(loggedUserId));

				systemEmailDao.update(systemEmail);
			} else {
				logger.warn("Record not updated for Object with id:" + systemEmailVo.getId());
				logger.info("Record not updated for SystemEmail with id:" + systemEmailVo.getId());
				return;
			}
		} else {
			logger.warn("Either Object or its Id is null,not updated");
			logger.info("Either SystemEmail or its Id is null,not updated");
			return;
		}
		logger.info("Record updated for SystemEmail with id:" + systemEmailVo.getId());
	}

	@Override
	public SystemEmailVo readSystemEmailService(Integer id) {
		SystemEmailVo systemEmailVo = null;
		if (id != null) {
			SystemEmail systemEmail = systemEmailDao.read(id);
			if (systemEmail != null) {
				systemEmailVo = new SystemEmailVo(systemEmail.getId());
				systemEmailVo.setSubject(systemEmail.getSubject());
				systemEmailVo.setSubjectUniqueId(systemEmail.getSubjectUniqueId());
				systemEmailVo.setBody(systemEmail.getBody());
				systemEmailVo.setContentType(systemEmail.getContentType());
				systemEmailVo.setSenderEmailId(systemEmail.getSenderEmailId());
				systemEmailVo.setReceiveTime(systemEmail.getReceiveTime());
				systemEmailVo.setSendTime(systemEmail.getSendTime());
				systemEmailVo.setAttachmentCount(systemEmail.getAttachmentCount());
				systemEmailVo.setPullTime(systemEmail.getPullTime());
				systemEmailVo.setStatus(systemEmail.getStatus());
				systemEmailVo.setQuartzJobId(systemEmail.getQuartzJobId());
				systemEmailVo.setParentId(systemEmail.getParentId());
				systemEmailVo.setSubjectRefToken(systemEmail.getSubjectRefToken());
				systemEmailVo.setTagged(systemEmail.getTagged());
				systemEmailVo.setArchrived(systemEmail.getArchrived());
				systemEmailVo.setClassified(systemEmail.getClassified());
				systemEmailVo.setFallbackLocked(systemEmail.getFallbackLocked());
				systemEmailVo.setInOutFlag(systemEmail.getInOutFlag());
			} else {
				logger.warn("Record not found  for the given Object with id:" + id);
				logger.info("Record not found  for SystemEmail with id:" + id);
				return null;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return null;
		}
		return systemEmailVo;
	}

	@Override
	public List<SystemEmailVo> listSystemEmailService() {
		List<SystemEmail> systemEmailLists = systemEmailDao.findAll();
		List<SystemEmailVo> systemEmailVoList = null;
		SystemEmailVo systemEmailVo = null;
		if (systemEmailLists != null && systemEmailLists.size() > 0) {
			systemEmailVoList = new ArrayList<>();
			for (SystemEmail systemEmail : systemEmailLists) {
				if (systemEmail != null) {
					systemEmailVo = new SystemEmailVo(systemEmail.getId());
					systemEmailVo.setSubject(systemEmail.getSubject());
					systemEmailVo.setSubjectUniqueId(systemEmail.getSubjectUniqueId());
					systemEmailVo.setBody(systemEmail.getBody());
					systemEmailVo.setContentType(systemEmail.getContentType());
					systemEmailVo.setSenderEmailId(systemEmail.getSenderEmailId());
					systemEmailVo.setReceiveTime(systemEmail.getReceiveTime());
					systemEmailVo.setSendTime(systemEmail.getSendTime());
					systemEmailVo.setAttachmentCount(systemEmail.getAttachmentCount());
					systemEmailVo.setPullTime(systemEmail.getPullTime());
					systemEmailVo.setStatus(systemEmail.getStatus());
					systemEmailVo.setQuartzJobId(systemEmail.getQuartzJobId());
					systemEmailVo.setParentId(systemEmail.getParentId());
					systemEmailVo.setSubjectRefToken(systemEmail.getSubjectRefToken());
					systemEmailVo.setTagged(systemEmail.getTagged());
					systemEmailVo.setArchrived(systemEmail.getArchrived());
					systemEmailVo.setClassified(systemEmail.getClassified());
					systemEmailVo.setFallbackLocked(systemEmail.getFallbackLocked());
					systemEmailVo.setInOutFlag(systemEmail.getInOutFlag());
					systemEmailVoList.add(systemEmailVo);
				}
			}
		} else {
			logger.warn("List not found  for Object");
			logger.info("List not found  for SystemEmail");
			return null;
		}
		return systemEmailVoList;
	}
}
