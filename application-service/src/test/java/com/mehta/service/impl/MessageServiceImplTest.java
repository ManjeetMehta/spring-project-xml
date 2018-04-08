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
import com.mehta.common.vo.MessageVo;
import com.mehta.service.MessageService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private MessageService messageService;
	private static int id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;
	
	@Test
	public void test1Create() {

		String message = "123";
		Boolean isReopened = true;
		Integer groupId = 12345;
		Integer userId=1;
		Integer messageHasTagId=1;
		Integer taggedUser=1;
		
		MessageVo messageVo=new MessageVo(message, isReopened, userId, messageHasTagId, groupId, taggedUser);

		id = messageService.createMessageService(messageVo,"101");
		if (!(id > 0)) {
			fail("record not Created");
		}
		logger.info("record created for Message");
	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,SecurityException {

		String message = "321 updated";
		Boolean isReopened = false;
		Integer groupId = 54321;
		Integer userId=2;
		Integer messageHasTagId=2;
		Integer taggedUser=2;
		
		MessageVo messageVo=new MessageVo(message, isReopened, userId, messageHasTagId, groupId, taggedUser);
		
		messageVo.setId(id);
		messageService.updateMessageService(messageVo,"202");

		MessageVo messageVo2 = messageService.readMessageService(id);

//		Assert.assertTrue(compute.isEquivalent(employeeVo, employeeVo2));

		logger.info("record updated for Message");
	}

	@Test
	public void test3Read() {

		MessageVo messageVo = messageService.readMessageService(id);

		if (!(messageVo.getId() > 0)) {
			fail("record not created");
		}

		Assert.assertTrue(id == messageVo.getId());

		logger.info("record read for Message with id " + messageVo.getId());
	}

	@Test
	public void test4List() {

		List<MessageVo> messageVoList = messageService.listMessageService();
		if (messageVoList.size() > 0) {
			MessageVo messageVo = messageVoList.get(0);
			logger.info("record read for Message with "+id+" as  " + messageVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
