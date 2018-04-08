package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.CustomerIndividualHasTaggedDocumentPermissionsVo;
import com.mehta.dao.CustomerIndividualDao;
import com.mehta.dao.CustomerIndividualHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.CustomerIndividual;
import com.mehta.model.CustomerIndividualHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.CustomerIndividualHasTaggedDocumentPermissionsService;

@Component
public class CustomerIndividualHasTaggedDocumentPermissionsServiceImpl
		implements CustomerIndividualHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerIndividualHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private CustomerIndividualHasTaggedDocumentPermissionsDao customerIndividualHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private CustomerIndividualDao customerIndividualDao;

	@Override
	public Integer customerIndividualHasTaggedDocumentPermissionsCreate(
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo,
			String userId) {
		TaggedDocuments taggedDocuments = null;
		if (customerIndividualHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(customerIndividualHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		CustomerIndividual customerIndividual = null;
		if (customerIndividualHasTaggedDocumentPermissionsVo.getCustomerIndividualId() != null) {
			customerIndividual = customerIndividualDao
					.read(customerIndividualHasTaggedDocumentPermissionsVo.getCustomerIndividualId());
			if (customerIndividual == null) {
				logger.warn("Invalid customerIndividualId.....................");
				return null;
			}
		} else {
			logger.warn("customerIndividualId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = customerIndividualHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		CustomerIndividualHasTaggedDocumentPermissions customerIndividualHasTaggedDocumentPermissions = new CustomerIndividualHasTaggedDocumentPermissions(
				taggedDocuments, customerIndividual, startDate, endDate, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);
		return customerIndividualHasTaggedDocumentPermissionsDao.create(customerIndividualHasTaggedDocumentPermissions);
	}

	@Override
	public void customerIndividualHasTaggedDocumentPermissionsUpdate(
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo,
			String userId) {
		CustomerIndividualHasTaggedDocumentPermissions customerIndividualHasTaggedDocumentPermissions = customerIndividualHasTaggedDocumentPermissionsDao
				.read(customerIndividualHasTaggedDocumentPermissionsVo.getId());
		if (customerIndividualHasTaggedDocumentPermissions != null) {
			if (customerIndividualHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				customerIndividualHasTaggedDocumentPermissions.setTaggedDocuments(
						taggedDocumentsDao.read(customerIndividualHasTaggedDocumentPermissionsVo.getDocUuid()));
				if (customerIndividualHasTaggedDocumentPermissions.getTaggedDocuments() == null) {
					logger.warn("Invalid docUuid.....................");
				}
			}
			if (customerIndividualHasTaggedDocumentPermissionsVo.getCustomerIndividualId() != null) {
				customerIndividualHasTaggedDocumentPermissions.setCustomerIndividual(customerIndividualDao
						.read(customerIndividualHasTaggedDocumentPermissionsVo.getCustomerIndividualId()));
				if (customerIndividualHasTaggedDocumentPermissions.getCustomerIndividual() == null) {
					logger.warn("Invalid customerIndividualId.....................");
					return;
				}
			}
			if (customerIndividualHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				customerIndividualHasTaggedDocumentPermissions
						.setStartDate(customerIndividualHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (customerIndividualHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				customerIndividualHasTaggedDocumentPermissions
						.setEndDate(customerIndividualHasTaggedDocumentPermissionsVo.getEndDate());
			}

			customerIndividualHasTaggedDocumentPermissions.setLastModified(new Date());
			customerIndividualHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			customerIndividualHasTaggedDocumentPermissionsDao.update(customerIndividualHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsRead(
			Integer id) {
		CustomerIndividualHasTaggedDocumentPermissions customerIndividualHasTaggedDocumentPermissions = customerIndividualHasTaggedDocumentPermissionsDao
				.read(id);
		if (customerIndividualHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (customerIndividualHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = customerIndividualHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Integer customerIndividualId = null;
			if (customerIndividualHasTaggedDocumentPermissions.getCustomerIndividual() != null) {
				customerIndividualId = customerIndividualHasTaggedDocumentPermissions.getCustomerIndividual().getId();
			}
			Date startDate = customerIndividualHasTaggedDocumentPermissions.getStartDate();
			Date endDate = customerIndividualHasTaggedDocumentPermissions.getEndDate();
			CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = new CustomerIndividualHasTaggedDocumentPermissionsVo(
					id, docUuid, customerIndividualId, startDate, endDate);
			return customerIndividualHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<CustomerIndividualHasTaggedDocumentPermissionsVo> customerIndividualHasTaggedDocumentPermissionsList() {
		List<CustomerIndividualHasTaggedDocumentPermissionsVo> customerIndividualHasTaggedDocumentPermissionsVos = new ArrayList<CustomerIndividualHasTaggedDocumentPermissionsVo>();
		List<CustomerIndividualHasTaggedDocumentPermissions> customerIndividualHasTaggedDocumentPermissionsList = customerIndividualHasTaggedDocumentPermissionsDao
				.findAll();
		if (customerIndividualHasTaggedDocumentPermissionsList.size() > 0) {
			for (CustomerIndividualHasTaggedDocumentPermissions customerIndividualHasTaggedDocumentPermissions : customerIndividualHasTaggedDocumentPermissionsList) {
				Integer id = customerIndividualHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (customerIndividualHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = customerIndividualHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Integer customerIndividualId = null;
				if (customerIndividualHasTaggedDocumentPermissions.getCustomerIndividual() != null) {
					customerIndividualId = customerIndividualHasTaggedDocumentPermissions.getCustomerIndividual()
							.getId();
				}
				Date startDate = customerIndividualHasTaggedDocumentPermissions.getStartDate();
				Date endDate = customerIndividualHasTaggedDocumentPermissions.getEndDate();
				CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo = new CustomerIndividualHasTaggedDocumentPermissionsVo(
						id, docUuid, customerIndividualId, startDate, endDate);
				customerIndividualHasTaggedDocumentPermissionsVos.add(customerIndividualHasTaggedDocumentPermissionsVo);
			}

		}
		return customerIndividualHasTaggedDocumentPermissionsVos;
	}

}
