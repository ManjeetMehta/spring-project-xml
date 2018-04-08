package com.mehta.service.impl;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
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
import com.mehta.common.vo.UntaggedDocumentsVo;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.dao.UntaggedDocumentsDao;
import com.mehta.dao.UserDao;
import com.mehta.model.TaggedDocuments;
import com.mehta.model.UntaggedDocuments;
import com.mehta.model.User;
import com.mehta.service.UntaggedDocumentsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UntaggedDocumentsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(UntaggedDocumentsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private UntaggedDocumentsService untaggedDocumentsService;

	@Autowired
	private UntaggedDocumentsDao untaggedDocumentsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private UserDao userDao;

	private static Long id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {

		TaggedDocuments taggedDocuments = taggedDocumentsDao.read("1");
		byte[] docContents = { 1, 2, 3 };
		String fileName = "/home/satyaprakash/Downloads/tc.pdf";
		String fileSize = "100 KB";
		Boolean deleted = false;
		String remarks = "nothing";
		User uploadedBy = userDao.read(1);
		Date taggedOn = new Date(1463656192000l);
		User taggedBy = userDao.read(1);
		User copiedBy = userDao.read(1);
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		UntaggedDocuments untaggedDocuments = new UntaggedDocuments(taggedDocuments, docContents, fileName, fileSize,
				deleted, remarks, uploadedBy, taggedOn, taggedBy, copiedBy, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);

		id = untaggedDocumentsDao.create(untaggedDocuments);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for untaggedDocument with Id : " + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String taggedDocumentsId = "1";
		byte[] docContents = { 1, 2, 3, 4 };
		String fileName = "/home/satyaprakash/Downloads/tc.pdf";
		String fileSize = "1000 KB";
		Boolean deleted = false;
		String remarks = "something";
		Integer uploadedBy = 2;
		Long taggedOn = 1463656192000l;
		Integer taggedBy = 2;
		Integer copiedBy = 2;

		UntaggedDocumentsVo untaggedDocumentsVo = new UntaggedDocumentsVo(taggedDocumentsId, docContents, fileName,
				fileSize, deleted, remarks, uploadedBy, taggedOn, taggedBy, copiedBy);

		untaggedDocumentsVo.setId(id);

		untaggedDocumentsService.updateUntaggedDocumentsService(untaggedDocumentsVo, "202");

		// UntaggedDocumentsVo
		// UntaggedDocumentsVo2=untaggedDocumentsService.read(id);
		// Assert.assertTrue(compute.isEquivalent(principalHasEmailVo,
		// principalHasEmailVo2));

		logger.info("record updated for untaggedDocument...");
	}

	@Test
	public void test3Read() {

		UntaggedDocumentsVo untaggedDocumentsVo = untaggedDocumentsService.readUntaggedDocumentsService(id);

		if (!(untaggedDocumentsVo.getId() > 0)) {
			fail("record not found with id " + id);
		}

		Assert.assertTrue(id == untaggedDocumentsVo.getId());

		logger.info("record read for untaggedDocument with id " + untaggedDocumentsVo.getId());
	}

	@Test
	public void test4List() {

		List<UntaggedDocumentsVo> untaggedDocumentsVoList = untaggedDocumentsService.listUntaggedDocumentsService();
		if (untaggedDocumentsVoList.size() > 0) {
			UntaggedDocumentsVo untaggedDocumentsVo = untaggedDocumentsVoList.get(0);
			logger.info("record read for UntaggedDocuments with first id as  " + untaggedDocumentsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
