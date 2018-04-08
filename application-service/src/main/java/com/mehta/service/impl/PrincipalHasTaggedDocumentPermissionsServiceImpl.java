package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.PrincipalHasTaggedDocumentPermissionsVo;
import com.mehta.dao.PrincipalDao;
import com.mehta.dao.PrincipalHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.Principal;
import com.mehta.model.PrincipalHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.PrincipalHasTaggedDocumentPermissionsService;

@Component
public class PrincipalHasTaggedDocumentPermissionsServiceImpl implements PrincipalHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(PrincipalHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private PrincipalHasTaggedDocumentPermissionsDao principalHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private PrincipalDao principalDao;

	@Override
	public Integer principalHasTaggedDocumentPermissionsCreate(
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo, String userId) {
		TaggedDocuments taggedDocuments = null;
		if (principalHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(principalHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		Principal principal = null;
		if (principalHasTaggedDocumentPermissionsVo.getPrincipalId() != null) {
			principal = principalDao.read(principalHasTaggedDocumentPermissionsVo.getPrincipalId());
			if (principal == null) {
				logger.warn("Invalid principalId.....................");
				return null;
			}
		} else {
			logger.warn("principalId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = principalHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		PrincipalHasTaggedDocumentPermissions principalHasTaggedDocumentPermissions = new PrincipalHasTaggedDocumentPermissions(
				taggedDocuments, principal, startDate, endDate, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		return principalHasTaggedDocumentPermissionsDao.create(principalHasTaggedDocumentPermissions);
	}

	@Override
	public void principalHasTaggedDocumentPermissionsUpdate(
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo, String userId) {
		PrincipalHasTaggedDocumentPermissions principalHasTaggedDocumentPermissions = principalHasTaggedDocumentPermissionsDao
				.read(principalHasTaggedDocumentPermissionsVo.getId());
		if (principalHasTaggedDocumentPermissions != null) {
			if (principalHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				principalHasTaggedDocumentPermissions.setTaggedDocuments(
						taggedDocumentsDao.read(principalHasTaggedDocumentPermissionsVo.getDocUuid()));
				if (principalHasTaggedDocumentPermissions.getTaggedDocuments() == null) {
					logger.warn("Invalid docUuid.....................");
				}
			}
			if (principalHasTaggedDocumentPermissionsVo.getPrincipalId() != null) {
				principalHasTaggedDocumentPermissions
						.setPrincipal(principalDao.read(principalHasTaggedDocumentPermissionsVo.getPrincipalId()));
				if (principalHasTaggedDocumentPermissions.getPrincipal() == null) {
					logger.warn("Invalid principalId.....................");
					return;
				}
			}
			if (principalHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				principalHasTaggedDocumentPermissions
						.setStartDate(principalHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (principalHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				principalHasTaggedDocumentPermissions.setEndDate(principalHasTaggedDocumentPermissionsVo.getEndDate());
			}

			principalHasTaggedDocumentPermissions.setLastModified(new Date());
			principalHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			principalHasTaggedDocumentPermissionsDao.update(principalHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsRead(Integer id) {
		PrincipalHasTaggedDocumentPermissions principalHasTaggedDocumentPermissions = principalHasTaggedDocumentPermissionsDao
				.read(id);
		if (principalHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (principalHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = principalHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Integer principalId = null;
			if (principalHasTaggedDocumentPermissions.getPrincipal() != null) {
				principalId = principalHasTaggedDocumentPermissions.getPrincipal().getId();
			}
			Date startDate = principalHasTaggedDocumentPermissions.getStartDate();
			Date endDate = principalHasTaggedDocumentPermissions.getEndDate();
			PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = new PrincipalHasTaggedDocumentPermissionsVo(
					id, docUuid, principalId, startDate, endDate);
			return principalHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<PrincipalHasTaggedDocumentPermissionsVo> principalHasTaggedDocumentPermissionsList() {
		List<PrincipalHasTaggedDocumentPermissionsVo> principalHasTaggedDocumentPermissionsVos = new ArrayList<PrincipalHasTaggedDocumentPermissionsVo>();
		List<PrincipalHasTaggedDocumentPermissions> principalHasTaggedDocumentPermissionsList = principalHasTaggedDocumentPermissionsDao
				.findAll();
		if (principalHasTaggedDocumentPermissionsList.size() > 0) {
			for (PrincipalHasTaggedDocumentPermissions principalHasTaggedDocumentPermissions : principalHasTaggedDocumentPermissionsList) {
				Integer id = principalHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (principalHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = principalHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Integer principalId = null;
				if (principalHasTaggedDocumentPermissions.getPrincipal() != null) {
					principalId = principalHasTaggedDocumentPermissions.getPrincipal().getId();
				}
				Date startDate = principalHasTaggedDocumentPermissions.getStartDate();
				Date endDate = principalHasTaggedDocumentPermissions.getEndDate();
				PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo = new PrincipalHasTaggedDocumentPermissionsVo(
						id, docUuid, principalId, startDate, endDate);
				principalHasTaggedDocumentPermissionsVos.add(principalHasTaggedDocumentPermissionsVo);
			}

		}
		return principalHasTaggedDocumentPermissionsVos;
	}

}
