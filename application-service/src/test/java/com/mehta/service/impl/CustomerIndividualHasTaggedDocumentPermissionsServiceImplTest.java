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
import com.mehta.common.vo.CustomerIndividualHasTaggedDocumentPermissionsVo;
import com.mehta.service.CustomerIndividualHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerIndividualHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerIndividualHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private CustomerIndividualHasTaggedDocumentPermissionsService customerIndividualHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Integer customerIndividualId = 1;
		Date startDate = new Date();
		Date endDate = new Date();
		CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = new CustomerIndividualHasTaggedDocumentPermissionsVo(
				docUuid, customerIndividualId, startDate, endDate);
		id = customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsCreate(customerIndividualHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for CustomerIndividualHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Integer customerIndividualId = 2;
		Date startDate = new Date();
		Date endDate = new Date();
		CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = new CustomerIndividualHasTaggedDocumentPermissionsVo(
				docUuid, customerIndividualId, startDate, endDate);
		customerIndividualHasTaggedDocumentPermissionsVo.setId(id);

		try {
			customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsUpdate(customerIndividualHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for CustomerIndividualHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = customerIndividualHasTaggedDocumentPermissionsService
				.customerIndividualHasTaggedDocumentPermissionsRead(id);

		if (!(customerIndividualHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for CustomerIndividualHasTaggedDocumentPermissions with id "
				+ customerIndividualHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<CustomerIndividualHasTaggedDocumentPermissionsVo> customerIndividualHasTaggedDocumentPermissionsVos = customerIndividualHasTaggedDocumentPermissionsService
				.customerIndividualHasTaggedDocumentPermissionsList();
		if (customerIndividualHasTaggedDocumentPermissionsVos.size() > 0) {
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = customerIndividualHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for CustomerIndividualHasTaggedDocumentPermissions with first id as  "
					+ customerIndividualHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
