package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.ContactPointEmailVo;
import com.mehta.dao.ContactPointEmailDao;
import com.mehta.model.ContactPointEmail;
import com.mehta.service.ContactPointEmailService;

@Component
public class ContactPointEmailServiceImpl implements ContactPointEmailService {

	@Autowired
	private ContactPointEmailDao contactPointEmailDao;

	@Override
	public Integer create(ContactPointEmailVo contactPointEmailVo) {
		String emailId = contactPointEmailVo.getEmailId();
		Date startDate = new Date();
		Date endDate = new Date();
		String contactFirstName = contactPointEmailVo.getContactFirstName();
		String contactMiddleName = contactPointEmailVo.getContactMiddleName();
		String contactLastName = contactPointEmailVo.getContactLastName();
		Long parentId = contactPointEmailVo.getParentId();
		Date created = new Date();
		Long createdBy = contactPointEmailVo.getCreatedBy();
		Date lastModified = new Date();
		Long lastModifiedBy = contactPointEmailVo.getLastModifiedBy();
		Long createdByTaskId = contactPointEmailVo.getCreatedByTaskId();
		ContactPointEmail contactPointEmail = new ContactPointEmail(emailId, startDate, endDate, contactFirstName,
				contactMiddleName, contactLastName, parentId, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);
		Integer id1 = contactPointEmailDao.create(contactPointEmail);
		contactPointEmailVo.setId(id1);
		if (!(id1 > 0))
			throw new RuntimeException("Exception while creating ContactPointEmail");

		return id1;
	}

	@Override
	public void update(ContactPointEmailVo contactPointEmailVo) {
		ContactPointEmail contactPointEmail = contactPointEmailDao.read(contactPointEmailVo.getId());
		if (contactPointEmail != null) {
			String emailId = contactPointEmailVo.getEmailId();
			Date startDate = new Date();
			Date endDate = new Date();
			String contactFirstName = contactPointEmailVo.getContactFirstName();
			String contactMiddleName = contactPointEmailVo.getContactMiddleName();
			String contactLastName = contactPointEmailVo.getContactLastName();
			Long parentId = contactPointEmailVo.getParentId();
			Date created = new Date();
			Long createdBy = contactPointEmailVo.getCreatedBy();
			Date lastModified = new Date();
			Long lastModifiedBy = contactPointEmailVo.getLastModifiedBy();
			Long createdByTaskId = contactPointEmailVo.getCreatedByTaskId();
			contactPointEmail = new ContactPointEmail(emailId, startDate, endDate, contactFirstName, contactMiddleName,
					contactLastName, parentId, created, createdBy, lastModified, lastModifiedBy, createdByTaskId);
			contactPointEmail.setId(contactPointEmailVo.getId());
			contactPointEmailDao.update(contactPointEmail);
		} else {
			throw new RuntimeException("Record not found.....please check the input id.....");
		}

	}

	@Override
	public ContactPointEmailVo read(Integer id) {
		ContactPointEmail contactPointEmail = contactPointEmailDao.read(id);
		if (contactPointEmail != null) {
			String emailId = contactPointEmail.getEmailId();
			Date startDate = contactPointEmail.getStartDate();
			Date endDate = contactPointEmail.getEndDate();
			String contactFirstName = contactPointEmail.getContactFirstName();
			String contactMiddleName = contactPointEmail.getContactMiddleName();
			String contactLastName = contactPointEmail.getContactLastName();
			Long parentId = contactPointEmail.getParentId();
			Date created = contactPointEmail.getCreated();
			Long createdBy = contactPointEmail.getCreatedBy();
			Date lastModified = contactPointEmail.getLastModified();
			Long lastModifiedBy = contactPointEmail.getLastModifiedBy();
			Long createdByTaskId = contactPointEmail.getCreatedByTaskId();
			ContactPointEmailVo contactPointEmailVo = new ContactPointEmailVo(emailId, startDate, endDate,
					contactFirstName, contactMiddleName, contactLastName, parentId, created, createdBy, lastModified,
					lastModifiedBy, createdByTaskId);
			contactPointEmailVo.setId(id);
			return contactPointEmailVo;
		} else {
			throw new RuntimeException("Record not found.................");
		}
	}

	@Override
	public void delete(Integer id) {
		ContactPointEmail contactPointEmail = contactPointEmailDao.read(id);
		if (contactPointEmail != null) {
			contactPointEmailDao.delete(contactPointEmail);
		} else {
			throw new RuntimeException("Record not found.................");
		}
	}

	@Override
	public List<ContactPointEmailVo> list() {
		List<ContactPointEmailVo> contactPointEmailVos = null;
		List<ContactPointEmail> contactPointEmailList = contactPointEmailDao.findAll();
		if (contactPointEmailList != null && contactPointEmailList.size() > 0) {
			contactPointEmailVos = new ArrayList<ContactPointEmailVo>();
			for (ContactPointEmail contactPointEmail : contactPointEmailList) {

				String emailId = contactPointEmail.getEmailId();
				Date startDate = contactPointEmail.getStartDate();
				Date endDate = contactPointEmail.getEndDate();
				String contactFirstName = contactPointEmail.getContactFirstName();
				String contactMiddleName = contactPointEmail.getContactMiddleName();
				String contactLastName = contactPointEmail.getContactLastName();
				Long parentId = contactPointEmail.getParentId();
				Date created = contactPointEmail.getCreated();
				Long createdBy = contactPointEmail.getCreatedBy();
				Date lastModified = contactPointEmail.getLastModified();
				Long lastModifiedBy = contactPointEmail.getLastModifiedBy();
				Long createdByTaskId = contactPointEmail.getCreatedByTaskId();
				ContactPointEmailVo contactPointEmailVo = new ContactPointEmailVo(emailId, startDate, endDate,
						contactFirstName, contactMiddleName, contactLastName, parentId, created, createdBy,
						lastModified, lastModifiedBy, createdByTaskId);
				contactPointEmailVo.setId(contactPointEmail.getId());
				contactPointEmailVos.add(contactPointEmailVo);
			}
		}
		return contactPointEmailVos;
	}

}
