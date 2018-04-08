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
import com.mehta.common.vo.ProcessInstanceUntaggedDocumentsVo;
import com.mehta.service.ProcessInstanceUntaggedDocumentsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessInstanceUntaggedDocumentsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(ProcessInstanceUntaggedDocumentsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	private ProcessInstanceUntaggedDocumentsService processInstanceUntaggedDocumentsService;


	private static Long id;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		Long processInstanceId=1l;
		Long untaggedDocumentsId=1l;
		Long startDate=1463656192000l;
		Long endDate=1463656192000l;
		String remarks="nothing";

		ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo=new ProcessInstanceUntaggedDocumentsVo(processInstanceId, untaggedDocumentsId, startDate, endDate, remarks);

		id = processInstanceUntaggedDocumentsService.createProcessInstanceUntaggedDocumentsService(processInstanceUntaggedDocumentsVo, "101");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for untaggedDocument with Id : "+id);
	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		Long processInstanceId=null;
		Long untaggedDocumentsId=2l;
		Long startDate=1463006192000l;
		Long endDate=1463600192000l;
		String remarks="Something";

		ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo=new ProcessInstanceUntaggedDocumentsVo(processInstanceId, untaggedDocumentsId, startDate, endDate, remarks);
		processInstanceUntaggedDocumentsVo.setId(id);
		
		processInstanceUntaggedDocumentsService.updateProcessInstanceUntaggedDocumentsService(processInstanceUntaggedDocumentsVo, "202");

		ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo2=processInstanceUntaggedDocumentsService.readProcessInstanceUntaggedDocumentsService(id);

		Assert.assertTrue(compute.isEquivalent(processInstanceUntaggedDocumentsVo, processInstanceUntaggedDocumentsVo2));

		logger.info("record updated for processInstanceUntaggedDocuments...");
	}

	@Test
	public void test3Read() {

		ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo = processInstanceUntaggedDocumentsService.readProcessInstanceUntaggedDocumentsService(id);

		if (!(processInstanceUntaggedDocumentsVo.getId() > 0)) {
			fail("record not found with id "  + id);
		}

		Assert.assertTrue(id == processInstanceUntaggedDocumentsVo.getId());

		logger.info("record read for processInstanceUntaggedDocuments with id " + processInstanceUntaggedDocumentsVo.getId());
	}

	@Test
	public void test4List() {

		List<ProcessInstanceUntaggedDocumentsVo> processInstanceUntaggedDocumentsVoList = processInstanceUntaggedDocumentsService.listProcessInstanceUntaggedDocumentsService();
		if (processInstanceUntaggedDocumentsVoList.size() > 0) {
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo = processInstanceUntaggedDocumentsVoList.get(0);
			logger.info("record read for processInstanceUntaggedDocuments with first id as  " + processInstanceUntaggedDocumentsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
