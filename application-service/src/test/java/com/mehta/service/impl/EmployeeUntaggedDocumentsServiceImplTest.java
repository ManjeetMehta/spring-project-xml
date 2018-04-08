package com.mehta.service.impl;

import static org.junit.Assert.fail;

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
import com.mehta.common.vo.EmployeeUntaggedDocumentsVo;
import com.mehta.service.EmployeeUntaggedDocumentsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeUntaggedDocumentsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(EmployeeUntaggedDocumentsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	private EmployeeUntaggedDocumentsService employeeUntaggedDocumentsService;


	private static Long id;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		Integer employeeId=1;
		Long untaggedDocumentsId=1l;
		Long startDate=1463656192000l;
		Long endDate=1463656192000l;
		String remarks="nothing";

		EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo=new EmployeeUntaggedDocumentsVo(employeeId, untaggedDocumentsId, startDate, endDate, remarks);

		id = employeeUntaggedDocumentsService.createEmployeeUntaggedDocumentsService(employeeUntaggedDocumentsVo, "101");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for untaggedDocument with Id : "+id);
	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		Integer employeeId=null;
		Long untaggedDocumentsId=2l;
		Long startDate=1463006192000l;
		Long endDate=1463600192000l;
		String remarks="Something";

		EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo=new EmployeeUntaggedDocumentsVo(employeeId, untaggedDocumentsId, startDate, endDate, remarks);
		employeeUntaggedDocumentsVo.setId(id);
		
		employeeUntaggedDocumentsService.updateEmployeeUntaggedDocumentsService(employeeUntaggedDocumentsVo, "202");

		EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo2=employeeUntaggedDocumentsService.readEmployeeUntaggedDocumentsService(id);

		//Assert.assertTrue(compute.isEquivalent(employeeUntaggedDocumentsVo, employeeUntaggedDocumentsVo2));

		logger.info("record updated for employeeUntaggedDocuments...");
	}

	@Test
	public void test3Read() {

		EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo = employeeUntaggedDocumentsService.readEmployeeUntaggedDocumentsService(id);

		if (!(employeeUntaggedDocumentsVo.getId() > 0)) {
			fail("record not found with id "  + id);
		}

		Assert.assertTrue(id == employeeUntaggedDocumentsVo.getId());

		logger.info("record read for employeeUntaggedDocuments with id " + employeeUntaggedDocumentsVo.getId());
	}

	@Test
	public void test4List() {

		List<EmployeeUntaggedDocumentsVo> employeeUntaggedDocumentsVoList = employeeUntaggedDocumentsService.listEmployeeUntaggedDocumentsService();
		if (employeeUntaggedDocumentsVoList.size() > 0) {
			EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo = employeeUntaggedDocumentsVoList.get(0);
			logger.info("record read for employeeUntaggedDocuments with first id as  " + employeeUntaggedDocumentsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
