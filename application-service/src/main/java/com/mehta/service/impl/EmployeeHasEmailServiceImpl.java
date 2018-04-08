package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.EmployeeHasEmailVo;
import com.mehta.dao.CfgRelationshipTypeDao;
import com.mehta.dao.ContactPointEmailDao;
import com.mehta.dao.EmployeeDao;
import com.mehta.dao.EmployeeHasEmailDao;
import com.mehta.dao.PrincipalHasEmailDao;
import com.mehta.model.CfgRelationshipType;
import com.mehta.model.ContactPointEmail;
import com.mehta.model.Employee;
import com.mehta.model.EmployeeHasEmail;
import com.mehta.service.EmployeeHasEmailService;

@Component
public class EmployeeHasEmailServiceImpl implements EmployeeHasEmailService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeHasEmailDao employeeHasEmailDao;

	@Autowired
	private PrincipalHasEmailDao principalHasEmailDao;

	@Autowired
	private ContactPointEmailDao contactPointEmailDao;

	@Autowired
	private CfgRelationshipTypeDao cfgRelationshipTypeDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeHasEmailServiceImpl.class);

	@Override
	public Integer create(EmployeeHasEmailVo employeeHasEmailVo) {

		Employee employee = null;
		if (employeeHasEmailVo.getEmployeeId() != null) {
			employee = employeeDao.read(employeeHasEmailVo.getEmployeeId());
			if (employee == null) {
				logger.warn("Parent Id of (employee) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("ParentId of (employee) is null.... (Record Not Created)");
			return null;
		}

		ContactPointEmail contactPointEmail = null;
		if (employeeHasEmailVo.getEmailContactPointId() != null) {
			contactPointEmail = contactPointEmailDao.read(employeeHasEmailVo.getEmailContactPointId());
			if (contactPointEmail == null) {
				logger.warn("Parent Id of (ContactPointEmail) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else
			logger.warn("ParentId of (employee) is null.... (Record Not Created)");

		CfgRelationshipType cfgRelationshipType = null;
		if (employeeHasEmailVo.getRelationshipTypeId() != null) {
			cfgRelationshipType = cfgRelationshipTypeDao.read(employeeHasEmailVo.getRelationshipTypeId());
			if (cfgRelationshipType == null)
				logger.warn("Parent Id of (cfgRelationshipType) is Not Matched.... (Record Not Created)");
		} else {
			logger.warn("ParentId of (cfgRelationshipType) is null.... (Record Not Created)");
			return null;
		}

		Integer priority = employeeHasEmailVo.getPriority();
		String remarks = employeeHasEmailVo.getRemarks();
		Boolean active = employeeHasEmailVo.getActive();
		Date startDate = employeeHasEmailVo.getStartDate();
		Date endDate = employeeHasEmailVo.getEndDate();
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		if (startDate == null) {
			logger.warn("startDate is not available");
			return null;
		}

		EmployeeHasEmail employeeHasEmail = new EmployeeHasEmail(employee, contactPointEmail, cfgRelationshipType,
				priority, remarks, active, startDate, endDate, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);

		return employeeHasEmailDao.create(employeeHasEmail);
	}

	@Override
	public void update(EmployeeHasEmailVo employeeHasEmailVo) {
		EmployeeHasEmail employeeHasEmail = employeeHasEmailDao.read(employeeHasEmailVo.getId());

		if (employeeHasEmail != null) {

			Employee employee = null;
			if (employeeHasEmailVo.getEmployeeId() != null) {
				employee = employeeDao.read(employeeHasEmailVo.getEmployeeId());
				if (employee == null) {
					logger.warn("Parent Id of (employee) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("ParentId of (employee) is null.... (Record Not Created)");

			ContactPointEmail contactPointEmail = null;
			if (employeeHasEmailVo.getEmailContactPointId() != null) {
				contactPointEmail = contactPointEmailDao.read(employeeHasEmailVo.getEmailContactPointId());
				if (contactPointEmail == null) {
					logger.warn("Parent Id of (ContactPointEmail) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("ParentId of (employee) is null.... (Record Not Created)");

			CfgRelationshipType cfgRelationshipType = null;
			if (employeeHasEmailVo.getRelationshipTypeId() != null) {
				cfgRelationshipType = cfgRelationshipTypeDao.read(employeeHasEmailVo.getRelationshipTypeId());
				if (cfgRelationshipType == null) {
					logger.warn("Parent Id of (cfgRelationshipType) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("ParentId of (cfgRelationshipType) is null.... (Record Not Created)");

			if (employee != null)
				employeeHasEmail.setEmployee(employee);
			if (contactPointEmail != null)
				employeeHasEmail.setContactPointEmail(contactPointEmail);
			if (cfgRelationshipType != null)
				employeeHasEmail.setCfgRelationshipType(cfgRelationshipType);
			if (employeeHasEmailVo.getPriority() != null)
				employeeHasEmail.setPriority(employeeHasEmailVo.getPriority());
			if (employeeHasEmailVo.getRemarks() != null)
				employeeHasEmail.setRemarks(employeeHasEmailVo.getRemarks());
			if (employeeHasEmailVo.getActive() != null)
				employeeHasEmail.setActive(employeeHasEmailVo.getActive());
			if (employeeHasEmailVo.getStartDate() != null)
				employeeHasEmail.setStartDate(employeeHasEmailVo.getStartDate());
			if (employeeHasEmailVo.getEndDate() != null)
				employeeHasEmail.setEndDate(employeeHasEmailVo.getEndDate());

			employeeHasEmail.setLastModified(new Date());
			employeeHasEmail.setLastModifiedBy(2l);

			employeeHasEmailDao.update(employeeHasEmail);
		} else {
			logger.warn("Record not Found for updatation...");
		}
	}

	@Override
	public EmployeeHasEmailVo read(Integer id) {
		EmployeeHasEmail employeeHasEmail = employeeHasEmailDao.read(id);

		EmployeeHasEmailVo employeeHasEmailVo = null;
		if (employeeHasEmail != null) {
			employeeHasEmailVo = new EmployeeHasEmailVo(employeeHasEmail.getId());
			if (employeeHasEmail.getEmployee() != null)
				employeeHasEmailVo.setEmployeeId(employeeHasEmail.getEmployee().getId());
			if (employeeHasEmail.getContactPointEmail() != null)
				employeeHasEmailVo.setEmailContactPointId(employeeHasEmail.getContactPointEmail().getId());
			if (employeeHasEmail.getCfgRelationshipType() != null)
				employeeHasEmailVo.setRelationshipTypeId(employeeHasEmail.getCfgRelationshipType().getId());

			employeeHasEmailVo.setPriority(employeeHasEmail.getPriority());
			employeeHasEmailVo.setRemarks(employeeHasEmail.getRemarks());
			employeeHasEmailVo.setActive(employeeHasEmail.getActive());
			employeeHasEmailVo.setStartDate(employeeHasEmail.getStartDate());
			employeeHasEmailVo.setEndDate(employeeHasEmail.getEndDate());
			return employeeHasEmailVo;
		} else {
			logger.warn("Exception while reading record....(Id) : " + id);
			return null;
		}

	}

	@Override
	public void delete(Integer id) {
		/*
		 * EmployeeHasEmail employeeHasEmail = employeeHasEmailDao.read(id); if
		 * (employeeHasEmail != null)
		 * employeeHasEmailDao.delete(employeeHasEmail);
		 */
	}

	@Override
	public List<EmployeeHasEmailVo> list() {
		List<EmployeeHasEmail> employeeHasEmailList = employeeHasEmailDao.findAll();

		List<EmployeeHasEmailVo> employeeHasEmailVoList = null;

		if (employeeHasEmailList.size() > 0) {
			employeeHasEmailVoList = new ArrayList<EmployeeHasEmailVo>();

			for (EmployeeHasEmail employeeHasEmail : employeeHasEmailList) {

				EmployeeHasEmailVo employeeHasEmailVo = new EmployeeHasEmailVo(employeeHasEmail.getId());
				if (employeeHasEmail.getEmployee() != null)
					employeeHasEmailVo.setEmployeeId(employeeHasEmail.getEmployee().getId());
				if (employeeHasEmail.getContactPointEmail() != null)
					employeeHasEmailVo.setEmailContactPointId(employeeHasEmail.getContactPointEmail().getId());
				if (employeeHasEmail.getCfgRelationshipType() != null)
					employeeHasEmailVo.setRelationshipTypeId(employeeHasEmail.getCfgRelationshipType().getId());

				employeeHasEmailVo.setPriority(employeeHasEmail.getPriority());
				employeeHasEmailVo.setRemarks(employeeHasEmail.getRemarks());
				employeeHasEmailVo.setActive(employeeHasEmail.getActive());
				employeeHasEmailVo.setStartDate(employeeHasEmail.getStartDate());
				employeeHasEmailVo.setEndDate(employeeHasEmail.getEndDate());

				employeeHasEmailVoList.add(employeeHasEmailVo);
			}
		} else {
			employeeHasEmailVoList = new ArrayList<EmployeeHasEmailVo>(0);

		}
		return employeeHasEmailVoList;
	}

}
