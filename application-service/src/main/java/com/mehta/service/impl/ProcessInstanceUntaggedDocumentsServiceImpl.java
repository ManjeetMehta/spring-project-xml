package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.ProcessInstanceUntaggedDocumentsVo;
import com.mehta.dao.ProcessInstanceDao;
import com.mehta.dao.ProcessInstanceUntaggedDocumentsDao;
import com.mehta.dao.UntaggedDocumentsDao;
import com.mehta.model.ProcessInstance;
import com.mehta.model.ProcessInstanceUntaggedDocuments;
import com.mehta.model.UntaggedDocuments;
import com.mehta.service.ProcessInstanceUntaggedDocumentsService;

@Component
public class ProcessInstanceUntaggedDocumentsServiceImpl implements ProcessInstanceUntaggedDocumentsService {

	@Autowired
	private ProcessInstanceUntaggedDocumentsDao processInstanceUntaggedDocumentsDao;

	@Autowired
	private ProcessInstanceDao processInstanceDao;

	@Autowired
	private UntaggedDocumentsDao untaggedDocumentsDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Long createProcessInstanceUntaggedDocumentsService(
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo, String loggedUserId) {

		if (processInstanceUntaggedDocumentsVo == null) {
			logger.warn("processInstanceUntaggedDocumentsVo is null... (Record not Created)");
			return null;
		}

		ProcessInstance processInstance = null;
		if (processInstanceUntaggedDocumentsVo.getProcessInstanceId() != null) {
			processInstance = processInstanceDao.read(processInstanceUntaggedDocumentsVo.getProcessInstanceId());
			if (processInstance == null) {
				logger.warn("Parent Id of (processInstatnce) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (processInstance) is null.... (Record Not Created)");
			return null;
		}

		UntaggedDocuments untaggedDocuments = null;
		if (processInstanceUntaggedDocumentsVo.getUntaggedDocumentsId() != null) {
			untaggedDocuments = untaggedDocumentsDao.read(processInstanceUntaggedDocumentsVo.getUntaggedDocumentsId());
			if (untaggedDocuments == null) {
				logger.warn("Parent Id of (untaggedDocuments) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (untaggedDocuments) is null.... (Record Not Created)");
			return null;
		}

		Date startDate = null;
		if (processInstanceUntaggedDocumentsVo.getStartDate() == null) {
			logger.warn("startDate is null.... (Record Not Created)");
			return null;
		} else
			startDate = new Date(processInstanceUntaggedDocumentsVo.getStartDate());

		Date endDate = null;
		if (processInstanceUntaggedDocumentsVo.getEndDate() != null)
			endDate = new Date(processInstanceUntaggedDocumentsVo.getEndDate());

		String remarks = processInstanceUntaggedDocumentsVo.getRemarks();

		Date created = new Date();
		Long createdBy = Long.parseLong(loggedUserId.toString());
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(loggedUserId.toString());
		Long createdByTaskId = Long.parseLong(loggedUserId.toString());

		ProcessInstanceUntaggedDocuments processInstanceUntaggedDocuments = new ProcessInstanceUntaggedDocuments(
				processInstance, untaggedDocuments, startDate, endDate, remarks, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);

		return processInstanceUntaggedDocumentsDao.create(processInstanceUntaggedDocuments);

	}

	@Override
	public void updateProcessInstanceUntaggedDocumentsService(
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo, String loggedUserId) {

		if (processInstanceUntaggedDocumentsVo == null && processInstanceUntaggedDocumentsVo.getId() == null) {
			logger.warn("processInstanceUntaggedDocumentsVo or Id is null... (Record not updated)");
			return;
		}

		ProcessInstanceUntaggedDocuments processInstanceUntaggedDocuments = processInstanceUntaggedDocumentsDao
				.read(processInstanceUntaggedDocumentsVo.getId());

		if (processInstanceUntaggedDocuments != null) {
			ProcessInstance processInstance = null;
			if (processInstanceUntaggedDocumentsVo.getProcessInstanceId() != null) {
				processInstance = processInstanceDao.read(processInstanceUntaggedDocumentsVo.getProcessInstanceId());
				if (processInstance == null) {
					logger.warn("Parent Id of (processInstatnce) is Not Matched.... (Record Not Created)");
					return;
				} else
					processInstanceUntaggedDocuments.setProcessInstance(processInstance);
			} else
				logger.warn("Parent Id of (processInstance) is null.... (Record Not Created)");

			UntaggedDocuments untaggedDocuments = null;
			if (processInstanceUntaggedDocumentsVo.getUntaggedDocumentsId() != null) {
				untaggedDocuments = untaggedDocumentsDao
						.read(processInstanceUntaggedDocumentsVo.getUntaggedDocumentsId());
				if (untaggedDocuments == null) {
					logger.warn("Parent Id of (untaggedDocuments) is Not Matched.... (Record Not Created)");
					return;
				} else
					processInstanceUntaggedDocuments.setUntaggedDocuments(untaggedDocuments);
			} else
				logger.warn("Parent Id of (untaggedDocuments) is null.... (Record Not Created)");

			if (processInstanceUntaggedDocumentsVo.getStartDate() != null)
				processInstanceUntaggedDocuments
						.setStartDate(new Date(processInstanceUntaggedDocumentsVo.getStartDate()));
			else
				logger.warn("startDate is missing...");

			if (processInstanceUntaggedDocumentsVo.getEndDate() != null)
				processInstanceUntaggedDocuments.setEndDate(new Date(processInstanceUntaggedDocumentsVo.getEndDate()));
			else
				logger.warn("endDate is missing...");

			if (processInstanceUntaggedDocumentsVo.getRemarks() != null)
				processInstanceUntaggedDocuments.setRemarks(processInstanceUntaggedDocumentsVo.getRemarks());
			else
				logger.warn("Remarks is missing...");

			processInstanceUntaggedDocuments.setLastModified(new Date());
			processInstanceUntaggedDocuments.setLastModifiedBy(Long.parseLong(loggedUserId.toString()));
			processInstanceUntaggedDocuments.setCreatedByTaskId(Long.parseLong(loggedUserId.toString()));

			processInstanceUntaggedDocumentsDao.update(processInstanceUntaggedDocuments);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}

	}

	@Override
	public ProcessInstanceUntaggedDocumentsVo readProcessInstanceUntaggedDocumentsService(Long id) {
		ProcessInstanceUntaggedDocuments processInstanceUntaggedDocuments = processInstanceUntaggedDocumentsDao
				.read(id);

		if (processInstanceUntaggedDocuments != null) {
			ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo = new ProcessInstanceUntaggedDocumentsVo(
					processInstanceUntaggedDocuments.getId());
			if (processInstanceUntaggedDocuments.getProcessInstance() != null)
				processInstanceUntaggedDocumentsVo.setProcessInstanceId(
						processInstanceUntaggedDocuments.getProcessInstance().getProcessInstanceId());
			if (processInstanceUntaggedDocuments.getUntaggedDocuments() != null)
				processInstanceUntaggedDocumentsVo
						.setUntaggedDocumentsId(processInstanceUntaggedDocuments.getUntaggedDocuments().getId());

			processInstanceUntaggedDocumentsVo.setStartDate(processInstanceUntaggedDocuments.getStartDate().getTime());

			if (processInstanceUntaggedDocuments.getEndDate() != null)
				processInstanceUntaggedDocumentsVo.setEndDate(processInstanceUntaggedDocuments.getEndDate().getTime());

			processInstanceUntaggedDocumentsVo.setRemarks(processInstanceUntaggedDocuments.getRemarks());

			return processInstanceUntaggedDocumentsVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<ProcessInstanceUntaggedDocumentsVo> listProcessInstanceUntaggedDocumentsService() {
		List<ProcessInstanceUntaggedDocuments> processInstanceUntaggedDocumentsList = processInstanceUntaggedDocumentsDao
				.findAll();

		List<ProcessInstanceUntaggedDocumentsVo> processInstanceUntaggedDocumentsVoList = null;

		if (processInstanceUntaggedDocumentsList.size() > 0) {
			processInstanceUntaggedDocumentsVoList = new ArrayList<ProcessInstanceUntaggedDocumentsVo>();

			for (ProcessInstanceUntaggedDocuments processInstanceUntaggedDocuments : processInstanceUntaggedDocumentsList) {
				ProcessInstanceUntaggedDocumentsVo processInstanceUntaggedDocumentsVo = new ProcessInstanceUntaggedDocumentsVo(
						processInstanceUntaggedDocuments.getId());
				if (processInstanceUntaggedDocuments.getProcessInstance() != null)
					processInstanceUntaggedDocumentsVo.setProcessInstanceId(
							processInstanceUntaggedDocuments.getProcessInstance().getProcessInstanceId());
				if (processInstanceUntaggedDocuments.getUntaggedDocuments() != null)
					processInstanceUntaggedDocumentsVo
							.setUntaggedDocumentsId(processInstanceUntaggedDocuments.getUntaggedDocuments().getId());

				processInstanceUntaggedDocumentsVo
						.setStartDate(processInstanceUntaggedDocuments.getStartDate().getTime());

				if (processInstanceUntaggedDocuments.getEndDate() != null)
					processInstanceUntaggedDocumentsVo
							.setEndDate(processInstanceUntaggedDocuments.getEndDate().getTime());

				processInstanceUntaggedDocumentsVo.setRemarks(processInstanceUntaggedDocuments.getRemarks());

				processInstanceUntaggedDocumentsVoList.add(processInstanceUntaggedDocumentsVo);
			}

		} else {
			processInstanceUntaggedDocumentsVoList = new ArrayList<ProcessInstanceUntaggedDocumentsVo>(0);

		}
		return processInstanceUntaggedDocumentsVoList;
	}

}
