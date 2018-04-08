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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mehta.common.utils.GenericComputation;
import com.mehta.common.vo.PrincipalHasEmailVo;
import com.mehta.service.PrincipalHasEmailService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrincipalHasEmailServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(PrincipalHasEmailServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private PrincipalHasEmailService principalHasEmailService;
	private static int id;

	@Test
	public void test1Create() {

		Integer principalId = 1;
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

		PrincipalHasEmailVo principalHasEmailVo = new PrincipalHasEmailVo(principalId, contactPointEmailId,
				cfgRelationshipTypeId, priority, remarks, active, startDate, endDate);

		id = principalHasEmailService.create(principalHasEmailVo);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for PrincipalHasEmail with Id : " + id);
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Integer principalId = 1;
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

		PrincipalHasEmailVo principalHasEmailVo = new PrincipalHasEmailVo(principalId, contactPointEmailId,
				cfgRelationshipTypeId, priority, remarks, active, startDate, endDate);

		principalHasEmailVo.setId(id);
		principalHasEmailService.update(principalHasEmailVo);

		PrincipalHasEmailVo principalHasEmailVo2 = principalHasEmailService.read(id);

		// Assert.assertTrue(compute.isEquivalent(principalHasEmailVo,
		// principalHasEmailVo2));

		logger.info("record updated for principalHasEmail...");
	}

	@Test
	public void test3Read() {

		PrincipalHasEmailVo principalHasEmailVo = principalHasEmailService.read(id);

		if (!(principalHasEmailVo.getId() > 0)) {
			fail("record not found with id " + id);
		}

		Assert.assertTrue(id == principalHasEmailVo.getId());

		logger.info("record read for PrincipalHasEmail with id " + principalHasEmailVo.getId());
	}

	@Test
	public void test4List() {

		List<PrincipalHasEmailVo> principalHasEmailVoList = principalHasEmailService.list();
		if (principalHasEmailVoList.size() > 0) {
			PrincipalHasEmailVo principalHasEmailVo = principalHasEmailVoList.get(0);
			logger.info("record read for PrincipalHasEmail with first id as  " + principalHasEmailVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
