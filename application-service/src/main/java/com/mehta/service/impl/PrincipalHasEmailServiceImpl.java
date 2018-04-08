package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.PrincipalHasEmailVo;
import com.mehta.dao.CfgRelationshipTypeDao;
import com.mehta.dao.ContactPointEmailDao;
import com.mehta.dao.PrincipalDao;
import com.mehta.dao.PrincipalHasEmailDao;
import com.mehta.model.CfgRelationshipType;
import com.mehta.model.ContactPointEmail;
import com.mehta.model.Principal;
import com.mehta.model.PrincipalHasEmail;
import com.mehta.service.PrincipalHasEmailService;

@Component
public class PrincipalHasEmailServiceImpl implements PrincipalHasEmailService {

	@Autowired
	private PrincipalDao principalDao;

	@Autowired
	private PrincipalHasEmailDao principalHasEmailDao;

	@Autowired
	private ContactPointEmailDao contactPointEmailDao;

	@Autowired
	private CfgRelationshipTypeDao cfgRelationshipTypeDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PrincipalHasEmailServiceImpl.class);

	@Override
	public Integer create(PrincipalHasEmailVo principalHasEmailVo) {

		Principal principal = null;
		if (principalHasEmailVo.getPrincipalId() != null) {
			principal = principalDao.read(principalHasEmailVo.getPrincipalId());
			if (principal == null) {
				logger.warn("Parent Id of (principal) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (principal) is null.... (Record Not Created)");
			return null;
		}

		ContactPointEmail contactPointEmail = null;
		if (principalHasEmailVo.getEmailContactPointId() != null) {
			contactPointEmail = contactPointEmailDao.read(principalHasEmailVo.getEmailContactPointId());
			if (contactPointEmail == null) {
				logger.warn("Parent Id of (ContactPointEmail) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (ContactPointEmail) is null.... (Record Not Created)");
			return null;
		}

		CfgRelationshipType cfgRelationshipType = null;
		if (principalHasEmailVo.getRelationshipTypeId() != null) {
			cfgRelationshipType = cfgRelationshipTypeDao.read(principalHasEmailVo.getRelationshipTypeId());
			if (cfgRelationshipType == null) {
				logger.warn("Parent Id of (cfgRelationshipType) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (cfgRelationshipType) is null.... (Record Not Created)");
			return null;
		}

		Integer priority = principalHasEmailVo.getPriority();
		String remarks = principalHasEmailVo.getRemarks();
		Boolean active = principalHasEmailVo.getActive();
		Date startDate = principalHasEmailVo.getStartDate();
		Date endDate = principalHasEmailVo.getEndDate();
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		if (startDate == null) {
			logger.warn("startDate is not available");
			return null;
		}

		PrincipalHasEmail principalHasEmail = new PrincipalHasEmail(principal, contactPointEmail, cfgRelationshipType,
				priority, remarks, active, startDate, endDate, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		return principalHasEmailDao.create(principalHasEmail);

	}

	@Override
	public void update(PrincipalHasEmailVo principalHasEmailVo) {

		PrincipalHasEmail principalHasEmail = principalHasEmailDao.read(principalHasEmailVo.getId());

		if (principalHasEmail != null) {

			Principal principal = null;
			if (principalHasEmailVo.getPrincipalId() != null) {
				principal = principalDao.read(principalHasEmailVo.getPrincipalId());
				if (principal == null) {
					logger.warn("Parent Id of (principal) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("Parent Id of (principal) is null.... (Record Not Created)");

			ContactPointEmail contactPointEmail = null;
			if (principalHasEmailVo.getEmailContactPointId() != null) {
				contactPointEmail = contactPointEmailDao.read(principalHasEmailVo.getEmailContactPointId());
				if (contactPointEmail == null) {
					logger.warn("Parent Id of (ContactPointEmail) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("Parent Id of (ContactPointEmail) is null.... (Record Not Created)");

			CfgRelationshipType cfgRelationshipType = null;
			if (principalHasEmailVo.getRelationshipTypeId() != null) {
				cfgRelationshipType = cfgRelationshipTypeDao.read(principalHasEmailVo.getRelationshipTypeId());
				if (cfgRelationshipType == null)
					logger.warn("Parent Id of (cfgRelationshipType) is Not Matched.... (Record Not Created)");
			} else
				logger.warn("Parent Id of (cfgRelationshipType) is null.... (Record Not Created)");

			if (principal != null)
				principalHasEmail.setPrincipal(principal);
			if (contactPointEmail != null)
				principalHasEmail.setContactPointEmail(contactPointEmail);
			if (cfgRelationshipType != null)
				principalHasEmail.setCfgRelationshipType(cfgRelationshipType);

			principalHasEmail.setPriority(principalHasEmailVo.getPriority());
			principalHasEmail.setRemarks(principalHasEmailVo.getRemarks());
			principalHasEmail.setActive(principalHasEmailVo.getActive());
			principalHasEmail.setStartDate(principalHasEmailVo.getStartDate());
			principalHasEmail.setEndDate(principalHasEmailVo.getEndDate());

			principalHasEmail.setLastModified(new Date());
			principalHasEmail.setLastModifiedBy(2l);

			principalHasEmailDao.update(principalHasEmail);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}

	}

	@Override
	public PrincipalHasEmailVo read(Integer id) {
		PrincipalHasEmail principalHasEmail = principalHasEmailDao.read(id);
		PrincipalHasEmailVo principalHasEmailVo = null;
		if (principalHasEmail != null) {
			principalHasEmailVo = new PrincipalHasEmailVo(principalHasEmail.getId());

			if (principalHasEmail.getPrincipal() != null)
				principalHasEmailVo.setPrincipalId(principalHasEmail.getPrincipal().getId());
			if (principalHasEmail.getContactPointEmail() != null)
				principalHasEmailVo.setEmailContactPointId(principalHasEmail.getContactPointEmail().getId());
			if (principalHasEmail.getCfgRelationshipType() != null)
				principalHasEmailVo.setRelationshipTypeId(principalHasEmail.getCfgRelationshipType().getId());

			principalHasEmailVo.setPriority(principalHasEmail.getPriority());
			principalHasEmailVo.setRemarks(principalHasEmail.getRemarks());
			principalHasEmailVo.setActive(principalHasEmail.getActive());
			principalHasEmailVo.setStartDate(principalHasEmail.getStartDate());
			principalHasEmailVo.setEndDate(principalHasEmail.getEndDate());

		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

		return principalHasEmailVo;
	}

	@Override
	public void delete(Integer id) {
		/*
		 * PrincipalHasEmail principalHasEmail = principalHasEmailDao.read(id);
		 * if (principalHasEmail != null)
		 * principalHasEmailDao.delete(principalHasEmail);
		 */

	}

	@Override
	public List<PrincipalHasEmailVo> list() {
		List<PrincipalHasEmail> principalHasEmailList = principalHasEmailDao.findAll();

		List<PrincipalHasEmailVo> principalHasEmailVoList = null;

		if (principalHasEmailList.size() > 0) {
			principalHasEmailVoList = new ArrayList<PrincipalHasEmailVo>();

			for (PrincipalHasEmail principalHasEmail : principalHasEmailList) {

				PrincipalHasEmailVo principalHasEmailVo = new PrincipalHasEmailVo(principalHasEmail.getId());

				if (principalHasEmail.getPrincipal() != null)
					principalHasEmailVo.setPrincipalId(principalHasEmail.getPrincipal().getId());
				if (principalHasEmail.getContactPointEmail() != null)
					principalHasEmailVo.setEmailContactPointId(principalHasEmail.getContactPointEmail().getId());
				if (principalHasEmail.getCfgRelationshipType() != null)
					principalHasEmailVo.setRelationshipTypeId(principalHasEmail.getCfgRelationshipType().getId());

				principalHasEmailVo.setPriority(principalHasEmail.getPriority());
				principalHasEmailVo.setRemarks(principalHasEmail.getRemarks());
				principalHasEmailVo.setActive(principalHasEmail.getActive());
				principalHasEmailVo.setStartDate(principalHasEmail.getStartDate());
				principalHasEmailVo.setEndDate(principalHasEmail.getEndDate());

				principalHasEmailVoList.add(principalHasEmailVo);
			}

		} else {
			principalHasEmailVoList = new ArrayList<PrincipalHasEmailVo>(0);

		}
		return principalHasEmailVoList;
	}

}
