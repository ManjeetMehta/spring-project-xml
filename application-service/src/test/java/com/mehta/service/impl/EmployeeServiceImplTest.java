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
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mehta.common.utils.GenericComputation;
import com.mehta.common.vo.EmployeeVo;
import com.mehta.service.EmployeeService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private EmployeeService employeeVoService;
	private static int id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;

	@Test
	public void test1Create() {

		String firstName = "gangam";
		String storageFolderName = "aayao" + Math.random();
		String middleName = "magala";
		String lastName = "pandeji";
		String contactNumber = "abcd123";
		Integer addressGeoLocationId = 6;
		Date dateOfBirth = new Date();
		String maritalStatus = "single";
		Integer officeGeoLocationId = 6;
		String nationality = "indian";
		String gender = "male";
		String email = "g@gmail.com";
		String passportNumber = "sda";
		String residentPermit = "jkn bkj";
		Short active = 1;
		Integer userId = 4;
		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		EmployeeVo employeeVo = new EmployeeVo(firstName, storageFolderName, middleName, lastName, contactNumber,
				addressGeoLocationId, dateOfBirth, maritalStatus, officeGeoLocationId, nationality, gender, email,
				passportNumber, residentPermit, active, userId);

		id = employeeVoService.create(employeeVo);
		if (!(id > 0)) {
			fail("record not created");
		}
		logger.info("record created for Currency");
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		String firstName = "salman";
		String storageFolderName = "qweryao" + Math.random();
		String middleName = "magala";
		String lastName = "pandeji";
		String contactNumber = "abcd123";
		Integer addressGeoLocationId = 6;
		Date dateOfBirth = new Date();
		String maritalStatus = "single";
		Integer officeGeoLocationId = 6;
		String nationality = "indian";
		String gender = "male";
		String email = "g@gmail.com";
		String passportNumber = "sda";
		String residentPermit = "jkn bkj";
		Short active = 1;
		Integer userId = 4;
		Date created = new Date();
		Long createdBy = 5l;
		Date lastModified = new Date();
		Long lastModifiedBy = 5l;
		Long createdByTaskId = 6l;

		EmployeeVo employeeVo = new EmployeeVo(firstName, storageFolderName, middleName, lastName, contactNumber,
				addressGeoLocationId, dateOfBirth, maritalStatus, officeGeoLocationId, nationality, gender, email,
				passportNumber, residentPermit, active, userId);

		employeeVo.setId(id);
		employeeVoService.update(employeeVo);

		EmployeeVo employeeVo2 = employeeVoService.read(id);

		// Assert.assertTrue(compute.isEquivalent(employeeVo, employeeVo2));

		logger.info("record updated for Currency");
	}

	@Test
	public void test3Read() {

		EmployeeVo employeeVo = employeeVoService.read(id);

		if (!(employeeVo.getId() > 0)) {
			fail("record not created");
		}

		Assert.assertTrue(id == employeeVo.getId());

		logger.info("record read for Currency with id " + employeeVo.getId());
	}

	@Test
	public void test4List() {

		List<EmployeeVo> employeeVoList = employeeVoService.list();
		if (employeeVoList.size() > 0) {
			EmployeeVo employeeVo = employeeVoList.get(0);
			logger.info("record read for Currency with first id as  " + employeeVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
