package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mehta.common.utils.GenericComputation;
import com.mehta.common.vo.SystemEmailVo;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.service.SystemEmailService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemEmailServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;
	private static EhCacheCacheManager ehCacheCacheManagerStatic;
	private static final Logger logger = LoggerFactory.getLogger(SystemEmailServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private SystemEmailService systemEmailService;

	@Autowired
	private SystemEmailDao systemEmailDao;

	private static Integer id = null;
	private String loggedUserId = "100";
	static SystemEmailVo systemEmailVo;

	static {
		String subject = "a";
		String subjectUniqueId = "b";
		String body = "c";
		String contentType = "d";
		String senderEmailId = "e";
		Date receiveTime = new Date();
		Date sendTime = new Date();
		Integer attachmentCount = 1;
		Date pullTime = new Date();
		String status = "f";
		String quartzJobId = "g";
		Integer parentId = 2;
		String subjectRefToken = "h";
		Boolean tagged = true;
		Boolean archrived = true;
		Boolean classified = true;
		Boolean fallbackLocked = true;
		Integer inOutFlag = 3;
		systemEmailVo = new SystemEmailVo(subject, subjectUniqueId, body, contentType, senderEmailId, receiveTime,
				sendTime, attachmentCount, pullTime, status, quartzJobId, parentId, subjectRefToken, tagged, archrived,
				classified, fallbackLocked, inOutFlag);
	}

	@Test
	public void test1Create() {
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
		}

		if (id == null || !(id > 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmail");
			return;
		}

		logger.info("Record created for SystemEmail with id:" + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		systemEmailVo.setId(id);

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

	@Test
	public void test3Read() {
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
				return;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return;
		}

		logger.info("Record  found  for SystemEmail with id:" + systemEmailVo.getId());

	}

	@Test
	public void test4List() {

		List<SystemEmailVo> systemEmailVoList = null;
		SystemEmailVo ailmentListVo = null;

		List<SystemEmail> systemEmailList = systemEmailDao.findAll();
		if (systemEmailList != null && systemEmailList.size() > 0) {
			systemEmailVoList = new ArrayList<>();
			for (SystemEmail systemEmail : systemEmailList)
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
					systemEmailVoList.add(ailmentListVo);
				}
		} else {
			logger.warn("List not found  for Object ");
			logger.info("List not found  for SystemEmail");
			return;
		}
		logger.info("List found the SystemEmail");
	}
}
