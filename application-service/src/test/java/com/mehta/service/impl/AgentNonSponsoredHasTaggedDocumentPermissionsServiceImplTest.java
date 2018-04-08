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
import com.mehta.common.vo.AgentNonSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.service.AgentNonSponsoredHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgentNonSponsoredHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(AgentNonSponsoredHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private AgentNonSponsoredHasTaggedDocumentPermissionsService agentNonSponsoredHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Integer agentNonSponsoredId = 1;
		Date startDate = new Date();
		Date endDate = new Date();
		AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = new AgentNonSponsoredHasTaggedDocumentPermissionsVo(
				docUuid, agentNonSponsoredId, startDate, endDate);
		id = agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsCreate(agentNonSponsoredHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for AgentNonSponsoredHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Integer agentNonSponsoredId = 2;
		Date startDate = new Date();
		Date endDate = new Date();
		AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = new AgentNonSponsoredHasTaggedDocumentPermissionsVo(
				docUuid, agentNonSponsoredId, startDate, endDate);
		agentNonSponsoredHasTaggedDocumentPermissionsVo.setId(id);

		try {
			agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsUpdate(agentNonSponsoredHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for AgentNonSponsoredHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsRead(id);

		if (!(agentNonSponsoredHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for AgentNonSponsoredHasTaggedDocumentPermissions with id "
				+ agentNonSponsoredHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<AgentNonSponsoredHasTaggedDocumentPermissionsVo> agentNonSponsoredHasTaggedDocumentPermissionsVos = agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsList();
		if (agentNonSponsoredHasTaggedDocumentPermissionsVos.size() > 0) {
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = agentNonSponsoredHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for AgentNonSponsoredHasTaggedDocumentPermissions with first id as  "
					+ agentNonSponsoredHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
