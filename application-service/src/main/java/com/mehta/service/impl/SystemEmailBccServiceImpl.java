package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.SystemEmailBccVo;
import com.mehta.dao.SystemEmailBccDao;
import com.mehta.dao.SystemEmailDao;
import com.mehta.model.SystemEmail;
import com.mehta.model.SystemEmailBcc;
import com.mehta.service.SystemEmailBccService;

@Component
public class SystemEmailBccServiceImpl implements SystemEmailBccService {

	@Autowired
	private SystemEmailBccDao systemEmailBccDao;

	@Autowired
	private SystemEmailDao systemEmailDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SystemEmailBccServiceImpl.class);

	@Override
	public Integer createSystemEmailBccService(SystemEmailBccVo systemEmailBccVo, String loggedUserId) {
		Integer id = null;
		if (systemEmailBccVo != null) {

			SystemEmail systemEmail = null;
			if (systemEmailBccVo.getSystemEmailId() != null) {
				systemEmail = systemEmailDao.read(systemEmailBccVo.getSystemEmailId());
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

			String emailAddress = systemEmailBccVo.getEmailAddress();
			if (emailAddress == null) {
				logger.warn("Object having null value.... (Record Not Created)");
				logger.info("emailAddress is null.... (Record Not Created)");
				return null;
			}

			Date created = new Date();
			Long createdBy = Long.parseLong(loggedUserId);
			Date lastModified = new Date();
			Long lastModifiedBy = Long.parseLong(loggedUserId);
			Long createdByTaskId = Long.parseLong(loggedUserId);

			SystemEmailBcc systemEmailBcc = new SystemEmailBcc(systemEmail, emailAddress, created, createdBy,
					lastModified, lastModifiedBy, createdByTaskId);

			id = systemEmailBccDao.create(systemEmailBcc);
		} else if (id == null || !(id >= 0)) {
			logger.warn("Record not created for the given Object");
			logger.info("Record not created for SystemEmailBcc");
			return null;
		}

		return id;
	}

	@Override
	public void updateSystemEmailBccService(SystemEmailBccVo systemEmailBccVo, String loggedUserId) {
		if (systemEmailBccVo != null && systemEmailBccVo.getId() != null) {
			SystemEmailBcc systemEmailBcc = systemEmailBccDao.read(systemEmailBccVo.getId());

			if (systemEmailBcc != null) {

				SystemEmail systemEmail = null;
				if (systemEmailBccVo.getSystemEmailId() != null) {
					systemEmail = systemEmailDao.read(systemEmailBccVo.getSystemEmailId());
					if (systemEmail == null) {
						logger.warn("Object ParentId  is Not Matched.... (Record Not Updated)");
						logger.info("ParentId (SystemEmail) is Not Matched.... (Record Not Updated)");
						return;
					}
				}

				systemEmailBcc.setSystemEmail(systemEmail != null ? systemEmail : systemEmailBcc.getSystemEmail());
				systemEmailBcc.setEmailAddress(systemEmailBccVo.getEmailAddress() != null
						? systemEmailBccVo.getEmailAddress() : systemEmailBcc.getEmailAddress());
				systemEmailBcc.setLastModified(new Date());
				systemEmailBcc.setLastModifiedBy(Long.parseLong(loggedUserId));

				systemEmailBccDao.update(systemEmailBcc);
			} else {
				logger.warn("Record not updated for Object with id:" + systemEmailBccVo.getId());
				logger.info("Record not updated for SystemEmailBcc with id:" + systemEmailBccVo.getId());
				return;
			}
		} else {
			logger.warn("Either Object or its Id is null,not updated");
			logger.info("Either SystemEmailBcc or its Id is null,not updated");
			return;
		}
		logger.info("Record updated for SystemEmailBcc with id:" + systemEmailBccVo.getId());
	}

	@Override
	public SystemEmailBccVo readSystemEmailBccService(Integer id) {
		SystemEmailBccVo systemEmailBccVo = null;
		if (id != null) {
			SystemEmailBcc systemEmailBcc = systemEmailBccDao.read(id);
			if (systemEmailBcc != null) {
				systemEmailBccVo = new SystemEmailBccVo(systemEmailBcc.getId());
				systemEmailBccVo.setSystemEmailId(
						systemEmailBcc.getSystemEmail() != null ? systemEmailBcc.getSystemEmail().getId() : null);
				systemEmailBccVo.setEmailAddress(systemEmailBcc.getEmailAddress());

			} else {
				logger.warn("Record not found  for the given Object with id:" + id);
				logger.info("Record not found  for SystemEmailBcc with id:" + id);
				return null;
			}
		} else {

			logger.warn("Id is wrong :" + id);
			logger.info("Id is wrong :" + id);
			return null;
		}
		return systemEmailBccVo;
	}

	@Override
	public List<SystemEmailBccVo> listSystemEmailBccService() {
		List<SystemEmailBcc> systemEmailBccLists = systemEmailBccDao.findAll();
		List<SystemEmailBccVo> systemEmailBccVoList = null;
		SystemEmailBccVo systemEmailBccVo = null;
		if (systemEmailBccLists != null && systemEmailBccLists.size() > 0) {
			systemEmailBccVoList = new ArrayList<>();
			for (SystemEmailBcc systemEmailBcc : systemEmailBccLists) {
				if (systemEmailBcc != null) {
					systemEmailBccVo = new SystemEmailBccVo(systemEmailBcc.getId());
					systemEmailBccVo.setSystemEmailId(
							systemEmailBcc.getSystemEmail() != null ? systemEmailBcc.getSystemEmail().getId() : null);
					systemEmailBccVo.setEmailAddress(systemEmailBcc.getEmailAddress());

					systemEmailBccVoList.add(systemEmailBccVo);
				}
			}
		} else {
			logger.warn("List not found  for Object");
			logger.info("List not found  for SystemEmailBcc");
			return null;
		}
		return systemEmailBccVoList;
	}

}
