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
import com.mehta.common.vo.AgentSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.service.AgentSponsoredHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgentSponsoredHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(AgentSponsoredHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private AgentSponsoredHasTaggedDocumentPermissionsService agentSponsoredHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Integer agentSponsoredId = 1;
		Date startDate = new Date();
		Date endDate = new Date();
		AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = new AgentSponsoredHasTaggedDocumentPermissionsVo(
				docUuid, agentSponsoredId, startDate, endDate);
		id = agentSponsoredHasTaggedDocumentPermissionsService.create(agentSponsoredHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for AgentSponsoredHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Integer agentSponsoredId = 2;
		Date startDate = new Date();
		Date endDate = new Date();
		AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = new AgentSponsoredHasTaggedDocumentPermissionsVo(
				docUuid, agentSponsoredId, startDate, endDate);
		agentSponsoredHasTaggedDocumentPermissionsVo.setId(id);

		try {
			agentSponsoredHasTaggedDocumentPermissionsService.update(agentSponsoredHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for AgentSponsoredHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = agentSponsoredHasTaggedDocumentPermissionsService
				.read(id);

		if (!(agentSponsoredHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for AgentSponsoredHasTaggedDocumentPermissions with id "
				+ agentSponsoredHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<AgentSponsoredHasTaggedDocumentPermissionsVo> agentSponsoredHasTaggedDocumentPermissionsVos = agentSponsoredHasTaggedDocumentPermissionsService
				.list();
		if (agentSponsoredHasTaggedDocumentPermissionsVos.size() > 0) {
			AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = agentSponsoredHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for AgentSponsoredHasTaggedDocumentPermissions with first id as  "
					+ agentSponsoredHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
