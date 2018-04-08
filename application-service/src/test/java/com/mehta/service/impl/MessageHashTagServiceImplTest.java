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
import com.mehta.common.vo.MessageHashTagVo;
import com.mehta.service.MessageHashTagService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageHashTagServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private static final Logger logger = LoggerFactory.getLogger(MessageHashTagServiceImplTest.class);
	private GenericComputation compute = new GenericComputation();

	@Autowired
	private MessageHashTagService messageHashTagService;
	private static int id;

	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;

	private static EhCacheCacheManager ehCacheCacheManagerStatic;
	
	@Test
	public void test1Create() {

		String tagName="test name";
		String category="test Category";
		String subCategory="test sub category";
		String token="my token";
		String description="description";
		
		MessageHashTagVo messageHashTagVo=new MessageHashTagVo(tagName, category, subCategory, token, description);

		id = messageHashTagService.createMessageHashTagService(messageHashTagVo,"101");
		if (!(id > 0)) {
			fail("record not Created");
		}
		logger.info("record created for MessageHashTag");
	}

	@Test
	public void test2Update() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,SecurityException {

		String tagName="Updated test name";
		String category="Updated test Category";
		String subCategory="Updated test sub category";
		String token="Updated my token";
		String description="Updated description";
		
		MessageHashTagVo messageHashTagVo=new MessageHashTagVo(tagName, category, subCategory, token, description);
		
		messageHashTagVo.setId(id);
		messageHashTagService.updateMessageHashTagService(messageHashTagVo,"202");

		MessageHashTagVo messageHashTagVo2 = messageHashTagService.readMessageHashTagService(id);

//		Assert.assertTrue(compute.isEquivalent(employeeVo, employeeVo2));

		logger.info("record updated for MessageHashTag");
	}

	@Test
	public void test3Read() {

		MessageHashTagVo messageHashTagVo = messageHashTagService.readMessageHashTagService(id);

		if (!(messageHashTagVo.getId() > 0)) {
			fail("record not created");
		}

		Assert.assertTrue(id == messageHashTagVo.getId());

		logger.info("record read for MessageHashTag with id " + messageHashTagVo.getId());
	}

	@Test
	public void test4List() {

		List<MessageHashTagVo> messageHashTagVoList = messageHashTagService.listMessageHashTagService();
		if (messageHashTagVoList.size() > 0) {
			MessageHashTagVo messageHashTagVo = messageHashTagVoList.get(0);
			logger.info("record read for MessageHashTag with "+id+" as  " + messageHashTagVo.getId());
		} else {
			fail("records not fetched");
		}
	}
}
