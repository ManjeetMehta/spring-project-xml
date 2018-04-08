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
import com.mehta.common.vo.SystemEmailCcVo;
import com.mehta.dao.SystemEmailCcDao;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.model.SystemEmailCc;
import com.mehta.service.SystemEmailCcService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemEmailCcServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;
	private static EhCacheCacheManager ehCacheCacheManagerStatic;
	private static final Logger logger = LoggerFactory.getLogger(SystemEmailCcServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private SystemEmailCcService systemEmailCcService;

	@Autowired
	private SystemEmailDao systemEmailDao;

	@Autowired
	private SystemEmailCcDao systemEmailCcDao;

	private static Integer id = null;
	private String loggedUserId = "100";
	static SystemEmailCcVo systemEmailCcVo = null;

	static {
		Integer systemEmailId = 1;
		String emailAddress = "abc@gmail.com";

		systemEmailCcVo = new SystemEmailCcVo(systemEmailId, emailAddress);
	}

	@Test
	public void test1Create() {
		if (systemEmailCcVo != null) {

			SystemEmail systemEmail = null;
			if (systemEmailCcVo.getSystemEmailId() != null) {
				systemEmail = systemEmailDao.read(systemEmailCcVo.getSystemEmailId());
				if (systemEmail == null) {
					logger.warn("Object ParentId  is Not Matched.... (Record Not Created)");
					logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Created)");
					return;
				}
			} else {
				logger.warn("object parentId is null.... (Record Not Created)");
				logger.info("ParentId (SystemEmail) is null.... (Record Not Created)");
				return;
			}

			String emailAddress = systemEmailCcVo.getEmailAddress();
			if (emailAddress == null) {
				logger.warn("Object having some null value.... (Record Not Created)");
				logger.info("emailAddress is null.... (Record Not Created)");
				return;
			}

			Date created = new Date();
			Long createdBy = Long.parseLong(loggedUserId);
			Date lastModified = new Date();
			Long lastModifiedBy = Long.parseLong(loggedUserId);
			Long createdByTaskId = Long.parseLong(loggedUserId);

			SystemEmailCc systemEmailCc = new SystemEmailCc(systemEmail, emailAddress, created, createdBy, lastModified,
					lastModifiedBy, createdByTaskId);

			id = systemEmailCcDao.create(systemEmailCc);
		} else if (id == null || !(id >= 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmailCc");
			return;
		}

		logger.info("Record created for SystemEmail with id:" + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		systemEmailCcVo.setId(id);

		if (systemEmailCcVo != null && systemEmailCcVo.getId() != null) {
			SystemEmailCc systemEmailCc = systemEmailCcDao.read(systemEmailCcVo.getId());

			if (systemEmailCc != null) {

				SystemEmail systemEmail = null;
				if (systemEmailCcVo.getSystemEmailId() != null) {
					systemEmail = systemEmailDao.read(systemEmailCcVo.getSystemEmailId());
					if (systemEmail == null) {
						logger.warn("Object ParentId  is Not Matched.... (Record Not Updated)");
						logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Updated)");
						return;
					}
				}

				systemEmailCc.setSystemEmail(systemEmail != null ? systemEmail : systemEmailCc.getSystemEmail());
				systemEmailCc.setEmailAddress(systemEmailCcVo.getEmailAddress() != null
						? systemEmailCcVo.getEmailAddress() : systemEmailCc.getEmailAddress());
				systemEmailCc.setLastModified(new Date());
				systemEmailCc.setLastModifiedBy(Long.parseLong(loggedUserId));

				systemEmailCcDao.update(systemEmailCc);
			} else {
				logger.warn("Record not updated for Object with id:" + systemEmailCcVo.getId());
				logger.info("Record not updated for SystemEmailCc with id:" + systemEmailCcVo.getId());
				return;
			}
		} else {
			logger.warn("Either Object or its Id is null,not updated");
			logger.info("Either SystemEmailCc or its Id is null,not updated");
			return;
		}
		logger.info("Record updated for SystemEmail with id:" + systemEmailCcVo.getId());
	}

	@Test
	public void test3Read() {
		if (id != null) {
			SystemEmailCc systemEmailCc = systemEmailCcDao.read(id);
			if (systemEmailCc != null) {
				systemEmailCcVo = new SystemEmailCcVo(systemEmailCc.getId());
				systemEmailCcVo.setSystemEmailId(
						systemEmailCc.getSystemEmail() != null ? systemEmailCc.getSystemEmail().getId() : null);
				systemEmailCcVo.setEmailAddress(systemEmailCc.getEmailAddress());

			} else {
				logger.warn("Record not found  for the given Object with id:" + id);
				logger.info("Record not found  for SystemEmailCc with id:" + id);
				return;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return;
		}

		logger.info("Record  found  for SystemEmail with id:" + systemEmailCcVo.getId());

	}

	@Test
	public void test4List() {

		List<SystemEmailCc> systemEmailCcLists = systemEmailCcDao.findAll();
		List<SystemEmailCcVo> systemEmailCcVoList = null;
		SystemEmailCcVo systemEmailCcVo = null;
		if (systemEmailCcLists != null && systemEmailCcLists.size() > 0) {
			systemEmailCcVoList = new ArrayList<>();
			for (SystemEmailCc systemEmailCc : systemEmailCcLists) {
				if (systemEmailCc != null) {
					systemEmailCcVo = new SystemEmailCcVo(systemEmailCc.getId());
					systemEmailCcVo.setSystemEmailId(
							systemEmailCc.getSystemEmail() != null ? systemEmailCc.getSystemEmail().getId() : null);
					systemEmailCcVo.setEmailAddress(systemEmailCc.getEmailAddress());

					systemEmailCcVoList.add(systemEmailCcVo);
				}
			}
		} else {
			logger.warn("List not found  for Object");
			logger.info("List not found  for SystemEmailCc");
			return;
		}

		logger.info("List found the SystemEmail");
	}
}
