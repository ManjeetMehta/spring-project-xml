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
import com.mehta.common.vo.EmployeeHasEmailVo;
import com.mehta.service.EmployeeHasEmailService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeHasEmailServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(EmployeeHasEmailServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	private EmployeeHasEmailService employeeHasEmailService;

	private static int id;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {

		Integer employeeId = 1;
		Integer contactPointEmailId = 1;
		Integer cfgRelationshipTypeId = 1;
		Integer priority = 1;
		String remarks = "testing...";
		Boolean active = true;
		Date startDate = new Date();
		Date endDate = new Date();

		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		EmployeeHasEmailVo employeeHasEmailVo = new EmployeeHasEmailVo(employeeId, contactPointEmailId,
				cfgRelationshipTypeId, priority, remarks, active, startDate, endDate);

		id = employeeHasEmailService.create(employeeHasEmailVo);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for EmployeeHasEmail with Id : " + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Integer employeeId = 1;
		Integer contactPointEmailId = 1;
		Integer cfgRelationshipTypeId = 1;
		Integer priority = 1;
		String remarks = "testing...updated";
		Boolean active = false;
		Date startDate = new Date();
		Date endDate = new Date();

		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		EmployeeHasEmailVo employeeHasEmailVo = new EmployeeHasEmailVo(employeeId, contactPointEmailId,
				cfgRelationshipTypeId, priority, remarks, active, startDate, endDate);

		employeeHasEmailVo.setId(id);
		employeeHasEmailService.update(employeeHasEmailVo);

		EmployeeHasEmailVo employeeHasEmailVo2 = employeeHasEmailService.read(id);

		// Assert.assertTrue(compute.isEquivalent(employeeHasEmailVo,
		// employeeHasEmailVo2));

		logger.info("record updated for employeeHasEmail...");
	}

	@Test
	public void test3Read() {

		EmployeeHasEmailVo employeeHasEmailVo = employeeHasEmailService.read(id);

		if (!(employeeHasEmailVo.getId() > 0)) {
			fail("record not found with id " + id);
		}

		Assert.assertTrue(id == employeeHasEmailVo.getId());

		logger.info("record read for EmployeeHasEmail with id " + employeeHasEmailVo.getId());
	}

	@Test
	public void test4List() {

		List<EmployeeHasEmailVo> employeeHasEmailVoList = employeeHasEmailService.list();
		if (employeeHasEmailVoList.size() > 0) {
			EmployeeHasEmailVo employeeHasEmailVo = employeeHasEmailVoList.get(0);
			logger.info("record read for EmployeeHasEmail with first id as  " + employeeHasEmailVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
