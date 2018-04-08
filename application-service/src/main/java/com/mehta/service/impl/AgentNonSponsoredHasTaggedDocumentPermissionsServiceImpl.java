package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.AgentNonSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.dao.AgentNonSponsoredDao;
import com.mehta.dao.AgentNonSponsoredHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.AgentNonSponsored;
import com.mehta.model.AgentNonSponsoredHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.AgentNonSponsoredHasTaggedDocumentPermissionsService;

@Component
public class AgentNonSponsoredHasTaggedDocumentPermissionsServiceImpl
		implements AgentNonSponsoredHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(AgentNonSponsoredHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private AgentNonSponsoredHasTaggedDocumentPermissionsDao agentNonSponsoredHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private AgentNonSponsoredDao agentNonSponsoredDao;

	@Override
	public Integer agentNonSponsoredHasTaggedDocumentPermissionsCreate(
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo,
			String userId) {
		TaggedDocuments taggedDocuments = null;
		if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(agentNonSponsoredHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		AgentNonSponsored agentNonSponsored = null;
		if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getAgentNonSponsoredId() != null) {
			agentNonSponsored = agentNonSponsoredDao
					.read(agentNonSponsoredHasTaggedDocumentPermissionsVo.getAgentNonSponsoredId());
			if (agentNonSponsored == null) {
				logger.warn("Invalid agentNonSponsoredId.....................");
				return null;
			}
		} else {
			logger.warn("agentNonSponsoredId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = agentNonSponsoredHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		AgentNonSponsoredHasTaggedDocumentPermissions agentNonSponsoredHasTaggedDocumentPermissions = new AgentNonSponsoredHasTaggedDocumentPermissions(
				taggedDocuments, agentNonSponsored, startDate, endDate, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);
		return agentNonSponsoredHasTaggedDocumentPermissionsDao.create(agentNonSponsoredHasTaggedDocumentPermissions);
	}

	@Override
	public void agentNonSponsoredHasTaggedDocumentPermissionsUpdate(
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo,
			String userId) {
		AgentNonSponsoredHasTaggedDocumentPermissions agentNonSponsoredHasTaggedDocumentPermissions = agentNonSponsoredHasTaggedDocumentPermissionsDao
				.read(agentNonSponsoredHasTaggedDocumentPermissionsVo.getId());
		if (agentNonSponsoredHasTaggedDocumentPermissions != null) {
			if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				TaggedDocuments taggedDocuments = taggedDocumentsDao
						.read(agentNonSponsoredHasTaggedDocumentPermissionsVo.getDocUuid());
				if (taggedDocuments == null) {
					logger.warn("Invalid docUuid.....................");
					return;
				}
				agentNonSponsoredHasTaggedDocumentPermissions.setTaggedDocuments(taggedDocuments);
			}

			if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getAgentNonSponsoredId() != null) {
				AgentNonSponsored agentNonSponsored = agentNonSponsoredDao
						.read(agentNonSponsoredHasTaggedDocumentPermissionsVo.getAgentNonSponsoredId());
				if (agentNonSponsoredHasTaggedDocumentPermissions.getAgentNonSponsored() == null) {
					logger.warn("Invalid agentNonSponsoredId.....................");
					return;
				}
				agentNonSponsoredHasTaggedDocumentPermissions.setAgentNonSponsored(agentNonSponsored);
			}

			if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				agentNonSponsoredHasTaggedDocumentPermissions
						.setStartDate(agentNonSponsoredHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (agentNonSponsoredHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				agentNonSponsoredHasTaggedDocumentPermissions
						.setEndDate(agentNonSponsoredHasTaggedDocumentPermissionsVo.getEndDate());
			}

			agentNonSponsoredHasTaggedDocumentPermissions.setLastModified(new Date());
			agentNonSponsoredHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			agentNonSponsoredHasTaggedDocumentPermissionsDao.update(agentNonSponsoredHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsRead(
			Integer id) {
		AgentNonSponsoredHasTaggedDocumentPermissions agentNonSponsoredHasTaggedDocumentPermissions = agentNonSponsoredHasTaggedDocumentPermissionsDao
				.read(id);
		if (agentNonSponsoredHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (agentNonSponsoredHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = agentNonSponsoredHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Integer agentNonSponsoredId = null;
			if (agentNonSponsoredHasTaggedDocumentPermissions.getAgentNonSponsored() != null) {
				agentNonSponsoredId = agentNonSponsoredHasTaggedDocumentPermissions.getAgentNonSponsored().getId();
			}
			Date startDate = agentNonSponsoredHasTaggedDocumentPermissions.getStartDate();
			Date endDate = agentNonSponsoredHasTaggedDocumentPermissions.getEndDate();
			AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = new AgentNonSponsoredHasTaggedDocumentPermissionsVo(
					id, docUuid, agentNonSponsoredId, startDate, endDate);
			return agentNonSponsoredHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<AgentNonSponsoredHasTaggedDocumentPermissionsVo> agentNonSponsoredHasTaggedDocumentPermissionsList() {
		List<AgentNonSponsoredHasTaggedDocumentPermissionsVo> agentNonSponsoredHasTaggedDocumentPermissionsVos = new ArrayList<AgentNonSponsoredHasTaggedDocumentPermissionsVo>();
		List<AgentNonSponsoredHasTaggedDocumentPermissions> agentNonSponsoredHasTaggedDocumentPermissionsList = agentNonSponsoredHasTaggedDocumentPermissionsDao
				.findAll();
		if (agentNonSponsoredHasTaggedDocumentPermissionsList.size() > 0) {
			for (AgentNonSponsoredHasTaggedDocumentPermissions agentNonSponsoredHasTaggedDocumentPermissions : agentNonSponsoredHasTaggedDocumentPermissionsList) {
				Integer id = agentNonSponsoredHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (agentNonSponsoredHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = agentNonSponsoredHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Integer agentNonSponsoredId = null;
				if (agentNonSponsoredHasTaggedDocumentPermissions.getAgentNonSponsored() != null) {
					agentNonSponsoredId = agentNonSponsoredHasTaggedDocumentPermissions.getAgentNonSponsored().getId();
				}
				Date startDate = agentNonSponsoredHasTaggedDocumentPermissions.getStartDate();
				Date endDate = agentNonSponsoredHasTaggedDocumentPermissions.getEndDate();
				AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo = new AgentNonSponsoredHasTaggedDocumentPermissionsVo(
						id, docUuid, agentNonSponsoredId, startDate, endDate);
				agentNonSponsoredHasTaggedDocumentPermissionsVos.add(agentNonSponsoredHasTaggedDocumentPermissionsVo);
			}

		}
		return agentNonSponsoredHasTaggedDocumentPermissionsVos;
	}

}
