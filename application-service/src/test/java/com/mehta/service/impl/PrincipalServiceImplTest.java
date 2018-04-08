package com.mehta.service.impl;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import com.mehta.common.vo.PrincipalVo;
import com.mehta.service.PrincipalService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrincipalServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(PrincipalServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private PrincipalService principalVoService;
	private static int id;

	@Test
	public void test1Create() {

		String name = "gangam";
		String legalName = "pandeji";
		Integer addressGeoLocationId = 6;
		String storageFolderName = "aayao";

		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);

		id = principalVoService.create(principalVo);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for Currency");
	}

	@Test
	public void test1CreateList() {

		Set<PrincipalVo> principalVoSet = new LinkedHashSet<PrincipalVo>();
		for (int i = 1; i < 1000; i++) {
			String name = "a " + i;
			String legalName = "b " + i;
			Integer addressGeoLocationId = i;
			String storageFolderName = "c " + i;

			PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);
			principalVoSet.add(principalVo);
		}

		Set<Integer> idSet = principalVoService.createList(principalVoSet);
		if (!(idSet.size() > 0)) {
			fail("record not created");
		}
		logger.info(idSet.size() + " : record created for Currency");
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String name = "am";
		String legalName = "pandeji";
		Integer addressGeoLocationId = 6;
		String storageFolderName = "aayaoaa";

		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);

		principalVo.setId(id);

		principalVoService.update(principalVo);

		PrincipalVo principalVo2 = principalVoService.read(id);

		Assert.assertTrue(compute.isEquivalent(principalVo, principalVo2));

		logger.info("record updated for Currency");
	}

	@Test
	public void test3Merge()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String name = "new one";
		String legalName = "new one";
		Integer addressGeoLocationId = 5;
		String storageFolderName = "new one";

		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;
		PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);
		principalVo.setId(1);
		principalVoService.merge(principalVo);
		PrincipalVo principalVo2 = principalVoService.read(id);
		Assert.assertTrue(compute.isEquivalent(principalVo, principalVo2));
		logger.info("record updated for Currency");
	}

	@Test
	public void test3ExecuteQuery()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String name = "x";
		String legalName = "y";
		Integer addressGeoLocationId = 5;
		String storageFolderName = "z";

		PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);

		principalVo.setId(1);
		principalVoService.executeQuery(principalVo);
		logger.info("record updated for Currency");
	}

	@Test
	public void test3ExecuteQueryMap()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String name = "Chandrakant";
		String legalName = "Renake";
		Integer addressGeoLocationId = 5;
		String storageFolderName = "Bangalore";
		PrincipalVo principalVo = new PrincipalVo(name, legalName, addressGeoLocationId, storageFolderName);
		principalVo.setId(1);
		principalVoService.executeQueryMap(principalVo);
		logger.info("record updated for Currency");
	}

	@Test
	public void test3Read() {

		PrincipalVo principalVo = principalVoService.read(id);

		if (!(principalVo.getId() > 0)) {
			fail("record not created");
		}

		Assert.assertTrue(id == principalVo.getId());

		logger.info("record read for Currency with id " + principalVo.getId());
	}

	@Test
	public void test4List() {

		List<PrincipalVo> principalVoList = principalVoService.list();
		if (principalVoList.size() > 0) {
			PrincipalVo principalVo = principalVoList.get(0);
			logger.info("record read for Currency with first id as  " + principalVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
