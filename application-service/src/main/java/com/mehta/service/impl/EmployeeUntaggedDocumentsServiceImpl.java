package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.EmployeeUntaggedDocumentsVo;
import com.mehta.dao.EmployeeDao;
import com.mehta.dao.EmployeeUntaggedDocumentsDao;
import com.mehta.dao.UntaggedDocumentsDao;
import com.mehta.model.Employee;
import com.mehta.model.EmployeeUntaggedDocuments;
import com.mehta.model.UntaggedDocuments;
import com.mehta.service.EmployeeUntaggedDocumentsService;

@Component
public class EmployeeUntaggedDocumentsServiceImpl implements EmployeeUntaggedDocumentsService {

	@Autowired
	private EmployeeUntaggedDocumentsDao employeeUntaggedDocumentsDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private UntaggedDocumentsDao untaggedDocumentsDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Long createEmployeeUntaggedDocumentsService(EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo,
			String loggedUserId) {

		if (employeeUntaggedDocumentsVo == null) {
			logger.warn("employeeUntaggedDocumentsVo is null... (Record not Created)");
			return null;
		}

		Employee employee = null;
		if (employeeUntaggedDocumentsVo.getEmployeeId() != null) {
			employee = employeeDao.read(employeeUntaggedDocumentsVo.getEmployeeId());
			if (employee == null) {
				logger.warn("Parent Id of (employee) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (employee) is null.... (Record Not Created)");
			return null;
		}

		UntaggedDocuments untaggedDocuments = null;
		if (employeeUntaggedDocumentsVo.getUntaggedDocumentsId() != null) {
			untaggedDocuments = untaggedDocumentsDao.read(employeeUntaggedDocumentsVo.getUntaggedDocumentsId());
			if (untaggedDocuments == null) {
				logger.warn("Parent Id of (untaggedDocuments) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (untaggedDocuments) is null.... (Record Not Created)");
			return null;
		}

		Date startDate = null;
		if (employeeUntaggedDocumentsVo.getStartDate() == null) {
			logger.warn("startDate is null.... (Record Not Created)");
			return null;
		} else
			startDate = new Date(employeeUntaggedDocumentsVo.getStartDate());

		Date endDate = null;
		if (employeeUntaggedDocumentsVo.getEndDate() != null)
			endDate = new Date(employeeUntaggedDocumentsVo.getEndDate());

		String remarks = employeeUntaggedDocumentsVo.getRemarks();

		Date created = new Date();
		Long createdBy = Long.parseLong(loggedUserId.toString());
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(loggedUserId.toString());
		Long createdByTaskId = Long.parseLong(loggedUserId.toString());

		EmployeeUntaggedDocuments employeeUntaggedDocuments = new EmployeeUntaggedDocuments(employee, untaggedDocuments,
				startDate, endDate, remarks, created, createdBy, lastModified, lastModifiedBy, createdByTaskId);

		return employeeUntaggedDocumentsDao.create(employeeUntaggedDocuments);

	}

	@Override
	public void updateEmployeeUntaggedDocumentsService(EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo,
			String loggedUserId) {

		if (employeeUntaggedDocumentsVo == null && employeeUntaggedDocumentsVo.getId() == null) {
			logger.warn("employeeUntaggedDocumentsVo or Id is null... (Record not updated)");
			return;
		}

		EmployeeUntaggedDocuments employeeUntaggedDocuments = employeeUntaggedDocumentsDao
				.read(employeeUntaggedDocumentsVo.getId());

		if (employeeUntaggedDocuments != null) {
			Employee employee = null;
			if (employeeUntaggedDocumentsVo.getEmployeeId() != null) {
				employee = employeeDao.read(employeeUntaggedDocumentsVo.getEmployeeId());
				if (employee == null) {
					logger.warn("Parent Id of (employee) is Not Matched.... (Record Not Created)");
					return;
				} else
					employeeUntaggedDocuments.setEmployee(employee);
			} else
				logger.warn("Parent Id of (employee) is null.... (Record Not Created)");

			UntaggedDocuments untaggedDocuments = null;
			if (employeeUntaggedDocumentsVo.getUntaggedDocumentsId() != null) {
				untaggedDocuments = untaggedDocumentsDao.read(employeeUntaggedDocumentsVo.getUntaggedDocumentsId());
				if (untaggedDocuments == null) {
					logger.warn("Parent Id of (untaggedDocuments) is Not Matched.... (Record Not Created)");
					return;
				} else
					employeeUntaggedDocuments.setUntaggedDocuments(untaggedDocuments);
			} else
				logger.warn("Parent Id of (untaggedDocuments) is null.... (Record Not Created)");

			if (employeeUntaggedDocumentsVo.getStartDate() != null)
				employeeUntaggedDocuments.setStartDate(new Date(employeeUntaggedDocumentsVo.getStartDate()));
			else
				logger.warn("startDate is missing...");

			if (employeeUntaggedDocumentsVo.getEndDate() != null)
				employeeUntaggedDocuments.setEndDate(new Date(employeeUntaggedDocumentsVo.getEndDate()));
			else
				logger.warn("endDate is missing...");

			if (employeeUntaggedDocumentsVo.getRemarks() != null)
				employeeUntaggedDocuments.setRemarks(employeeUntaggedDocumentsVo.getRemarks());
			else
				logger.warn("Remarks is missing...");

			employeeUntaggedDocuments.setLastModified(new Date());
			employeeUntaggedDocuments.setLastModifiedBy(Long.parseLong(loggedUserId.toString()));
			employeeUntaggedDocuments.setCreatedByTaskId(Long.parseLong(loggedUserId.toString()));

			employeeUntaggedDocumentsDao.update(employeeUntaggedDocuments);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}

	}

	@Override
	public EmployeeUntaggedDocumentsVo readEmployeeUntaggedDocumentsService(Long id) {
		EmployeeUntaggedDocuments employeeUntaggedDocuments = employeeUntaggedDocumentsDao.read(id);

		if (employeeUntaggedDocuments != null) {
			EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo = new EmployeeUntaggedDocumentsVo(
					employeeUntaggedDocuments.getId());
			if (employeeUntaggedDocuments.getEmployee() != null)
				employeeUntaggedDocumentsVo.setEmployeeId(employeeUntaggedDocuments.getEmployee().getId());
			if (employeeUntaggedDocuments.getUntaggedDocuments() != null)
				employeeUntaggedDocumentsVo
						.setUntaggedDocumentsId(employeeUntaggedDocuments.getUntaggedDocuments().getId());

			employeeUntaggedDocumentsVo.setStartDate(employeeUntaggedDocuments.getStartDate().getTime());

			if (employeeUntaggedDocuments.getEndDate() != null)
				employeeUntaggedDocumentsVo.setEndDate(employeeUntaggedDocuments.getEndDate().getTime());

			employeeUntaggedDocumentsVo.setRemarks(employeeUntaggedDocuments.getRemarks());

			return employeeUntaggedDocumentsVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<EmployeeUntaggedDocumentsVo> listEmployeeUntaggedDocumentsService() {
		List<EmployeeUntaggedDocuments> employeeUntaggedDocumentsList = employeeUntaggedDocumentsDao.findAll();

		List<EmployeeUntaggedDocumentsVo> employeeUntaggedDocumentsVoList = null;

		if (employeeUntaggedDocumentsList.size() > 0) {
			employeeUntaggedDocumentsVoList = new ArrayList<EmployeeUntaggedDocumentsVo>();

			for (EmployeeUntaggedDocuments employeeUntaggedDocuments : employeeUntaggedDocumentsList) {
				EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo = new EmployeeUntaggedDocumentsVo(
						employeeUntaggedDocuments.getId());
				if (employeeUntaggedDocuments.getEmployee() != null)
					employeeUntaggedDocumentsVo.setEmployeeId(employeeUntaggedDocuments.getEmployee().getId());
				if (employeeUntaggedDocuments.getUntaggedDocuments() != null)
					employeeUntaggedDocumentsVo
							.setUntaggedDocumentsId(employeeUntaggedDocuments.getUntaggedDocuments().getId());

				employeeUntaggedDocumentsVo.setStartDate(employeeUntaggedDocuments.getStartDate().getTime());

				if (employeeUntaggedDocuments.getEndDate() != null)
					employeeUntaggedDocumentsVo.setEndDate(employeeUntaggedDocuments.getEndDate().getTime());

				employeeUntaggedDocumentsVo.setRemarks(employeeUntaggedDocuments.getRemarks());

				employeeUntaggedDocumentsVoList.add(employeeUntaggedDocumentsVo);
			}

		} else {
			employeeUntaggedDocumentsVoList = new ArrayList<EmployeeUntaggedDocumentsVo>(0);

		}
		return employeeUntaggedDocumentsVoList;
	}

}
