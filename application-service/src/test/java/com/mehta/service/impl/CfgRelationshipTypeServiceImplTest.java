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
import com.mehta.common.vo.CfgRelationshipTypeVo;
import com.mehta.service.CfgRelationshipTypeService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CfgRelationshipTypeServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(CfgRelationshipTypeServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private CfgRelationshipTypeService cfgRelationshipTypeService;
	private static int id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {

		ehCacheCacheManagerStatic = ehCacheCacheManager;

		String name = "abc";
		String description = "movie";
		String category = "flop";
		String subCategory = "flop";
		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 3l;
		Long createdByTaskId = 2l;

		CfgRelationshipTypeVo cfgRelationshipTypeVo = new CfgRelationshipTypeVo(name, description, category,
				subCategory, created, createdBy, lastModified, lastModifiedBy, createdByTaskId);
		id = cfgRelationshipTypeService.create(cfgRelationshipTypeVo);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for Currency");
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String name = "abc";
		String description = "movie";
		String category = "flop Movie";
		String subCategory = "flop";
		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 3l;
		Long createdByTaskId = 2l;
		CfgRelationshipTypeVo cfgRelationshipTypeVo = new CfgRelationshipTypeVo(name, description, category,
				subCategory, created, createdBy, lastModified, lastModifiedBy, createdByTaskId);

		cfgRelationshipTypeVo.setId(id);

		cfgRelationshipTypeService.update(cfgRelationshipTypeVo);

		CfgRelationshipTypeVo cfgRelationshipTypeVo2 = cfgRelationshipTypeService.read(id);

		Assert.assertTrue(compute.isEquivalent(cfgRelationshipTypeVo, cfgRelationshipTypeVo2));

		logger.info("record updated for Currency");
	}

	@Test
	public void test3Read() {

		CfgRelationshipTypeVo cfgRelationshipTypeVo = cfgRelationshipTypeService.read(id);

		if (!(cfgRelationshipTypeVo.getId() > 0)) {
			fail("record not created");
		}

		Assert.assertTrue(id == cfgRelationshipTypeVo.getId());

		logger.info("record read for Currency with id " + cfgRelationshipTypeVo.getId());
	}

	@Test
	public void test4List() {

		List<CfgRelationshipTypeVo> cfgRelationshipTypeVoList = cfgRelationshipTypeService.list();
		if (cfgRelationshipTypeVoList.size() > 0) {
			CfgRelationshipTypeVo cfgRelationshipTypeVo = cfgRelationshipTypeVoList.get(0);
			logger.info("record read for Currency with first id as  " + cfgRelationshipTypeVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
