package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.ProcessInstanceHasTaggedDocumentPermissionsVo;
import com.mehta.dao.ProcessInstanceDao;
import com.mehta.dao.ProcessInstanceHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.ProcessInstance;
import com.mehta.model.ProcessInstanceHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.ProcessInstanceHasTaggedDocumentPermissionsService;

@Component
public class ProcessInstanceHasTaggedDocumentPermissionsServiceImpl
		implements ProcessInstanceHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(ProcessInstanceHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private ProcessInstanceHasTaggedDocumentPermissionsDao processInstanceHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private ProcessInstanceDao processInstanceDao;

	@Override
	public Integer processInstanceHasTaggedDocumentPermissionsCreate(
			ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo,
			String userId) {
		TaggedDocuments taggedDocuments = null;
		if (processInstanceHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(processInstanceHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		ProcessInstance processInstance = null;
		if (processInstanceHasTaggedDocumentPermissionsVo.getProcessInstanceId() != null) {
			processInstance = processInstanceDao
					.read(processInstanceHasTaggedDocumentPermissionsVo.getProcessInstanceId());
			if (processInstance == null) {
				logger.warn("Invalid processInstanceId.....................");
				return null;
			}
		} else {
			logger.warn("processInstanceId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = processInstanceHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		ProcessInstanceHasTaggedDocumentPermissions processInstanceHasTaggedDocumentPermissions = new ProcessInstanceHasTaggedDocumentPermissions(
				taggedDocuments, processInstance, startDate, endDate, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		return processInstanceHasTaggedDocumentPermissionsDao.create(processInstanceHasTaggedDocumentPermissions);
	}

	@Override
	public void processInstanceHasTaggedDocumentPermissionsUpdate(
			ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo,
			String userId) {
		ProcessInstanceHasTaggedDocumentPermissions processInstanceHasTaggedDocumentPermissions = processInstanceHasTaggedDocumentPermissionsDao
				.read(processInstanceHasTaggedDocumentPermissionsVo.getId());
		if (processInstanceHasTaggedDocumentPermissions != null) {
			if (processInstanceHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				processInstanceHasTaggedDocumentPermissions.setTaggedDocuments(
						taggedDocumentsDao.read(processInstanceHasTaggedDocumentPermissionsVo.getDocUuid()));
				if (processInstanceHasTaggedDocumentPermissions.getTaggedDocuments() == null) {
					logger.warn("Invalid docUuid.....................");
				}
			}
			if (processInstanceHasTaggedDocumentPermissionsVo.getProcessInstanceId() != null) {
				processInstanceHasTaggedDocumentPermissions.setProcessInstance(
						processInstanceDao.read(processInstanceHasTaggedDocumentPermissionsVo.getProcessInstanceId()));
				if (processInstanceHasTaggedDocumentPermissions.getProcessInstance() == null) {
					logger.warn("Invalid processInstanceId.....................");
					return;
				}
			}
			if (processInstanceHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				processInstanceHasTaggedDocumentPermissions
						.setStartDate(processInstanceHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (processInstanceHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				processInstanceHasTaggedDocumentPermissions
						.setEndDate(processInstanceHasTaggedDocumentPermissionsVo.getEndDate());
			}

			processInstanceHasTaggedDocumentPermissions.setLastModified(new Date());
			processInstanceHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			processInstanceHasTaggedDocumentPermissionsDao.update(processInstanceHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsRead(Integer id) {
		ProcessInstanceHasTaggedDocumentPermissions processInstanceHasTaggedDocumentPermissions = processInstanceHasTaggedDocumentPermissionsDao
				.read(id);
		if (processInstanceHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (processInstanceHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = processInstanceHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Long processInstanceId = null;
			if (processInstanceHasTaggedDocumentPermissions.getProcessInstance() != null) {
				processInstanceId = processInstanceHasTaggedDocumentPermissions.getProcessInstance()
						.getProcessInstanceId();
			}
			Date startDate = processInstanceHasTaggedDocumentPermissions.getStartDate();
			Date endDate = processInstanceHasTaggedDocumentPermissions.getEndDate();
			ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = new ProcessInstanceHasTaggedDocumentPermissionsVo(
					id, docUuid, processInstanceId, startDate, endDate);
			return processInstanceHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<ProcessInstanceHasTaggedDocumentPermissionsVo> processInstanceHasTaggedDocumentPermissionsList() {
		List<ProcessInstanceHasTaggedDocumentPermissionsVo> processInstanceHasTaggedDocumentPermissionsVos = new ArrayList<ProcessInstanceHasTaggedDocumentPermissionsVo>();
		List<ProcessInstanceHasTaggedDocumentPermissions> processInstanceHasTaggedDocumentPermissionsList = processInstanceHasTaggedDocumentPermissionsDao
				.findAll();
		if (processInstanceHasTaggedDocumentPermissionsList.size() > 0) {
			for (ProcessInstanceHasTaggedDocumentPermissions processInstanceHasTaggedDocumentPermissions : processInstanceHasTaggedDocumentPermissionsList) {
				Integer id = processInstanceHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (processInstanceHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = processInstanceHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Long processInstanceId = null;
				if (processInstanceHasTaggedDocumentPermissions.getProcessInstance() != null) {
					processInstanceId = processInstanceHasTaggedDocumentPermissions.getProcessInstance()
							.getProcessInstanceId();
				}
				Date startDate = processInstanceHasTaggedDocumentPermissions.getStartDate();
				Date endDate = processInstanceHasTaggedDocumentPermissions.getEndDate();
				ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo = new ProcessInstanceHasTaggedDocumentPermissionsVo(
						id, docUuid, processInstanceId, startDate, endDate);
				processInstanceHasTaggedDocumentPermissionsVos.add(processInstanceHasTaggedDocumentPermissionsVo);
			}

		}
		return processInstanceHasTaggedDocumentPermissionsVos;
	}

}
