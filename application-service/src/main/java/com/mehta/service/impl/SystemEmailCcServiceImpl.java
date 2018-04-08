package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.SystemEmailCcVo;
import com.mehta.dao.SystemEmailCcDao;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.model.SystemEmailCc;
import com.mehta.service.SystemEmailCcService;

@Component
public class SystemEmailCcServiceImpl implements SystemEmailCcService {

	@Autowired
	private SystemEmailCcDao systemEmailCcDao;

	@Autowired
	private SystemEmailDao systemEmailDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemEmailCcServiceImpl.class);

	@Override
	public Integer createSystemEmailCcService(SystemEmailCcVo systemEmailCcVo, String loggedUserId) {
		Integer id = null;
		if (systemEmailCcVo != null) {

			SystemEmail systemEmail = null;
			if (systemEmailCcVo.getSystemEmailId() != null) {
				systemEmail = systemEmailDao.read(systemEmailCcVo.getSystemEmailId());
				if (systemEmail == null) {
					logger.warn("Object ParentId  is Not Matched.... (Record Not Created)");
					logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Created)");
					return null;
				}
			} else {
				logger.warn("object parentId is null.... (Record Not Created)");
				logger.info("ParentId (SystemEmail) is null.... (Record Not Created)");
				return null;
			}

			String emailAddress = systemEmailCcVo.getEmailAddress();
			if (emailAddress == null) {
				logger.warn("Object having some null value.... (Record Not Created)");
				logger.info("emailAddress is null.... (Record Not Created)");
				return null;
			}

			Date created = new Date();
			Long createdBy = Long.parseLong(loggedUserId);
			Date lastModified = new Date();
			Long lastModifiedBy = Long.parseLong(loggedUserId);
			Long createdByTaskId = Long.parseLong(loggedUserId);

			SystemEmailCc systemEmailCc = new SystemEmailCc(systemEmail, emailAddress, created, createdBy, lastModified,
					lastModifiedBy, createdByTaskId);

			id = systemEmailCcDao.create(systemEmailCc);
		} else if (id == null || !(id >= 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmailCc");
			return null;
		}

		return id;
	}

	@Override
	public void updateSystemEmailCcService(SystemEmailCcVo systemEmailCcVo, String loggedUserId) {
		if (systemEmailCcVo != null && systemEmailCcVo.getId() != null) {
			SystemEmailCc systemEmailCc = systemEmailCcDao.read(systemEmailCcVo.getId());

			if (systemEmailCc != null) {

				SystemEmail systemEmail = null;
				if (systemEmailCcVo.getSystemEmailId() != null) {
					systemEmail = systemEmailDao.read(systemEmailCcVo.getSystemEmailId());
					if (systemEmail == null) {
						logger.warn("Object ParentId  is Not Matched.... (Record Not Updated)");
						logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Updated)");
						return;
					}
				}

				systemEmailCc.setSystemEmail(systemEmail != null ? systemEmail : systemEmailCc.getSystemEmail());
				systemEmailCc.setEmailAddress(systemEmailCcVo.getEmailAddress() != null
						? systemEmailCcVo.getEmailAddress() : systemEmailCc.getEmailAddress());
				systemEmailCc.setLastModified(new Date());
				systemEmailCc.setLastModifiedBy(Long.parseLong(loggedUserId));

				systemEmailCcDao.update(systemEmailCc);
			} else {
				logger.warn("Record not updated for Object with id:" + systemEmailCcVo.getId());
				logger.info("Record not updated for SystemEmailCc with id:" + systemEmailCcVo.getId());
				return;
			}
		} else {
			logger.warn("Either Object or its Id is null,not updated");
			logger.info("Either SystemEmailCc or its Id is null,not updated");
			return;
		}
		logger.info("Record updated for SystemEmailCc with id:" + systemEmailCcVo.getId());
	}

	@Override

	public SystemEmailCcVo readSystemEmailCcService(Integer id) {
		SystemEmailCcVo systemEmailCcVo = null;
		if (id != null) {
			SystemEmailCc systemEmailCc = systemEmailCcDao.read(id);
			if (systemEmailCc != null) {
				systemEmailCcVo = new SystemEmailCcVo(systemEmailCc.getId());
				systemEmailCcVo.setSystemEmailId(
						systemEmailCc.getSystemEmail() != null ? systemEmailCc.getSystemEmail().getId() : null);
				systemEmailCcVo.setEmailAddress(systemEmailCc.getEmailAddress());

			} else {
				logger.warn("Record not found  for the given Object with id:" + id);
				logger.info("Record not found  for SystemEmailCc with id:" + id);
				return null;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return null;
		}
		return systemEmailCcVo;
	}

	@Override
	public List<SystemEmailCcVo> listSystemEmailCcService() {
		List<SystemEmailCc> systemEmailCcLists = systemEmailCcDao.findAll();
		List<SystemEmailCcVo> systemEmailCcVoList = null;
		SystemEmailCcVo systemEmailCcVo = null;
		if (systemEmailCcLists != null && systemEmailCcLists.size() > 0) {
			systemEmailCcVoList = new ArrayList<>();
			for (SystemEmailCc systemEmailCc : systemEmailCcLists) {
				if (systemEmailCc != null) {
					systemEmailCcVo = new SystemEmailCcVo(systemEmailCc.getId());
					systemEmailCcVo.setSystemEmailId(
							systemEmailCc.getSystemEmail() != null ? systemEmailCc.getSystemEmail().getId() : null);
					systemEmailCcVo.setEmailAddress(systemEmailCc.getEmailAddress());

					systemEmailCcVoList.add(systemEmailCcVo);
				}
			}
		} else {
			logger.warn("List not found  for Object");
			logger.info("List not found  for SystemEmailCc");
			return null;
		}
		return systemEmailCcVoList;
	}

}
