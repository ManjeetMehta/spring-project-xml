package com.mehta.service.impl;

import static org.junit.Assert.fail;

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
import com.mehta.common.vo.ContactPointEmailVo;
import com.mehta.dao.ContactPointEmailDao;
import com.mehta.model.ContactPointEmail;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactPointEmailServiceImplTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(ContactPointEmailServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private ContactPointEmailDao contactPointEmailDao;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String emailId = "cndnraj@gmail.com";
		Date startDate = new Date();
		Date endDate = new Date();
		String contactFirstName = "cndn";
		String contactMiddleName = "kumar";
		String contactLastName = "singh";
		Long parentId = 1l;
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		ContactPointEmail contactPointEmail = new ContactPointEmail(emailId, startDate, endDate, contactFirstName,
				contactMiddleName, contactLastName, parentId, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		Integer id1 = contactPointEmailDao.create(contactPointEmail);
		if (!(id1 > 0))
			fail("Exception while creating ContactPointEmail");

		logger.info("record inserted");

	}

	@Test
	public void test3Read() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		id = 1;
		ContactPointEmailVo contactPointEmailVo = null;
		ContactPointEmail contactPointEmail = contactPointEmailDao.read(id);
		if (contactPointEmail != null) {
			String emailId = contactPointEmail.getEmailId();
			Date startDate = contactPointEmail.getStartDate();
			Date endDate = contactPointEmail.getEndDate();
			String contactFirstName = contactPointEmail.getContactFirstName();
			String contactMiddleName = contactPointEmail.getContactMiddleName();
			String contactLastName = contactPointEmail.getContactLastName();
			Long parentId = contactPointEmail.getParentId();
			Date created = contactPointEmail.getCreated();
			Long createdBy = contactPointEmail.getCreatedBy();
			Date lastModified = contactPointEmail.getLastModified();
			Long lastModifiedBy = contactPointEmail.getLastModifiedBy();
			Long createdByTaskId = contactPointEmail.getCreatedByTaskId();
			contactPointEmailVo = new ContactPointEmailVo(emailId, startDate, endDate, contactFirstName,
					contactMiddleName, contactLastName, parentId, created, createdBy, lastModified, lastModifiedBy,
					createdByTaskId);
			contactPointEmailVo.setId(id);
			System.out.println(contactPointEmailVo.getEmailId());
		} else
			fail("Record not fetched");

	}

	@Test
	public void test3Update() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		id = 1;
		String emailId = "Kndn@gmail.com";
		String contactFirstName = "abc";
		String contactMiddleName = "def";
		ContactPointEmail contactPointEmail = contactPointEmailDao.read(id);
		if (contactPointEmail != null) {
			contactPointEmail.setEmailId(emailId);
			contactPointEmail.setContactFirstName(contactFirstName);
			contactPointEmail.setContactMiddleName(contactMiddleName);
			contactPointEmailDao.update(contactPointEmail);
		} else
			fail("not updated");

	}

	@Test
	public void test4List() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		List<ContactPointEmailVo> contactPointEmailVos = null;
		List<ContactPointEmail> contactPointEmailList = contactPointEmailDao.findAll();
		if (contactPointEmailList != null && contactPointEmailList.size() > 0) {
			contactPointEmailVos = new ArrayList<ContactPointEmailVo>();
			for (ContactPointEmail contactPointEmail : contactPointEmailList) {
				String emailId = contactPointEmail.getEmailId();
				Date startDate = contactPointEmail.getStartDate();
				Date endDate = contactPointEmail.getEndDate();
				String contactFirstName = contactPointEmail.getContactFirstName();
				String contactMiddleName = contactPointEmail.getContactMiddleName();
				String contactLastName = contactPointEmail.getContactLastName();
				Long parentId = contactPointEmail.getParentId();
				Date created = contactPointEmail.getCreated();
				Long createdBy = contactPointEmail.getCreatedBy();
				Date lastModified = contactPointEmail.getLastModified();
				Long lastModifiedBy = contactPointEmail.getLastModifiedBy();
				Long createdByTaskId = contactPointEmail.getCreatedByTaskId();
				ContactPointEmailVo contactPointEmailVo = new ContactPointEmailVo(emailId, startDate, endDate,
						contactFirstName, contactMiddleName, contactLastName, parentId, created, createdBy,
						lastModified, lastModifiedBy, createdByTaskId);
				contactPointEmailVo.setId(contactPointEmail.getId());
				contactPointEmailVos.add(contactPointEmailVo);
			}
		}
		System.out.println(contactPointEmailVos);
	}

	/*
	 * @Test public void test5Delete(){ ehCacheCacheManagerStatic =
	 * ehCacheCacheManager; id=1; ContactPointEmail contactPointEmail =
	 * contactPointEmailDao.read(id); if(contactPointEmail != null){
	 * contactPointEmailDao.delete(contactPointEmail); logger.info(
	 * "record deleted");
	 * 
	 * }else{ fail("Record not deleted"); } }
	 */
}
