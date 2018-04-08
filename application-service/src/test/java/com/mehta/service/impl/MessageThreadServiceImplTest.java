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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mehta.common.utils.GenericComputation;
import com.mehta.common.vo.MessageThreadVo;
import com.mehta.service.MessageThreadService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageThreadServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(MessageThreadServiceImplTest.class);

	private GenericComputation compute = new GenericComputation();

	private static Integer id;

	@Autowired
	private MessageThreadService messageThreadService;

	@Test
	public void test1Create() {
		Integer messageId = 1;
		String message = "greetings";
		Integer messageHashTag = 1;
		Boolean isReopened = true;
		Integer userId = 1;
		Integer taggedUser = 1;

		MessageThreadVo messageThreadVo = new MessageThreadVo(messageId, message, messageHashTag, isReopened, userId,
				taggedUser);
		id = messageThreadService.createMessageThreadService(messageThreadVo, "101");
		if (id <= 0) {
			logger.info("Record not Created");

		}
		logger.info("Method Thread Creation Test Cases ");
	}

	@Test
	public void test2Update()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Integer messageId = 1;
		String message = "greetings";
		Integer messageHashTag = 2;
		Boolean isReopened = true;
		Integer userId = 5;
		Integer taggedUser = 6;

		MessageThreadVo messageThreadVo = new MessageThreadVo(messageId, message, messageHashTag, isReopened, userId,
				taggedUser);
		messageThreadVo.setId(id);
		messageThreadService.updateMessageThreadService(messageThreadVo, "202");

		MessageThreadVo messageThreadVo1 = messageThreadService.readMessageThreadService(id);
		if (messageThreadVo.getId() == messageThreadVo1.getId())
			logger.info("record updated for messageThread");

	}

	@Test
	public void test3Read() {

		MessageThreadVo messageThreadVo = messageThreadService.readMessageThreadService(id);

		Assert.assertTrue(id == messageThreadVo.getId());
		logger.info("record read for messageThread with id " + messageThreadVo.getId());
	}

	@Test
	public void test4List() {

		List<MessageThreadVo> messageThreadVoList = messageThreadService.listMessageThreadService();
		if (messageThreadVoList.size() > 0) {
			MessageThreadVo messageThreadVo = messageThreadVoList.get(0);
			logger.info("record read for Message with " + id + " as  " + messageThreadVo.getId());
		} else {
			fail("records not fetched");
		}
	}

}
