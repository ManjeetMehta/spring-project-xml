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
import com.mehta.common.vo.PrincipalHasTaggedDocumentPermissionsVo;
import com.mehta.service.PrincipalHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrincipalHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(PrincipalHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private PrincipalHasTaggedDocumentPermissionsService principalHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Integer principalId = 1;
		Date startDate = new Date();
		Date endDate = new Date();
		PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = new PrincipalHasTaggedDocumentPermissionsVo(
				docUuid, principalId, startDate, endDate);
		id = principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsCreate(principalHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for PrincipalHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Integer principalId = 2;
		Date startDate = new Date();
		Date endDate = new Date();
		PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = new PrincipalHasTaggedDocumentPermissionsVo(
				docUuid, principalId, startDate, endDate);
		principalHasTaggedDocumentPermissionsVo.setId(1);

		try {
			principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsUpdate(principalHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for PrincipalHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsRead(id);

		if (!(principalHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for PrincipalHasTaggedDocumentPermissions with id "
				+ principalHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<PrincipalHasTaggedDocumentPermissionsVo> principalHasTaggedDocumentPermissionsVos = principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsList();
		if (principalHasTaggedDocumentPermissionsVos.size() > 0) {
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = principalHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for PrincipalHasTaggedDocumentPermissions with first id as  "
					+ principalHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
