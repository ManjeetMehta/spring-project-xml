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
import com.mehta.dao.CfgDocumentClassDao;
import com.mehta.dao.CfgDocumentClassRoleDao;
import com.mehta.dao.RoleDao;
import com.mehta.model.CfgDocumentClass;
import com.mehta.model.CfgDocumentClassRole;
import com.mehta.model.Role;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CfgDocumentClassRoleServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(CfgDocumentClassRoleServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	private CfgDocumentClassRoleDao cfgDocumentClassRoleDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private CfgDocumentClassDao cfgDocumentClassDao;

	private static Integer id;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	private CfgDocumentClass cfgDocumentClass = null;
	private Role role = null;

	@Test
	public void test1Create() {
		Integer cfgDocumentClassId = 1;
		if (cfgDocumentClassId != null)
			cfgDocumentClass = cfgDocumentClassDao.read(cfgDocumentClassId);
		if (cfgDocumentClass == null) {
			logger.warn("cfgDocumentClass record not found with id:" + cfgDocumentClassId);
			return;
		}

		Integer roleId = 1;
		if (roleId != null)
			role = roleDao.read(roleId);
		if (role == null) {
			logger.warn("role record not found with id:" + cfgDocumentClassId);
			return;
		}

		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		CfgDocumentClassRole cfgDocumentClassRole = new CfgDocumentClassRole(cfgDocumentClass, role, created, createdBy,
				lastModifiedBy, createdByTaskId);
		cfgDocumentClassRole.setLastModified(lastModified);

		id = cfgDocumentClassRoleDao.create(cfgDocumentClassRole);
		if (!(id > 0)) {
			fail("record not created of cfgDocumentClassRole");
		}
		logger.info("record created for cfgDocumentClassRole with Id : " + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		id = 1;

		CfgDocumentClassRole cfgDocumentClassRole = cfgDocumentClassRoleDao.read(id);

		Integer cfgDocumentClassId = 2;
		if (cfgDocumentClassId != null) {
			cfgDocumentClass = cfgDocumentClassDao.read(cfgDocumentClassId);
		}

		Integer roleId = 2;
		if (roleId != null) {
			role = roleDao.read(roleId);
		}

		cfgDocumentClassRole.setCfgDocumentClass(cfgDocumentClass);
		cfgDocumentClassRole.setRole(role);
		cfgDocumentClassRole.setLastModified(new Date());
		cfgDocumentClassRole.setLastModifiedBy(2l);
		cfgDocumentClassRole.setCreatedByTaskId(3l);

		cfgDocumentClassRoleDao.update(cfgDocumentClassRole);

		CfgDocumentClassRole cfgDocumentClassRole2 = cfgDocumentClassRoleDao.read(id);
		if (cfgDocumentClassRole != null)
			logger.info("record updated for cfgDocumentClassRole...");
	}

	@Test
	public void test3Read() {

		CfgDocumentClassRole cfgDocumentClassRole = cfgDocumentClassRoleDao.read(id);

		if (!(cfgDocumentClassRole.getId() > 0)) {
			fail("record not found with id " + id);
		}

		Assert.assertTrue(id == cfgDocumentClassRole.getId());

		logger.info("record read for cfgDocumentClassRole with id " + cfgDocumentClassRole.getId());
	}

	@Test
	public void test4List() {

		List<CfgDocumentClassRole> cfgDocumentClassRoleList = cfgDocumentClassRoleDao.findAll();
		if (cfgDocumentClassRoleList.size() > 0) {
			CfgDocumentClassRole cfgDocumentClassRole = cfgDocumentClassRoleList.get(id);
			logger.info("record read for cfgDocumentClassRole with first id as  " + cfgDocumentClassRole.getId());
		} else {
			fail("records not fetched");
		}
	}
}
