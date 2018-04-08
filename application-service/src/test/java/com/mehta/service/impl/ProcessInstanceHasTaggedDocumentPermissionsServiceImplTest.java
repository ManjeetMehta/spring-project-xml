package com.mehta.service.impl;

import static org.junit.Assert.fail;

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
import com.mehta.common.vo.ProcessInstanceHasTaggedDocumentPermissionsVo;
import com.mehta.service.ProcessInstanceHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessInstanceHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(ProcessInstanceHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private ProcessInstanceHasTaggedDocumentPermissionsService processInstanceHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Long processInstanceId = 1l;
		Date startDate = new Date();
		Date endDate = new Date();
		ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = new ProcessInstanceHasTaggedDocumentPermissionsVo(
				docUuid, processInstanceId, startDate, endDate);
		id = processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsCreate(processInstanceHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for ProcessInstanceHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Long processInstanceId = 2l;
		Date startDate = new Date();
		Date endDate = new Date();
		ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = new ProcessInstanceHasTaggedDocumentPermissionsVo(
				docUuid, processInstanceId, startDate, endDate);
		processInstanceHasTaggedDocumentPermissionsVo.setId(1);

		try {
			processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsUpdate(processInstanceHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for ProcessInstanceHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsRead(id);

		if (!(processInstanceHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for ProcessInstanceHasTaggedDocumentPermissions with id "
				+ processInstanceHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<ProcessInstanceHasTaggedDocumentPermissionsVo> processInstanceHasTaggedDocumentPermissionsVos = processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsList();
		if (processInstanceHasTaggedDocumentPermissionsVos.size() > 0) {
			ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = processInstanceHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for ProcessInstanceHasTaggedDocumentPermissions with first id as  "
					+ processInstanceHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
