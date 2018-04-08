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
import com.mehta.common.vo.CustomerCorporateHasTaggedDocumentPermissionsVo;
import com.mehta.service.CustomerCorporateHasTaggedDocumentPermissionsService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerCorporateHasTaggedDocumentPermissionsServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerCorporateHasTaggedDocumentPermissionsServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private CustomerCorporateHasTaggedDocumentPermissionsService customerCorporateHasTaggedDocumentPermissionsService;
	private static Integer id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {
		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "1";
		Integer customerCorporateId = 1;
		Date startDate = new Date();
		Date endDate = new Date();
		CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = new CustomerCorporateHasTaggedDocumentPermissionsVo(
				docUuid, customerCorporateId, startDate, endDate);
		id = customerCorporateHasTaggedDocumentPermissionsService.customerCorporateHasTaggedDocumentPermissionsCreate(customerCorporateHasTaggedDocumentPermissionsVo,
				"10000");
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for CustomerCorporateHasTaggedDocumentPermissions");

	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException {

		ehCacheCacheManagerStatic = ehCacheCacheManager;
		String docUuid = "2";
		Integer customerCorporateId = 2;
		Date startDate = new Date();
		Date endDate = new Date();
		CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = new CustomerCorporateHasTaggedDocumentPermissionsVo(
				docUuid, customerCorporateId, startDate, endDate);
		customerCorporateHasTaggedDocumentPermissionsVo.setId(id);

		try {
			customerCorporateHasTaggedDocumentPermissionsService.customerCorporateHasTaggedDocumentPermissionsUpdate(customerCorporateHasTaggedDocumentPermissionsVo,
					"20000");
			logger.info("record updated for CustomerCorporateHasTaggedDocumentPermissions");
		} catch (Exception e) {
			logger.warn("Record not updated.................");
		}
	}

	@Test
	public void test3Read() {

		CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = customerCorporateHasTaggedDocumentPermissionsService
				.customerCorporateHasTaggedDocumentPermissionsRead(id);

		if (!(customerCorporateHasTaggedDocumentPermissionsVo.getId() > 0)) {
			fail("record not created");
		}
		logger.info("record read for CustomerCorporateHasTaggedDocumentPermissions with id "
				+ customerCorporateHasTaggedDocumentPermissionsVo.getId());
	}

	@Test
	public void test4List() {

		List<CustomerCorporateHasTaggedDocumentPermissionsVo> customerCorporateHasTaggedDocumentPermissionsVos = customerCorporateHasTaggedDocumentPermissionsService
				.customerCorporateHasTaggedDocumentPermissionsList();
		if (customerCorporateHasTaggedDocumentPermissionsVos.size() > 0) {
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = customerCorporateHasTaggedDocumentPermissionsVos
					.get(0);
			logger.info("record read for CustomerCorporateHasTaggedDocumentPermissions with first id as  "
					+ customerCorporateHasTaggedDocumentPermissionsVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
