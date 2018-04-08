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
import com.mehta.common.vo.SystemEmailBccVo;
import com.mehta.dao.SystemEmailBccDao;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.model.SystemEmailBcc;
import com.mehta.service.SystemEmailBccService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemEmailBccServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;
	private static EhCacheCacheManager ehCacheCacheManagerStatic;
	private static final Logger logger = LoggerFactory.getLogger(SystemEmailBccServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private SystemEmailBccService systemEmailBccService;

	@Autowired
	private SystemEmailDao systemEmailDao;

	@Autowired
	private SystemEmailBccDao systemEmailBccDao;

	private static Integer id = null;
	private String loggedUserId = "100";
	static SystemEmailBccVo systemEmailBccVo = null;

	static {
		Integer systemEmailId = 1;
		String emailAddress = "abc@gmail.com";

		systemEmailBccVo = new SystemEmailBccVo(systemEmailId, emailAddress);
	}

	@Test
	public void test1Create() {
		if (systemEmailBccVo != null) {

			SystemEmail systemEmail = null;
			if (systemEmailBccVo.getSystemEmailId() != null) {
				systemEmail = systemEmailDao.read(systemEmailBccVo.getSystemEmailId());
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

			String emailAddress = systemEmailBccVo.getEmailAddress();
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

			SystemEmailBcc systemEmailBcc = new SystemEmailBcc(systemEmail, emailAddress, created, createdBy,
					lastModified, lastModifiedBy, createdByTaskId);

			id = systemEmailBccDao.create(systemEmailBcc);
		} else if (id == null || !(id >= 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmailBcc");
			return;
		}

		logger.info("Record created for SystemEmail with id:" + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		systemEmailBccVo.setId(id);

		if (systemEmailBccVo != null && systemEmailBccVo.getId() != null) {
			SystemEmailBcc systemEmailBcc = systemEmailBccDao.read(systemEmailBccVo.getId());

			if (systemEmailBcc != null) {

				SystemEmail systemEmail = null;
				if (systemEmailBccVo.getSystemEmailId() != null) {
					systemEmail = systemEmailDao.read(systemEmailBccVo.getSystemEmailId());
					if (systemEmail == null) {
						logger.warn("Object ParentId  is Not Matched.... (Record Not Updated)");
						logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Updated)");
						return;
					}
				}

				systemEmailBcc.setSystemEmail(systemEmail != null ? systemEmail : systemEmailBcc.getSystemEmail());
				systemEmailBcc.setEmailAddress(systemEmailBccVo.getEmailAddress() != null
						? systemEmailBccVo.getEmailAddress() : systemEmailBcc.getEmailAddress());
				systemEmailBcc.setLastModified(new Date());
				systemEmailBcc.setLastModifiedBy(Long.parseLong(loggedUserId));

				systemEmailBccDao.update(systemEmailBcc);
			} else {
				logger.warn("Record not updated for Object with id:" + systemEmailBccVo.getId());
				logger.info("Record not updated for SystemEmailBcc with id:" + systemEmailBccVo.getId());
				return;
			}
		} else {
			logger.warn("Either Object or its Id is null,not updated");
			logger.info("Either SystemEmailBcc or its Id is null,not updated");
			return;
		}
		logger.info("Record updated for SystemEmail with id:" + systemEmailBccVo.getId());
	}

	@Test
	public void test3Read() {
		if (id != null) {
			SystemEmailBcc systemEmailBcc = systemEmailBccDao.read(id);
			if (systemEmailBcc != null) {
				systemEmailBccVo = new SystemEmailBccVo(systemEmailBcc.getId());
				systemEmailBccVo.setSystemEmailId(
						systemEmailBcc.getSystemEmail() != null ? systemEmailBcc.getSystemEmail().getId() : null);
				systemEmailBccVo.setEmailAddress(systemEmailBcc.getEmailAddress());

			} else {
				logger.warn("Record not found  for the given Object with id:" + id);
				logger.info("Record not found  for SystemEmailBcc with id:" + id);
				return;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return;
		}

		logger.info("Record  found  for SystemEmail with id:" + systemEmailBccVo.getId());

	}

	@Test
	public void test4List() {

		List<SystemEmailBcc> systemEmailBccLists = systemEmailBccDao.findAll();
		List<SystemEmailBccVo> systemEmailBccVoList = null;
		SystemEmailBccVo systemEmailBccVo = null;
		if (systemEmailBccLists != null && systemEmailBccLists.size() > 0) {
			systemEmailBccVoList = new ArrayList<>();
			for (SystemEmailBcc systemEmailBcc : systemEmailBccLists) {
				if (systemEmailBcc != null) {
					systemEmailBccVo = new SystemEmailBccVo(systemEmailBcc.getId());
					systemEmailBccVo.setSystemEmailId(
							systemEmailBcc.getSystemEmail() != null ? systemEmailBcc.getSystemEmail().getId() : null);
					systemEmailBccVo.setEmailAddress(systemEmailBcc.getEmailAddress());

					systemEmailBccVoList.add(systemEmailBccVo);
				}
			}
		} else {
			logger.warn("List not found  for Object");
			logger.info("List not found  for SystemEmailBcc");
			return;
		}

		logger.info("List found the SystemEmail");
	}
}
