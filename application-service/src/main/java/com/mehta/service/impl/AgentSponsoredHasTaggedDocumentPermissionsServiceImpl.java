package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.AgentSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.dao.AgentSponsoredDao;
import com.mehta.dao.AgentSponsoredHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.AgentSponsored;
import com.mehta.model.AgentSponsoredHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.AgentSponsoredHasTaggedDocumentPermissionsService;

@Component
public class AgentSponsoredHasTaggedDocumentPermissionsServiceImpl
		implements AgentSponsoredHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(AgentSponsoredHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private AgentSponsoredHasTaggedDocumentPermissionsDao agentSponsoredHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private AgentSponsoredDao agentSponsoredDao;

	@Override
	public Integer create(AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo,
			String userId) {
		TaggedDocuments taggedDocuments = null;
		if (agentSponsoredHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(agentSponsoredHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		AgentSponsored agentSponsored = null;
		if (agentSponsoredHasTaggedDocumentPermissionsVo.getAgentSponsoredId() != null) {
			agentSponsored = agentSponsoredDao.read(agentSponsoredHasTaggedDocumentPermissionsVo.getAgentSponsoredId());
			if (agentSponsored == null) {
				logger.warn("Invalid agentSponsoredId.....................");
				return null;
			}
		} else {
			logger.warn("agentSponsoredId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = agentSponsoredHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		AgentSponsoredHasTaggedDocumentPermissions agentSponsoredHasTaggedDocumentPermissions = new AgentSponsoredHasTaggedDocumentPermissions(
				taggedDocuments, agentSponsored, startDate, endDate, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		return agentSponsoredHasTaggedDocumentPermissionsDao.create(agentSponsoredHasTaggedDocumentPermissions);
	}

	@Override
	public void update(AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo,
			String userId) {
		AgentSponsoredHasTaggedDocumentPermissions agentSponsoredHasTaggedDocumentPermissions = agentSponsoredHasTaggedDocumentPermissionsDao
				.read(agentSponsoredHasTaggedDocumentPermissionsVo.getId());
		if (agentSponsoredHasTaggedDocumentPermissions != null) {
			if (agentSponsoredHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				TaggedDocuments taggedDocuments = taggedDocumentsDao
						.read(agentSponsoredHasTaggedDocumentPermissionsVo.getDocUuid());
				System.out.println(taggedDocuments + "\n\n\n\n\n\n\n\n\n\n\n\n\n");
				if (taggedDocuments == null) {
					logger.warn("Invalid docUuid.....................");
					return;
				}
				agentSponsoredHasTaggedDocumentPermissions.setTaggedDocuments(taggedDocuments);
			}

			if (agentSponsoredHasTaggedDocumentPermissionsVo.getAgentSponsoredId() != null) {
				AgentSponsored agentSponsored = agentSponsoredDao
						.read(agentSponsoredHasTaggedDocumentPermissionsVo.getAgentSponsoredId());
				if (agentSponsoredHasTaggedDocumentPermissions.getAgentSponsored() == null) {
					logger.warn("Invalid agentSponsoredId.....................");
					return;
				}
				agentSponsoredHasTaggedDocumentPermissions.setAgentSponsored(agentSponsored);
			}

			if (agentSponsoredHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				agentSponsoredHasTaggedDocumentPermissions
						.setStartDate(agentSponsoredHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (agentSponsoredHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				agentSponsoredHasTaggedDocumentPermissions
						.setEndDate(agentSponsoredHasTaggedDocumentPermissionsVo.getEndDate());
			}

			agentSponsoredHasTaggedDocumentPermissions.setLastModified(new Date());
			agentSponsoredHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			agentSponsoredHasTaggedDocumentPermissionsDao.update(agentSponsoredHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public AgentSponsoredHasTaggedDocumentPermissionsVo read(Integer id) {
		AgentSponsoredHasTaggedDocumentPermissions agentSponsoredHasTaggedDocumentPermissions = agentSponsoredHasTaggedDocumentPermissionsDao
				.read(id);
		if (agentSponsoredHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (agentSponsoredHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = agentSponsoredHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Integer agentSponsoredId = null;
			if (agentSponsoredHasTaggedDocumentPermissions.getAgentSponsored() != null) {
				agentSponsoredId = agentSponsoredHasTaggedDocumentPermissions.getAgentSponsored().getId();
			}
			Date startDate = agentSponsoredHasTaggedDocumentPermissions.getStartDate();
			Date endDate = agentSponsoredHasTaggedDocumentPermissions.getEndDate();
			AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = new AgentSponsoredHasTaggedDocumentPermissionsVo(
					id, docUuid, agentSponsoredId, startDate, endDate);
			return agentSponsoredHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<AgentSponsoredHasTaggedDocumentPermissionsVo> list() {
		List<AgentSponsoredHasTaggedDocumentPermissionsVo> agentSponsoredHasTaggedDocumentPermissionsVos = new ArrayList<AgentSponsoredHasTaggedDocumentPermissionsVo>();
		List<AgentSponsoredHasTaggedDocumentPermissions> agentSponsoredHasTaggedDocumentPermissionsList = agentSponsoredHasTaggedDocumentPermissionsDao
				.findAll();
		if (agentSponsoredHasTaggedDocumentPermissionsList.size() > 0) {
			for (AgentSponsoredHasTaggedDocumentPermissions agentSponsoredHasTaggedDocumentPermissions : agentSponsoredHasTaggedDocumentPermissionsList) {
				Integer id = agentSponsoredHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (agentSponsoredHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = agentSponsoredHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Integer agentSponsoredId = null;
				if (agentSponsoredHasTaggedDocumentPermissions.getAgentSponsored() != null) {
					agentSponsoredId = agentSponsoredHasTaggedDocumentPermissions.getAgentSponsored().getId();
				}
				Date startDate = agentSponsoredHasTaggedDocumentPermissions.getStartDate();
				Date endDate = agentSponsoredHasTaggedDocumentPermissions.getEndDate();
				AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo = new AgentSponsoredHasTaggedDocumentPermissionsVo(
						id, docUuid, agentSponsoredId, startDate, endDate);
				agentSponsoredHasTaggedDocumentPermissionsVos.add(agentSponsoredHasTaggedDocumentPermissionsVo);
			}

		}
		return agentSponsoredHasTaggedDocumentPermissionsVos;
	}

}
