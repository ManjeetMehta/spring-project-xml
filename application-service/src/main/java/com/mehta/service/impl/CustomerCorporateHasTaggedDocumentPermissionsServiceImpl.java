package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.CustomerCorporateHasTaggedDocumentPermissionsVo;
import com.mehta.dao.CustomerCorporateDao;
import com.mehta.dao.CustomerCorporateHasTaggedDocumentPermissionsDao;
import com.mehta.dao.TaggedDocumentsDao;
import com.mehta.model.CustomerCorporate;
import com.mehta.model.CustomerCorporateHasTaggedDocumentPermissions;
import com.mehta.model.TaggedDocuments;
import com.mehta.service.CustomerCorporateHasTaggedDocumentPermissionsService;

@Component
public class CustomerCorporateHasTaggedDocumentPermissionsServiceImpl
		implements CustomerCorporateHasTaggedDocumentPermissionsService {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerCorporateHasTaggedDocumentPermissionsServiceImpl.class);

	@Autowired
	private CustomerCorporateHasTaggedDocumentPermissionsDao customerCorporateHasTaggedDocumentPermissionsDao;

	@Autowired
	private TaggedDocumentsDao taggedDocumentsDao;

	@Autowired
	private CustomerCorporateDao customerCorporateDao;

	@Override
	public Integer customerCorporateHasTaggedDocumentPermissionsCreate(
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo,
			String userId) {
		TaggedDocuments taggedDocuments = null;
		if (customerCorporateHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
			taggedDocuments = taggedDocumentsDao.read(customerCorporateHasTaggedDocumentPermissionsVo.getDocUuid());
			if (taggedDocuments == null) {
				logger.warn("Invalid docUuid.....................");
				return null;
			}
		} else {
			logger.warn("docUuid cannot be null..................");
			return null;
		}
		CustomerCorporate customerCorporate = null;
		if (customerCorporateHasTaggedDocumentPermissionsVo.getCustomerCorporateId() != null) {
			customerCorporate = customerCorporateDao
					.read(customerCorporateHasTaggedDocumentPermissionsVo.getCustomerCorporateId());
			if (customerCorporate == null) {
				logger.warn("Invalid customerCorporateId.....................");
				return null;
			}
		} else {
			logger.warn("customerCorporateId cannot be null..................");
			return null;
		}
		Date startDate = new Date();
		Date endDate = customerCorporateHasTaggedDocumentPermissionsVo.getEndDate();
		if (endDate == null) {
			logger.warn("endDate cannot be null..................");
			return null;
		}
		Date created = new Date();
		Long createdBy = Long.parseLong(userId);
		Date lastModified = new Date();
		Long lastModifiedBy = Long.parseLong(userId);
		Long createdByTaskId = Long.parseLong(userId);
		CustomerCorporateHasTaggedDocumentPermissions customerCorporateHasTaggedDocumentPermissions = new CustomerCorporateHasTaggedDocumentPermissions(
				taggedDocuments, customerCorporate, startDate, endDate, created, createdBy, lastModified,
				lastModifiedBy, createdByTaskId);
		return customerCorporateHasTaggedDocumentPermissionsDao.create(customerCorporateHasTaggedDocumentPermissions);
	}

	@Override
	public void customerCorporateHasTaggedDocumentPermissionsUpdate(
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo,
			String userId) {
		CustomerCorporateHasTaggedDocumentPermissions customerCorporateHasTaggedDocumentPermissions = customerCorporateHasTaggedDocumentPermissionsDao
				.read(customerCorporateHasTaggedDocumentPermissionsVo.getId());
		if (customerCorporateHasTaggedDocumentPermissions != null) {
			if (customerCorporateHasTaggedDocumentPermissionsVo.getDocUuid() != null) {
				customerCorporateHasTaggedDocumentPermissions.setTaggedDocuments(
						taggedDocumentsDao.read(customerCorporateHasTaggedDocumentPermissionsVo.getDocUuid()));
				if (customerCorporateHasTaggedDocumentPermissions.getTaggedDocuments() == null) {
					logger.warn("Invalid docUuid.....................");
				}
			}
			if (customerCorporateHasTaggedDocumentPermissionsVo.getCustomerCorporateId() != null) {
				customerCorporateHasTaggedDocumentPermissions.setCustomerCorporate(customerCorporateDao
						.read(customerCorporateHasTaggedDocumentPermissionsVo.getCustomerCorporateId()));
				if (customerCorporateHasTaggedDocumentPermissions.getCustomerCorporate() == null) {
					logger.warn("Invalid customerCorporateId.....................");
					return;
				}
			}
			if (customerCorporateHasTaggedDocumentPermissionsVo.getStartDate() != null) {
				customerCorporateHasTaggedDocumentPermissions
						.setStartDate(customerCorporateHasTaggedDocumentPermissionsVo.getStartDate());
			}
			if (customerCorporateHasTaggedDocumentPermissionsVo.getEndDate() != null) {
				customerCorporateHasTaggedDocumentPermissions
						.setEndDate(customerCorporateHasTaggedDocumentPermissionsVo.getEndDate());
			}

			customerCorporateHasTaggedDocumentPermissions.setLastModified(new Date());
			customerCorporateHasTaggedDocumentPermissions.setLastModifiedBy(Long.parseLong(userId));

			customerCorporateHasTaggedDocumentPermissionsDao.update(customerCorporateHasTaggedDocumentPermissions);
		} else {
			logger.warn("Record not found..................");
		}
	}

	@Override
	public CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsRead(
			Integer id) {
		CustomerCorporateHasTaggedDocumentPermissions customerCorporateHasTaggedDocumentPermissions = customerCorporateHasTaggedDocumentPermissionsDao
				.read(id);
		if (customerCorporateHasTaggedDocumentPermissions != null) {
			String docUuid = null;
			if (customerCorporateHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
				docUuid = customerCorporateHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
			}
			Integer customerCorporateId = null;
			if (customerCorporateHasTaggedDocumentPermissions.getCustomerCorporate() != null) {
				customerCorporateId = customerCorporateHasTaggedDocumentPermissions.getCustomerCorporate().getId();
			}
			Date startDate = customerCorporateHasTaggedDocumentPermissions.getStartDate();
			Date endDate = customerCorporateHasTaggedDocumentPermissions.getEndDate();
			CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = new CustomerCorporateHasTaggedDocumentPermissionsVo(
					id, docUuid, customerCorporateId, startDate, endDate);
			return customerCorporateHasTaggedDocumentPermissionsVo;
		} else {
			logger.warn("Record not found..................");
		}
		return null;
	}

	@Override
	public List<CustomerCorporateHasTaggedDocumentPermissionsVo> customerCorporateHasTaggedDocumentPermissionsList() {
		List<CustomerCorporateHasTaggedDocumentPermissionsVo> customerCorporateHasTaggedDocumentPermissionsVos = new ArrayList<CustomerCorporateHasTaggedDocumentPermissionsVo>();
		List<CustomerCorporateHasTaggedDocumentPermissions> customerCorporateHasTaggedDocumentPermissionsList = customerCorporateHasTaggedDocumentPermissionsDao
				.findAll();
		if (customerCorporateHasTaggedDocumentPermissionsList.size() > 0) {
			for (CustomerCorporateHasTaggedDocumentPermissions customerCorporateHasTaggedDocumentPermissions : customerCorporateHasTaggedDocumentPermissionsList) {
				Integer id = customerCorporateHasTaggedDocumentPermissions.getId();
				String docUuid = null;
				if (customerCorporateHasTaggedDocumentPermissions.getTaggedDocuments() != null) {
					docUuid = customerCorporateHasTaggedDocumentPermissions.getTaggedDocuments().getDocUuid();
				}
				Integer customerCorporateId = null;
				if (customerCorporateHasTaggedDocumentPermissions.getCustomerCorporate() != null) {
					customerCorporateId = customerCorporateHasTaggedDocumentPermissions.getCustomerCorporate().getId();
				}
				Date startDate = customerCorporateHasTaggedDocumentPermissions.getStartDate();
				Date endDate = customerCorporateHasTaggedDocumentPermissions.getEndDate();
				CustomerCorporateHasTaggedDocumentPermissionsVo customerCorporateHasTaggedDocumentPermissionsVo = new CustomerCorporateHasTaggedDocumentPermissionsVo(
						id, docUuid, customerCorporateId, startDate, endDate);
				customerCorporateHasTaggedDocumentPermissionsVos.add(customerCorporateHasTaggedDocumentPermissionsVo);
			}

		}
		return customerCorporateHasTaggedDocumentPermissionsVos;
	}

}
