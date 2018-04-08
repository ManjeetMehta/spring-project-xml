package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class ContactPointEmailVo implements Serializable {
	private static final long serialVersionUID = -2924587995849485677L;
	private Integer id;
	private String emailId;
	private Date startDate;
	private Date endDate;
	private String contactFirstName;
	private String contactMiddleName;
	private String contactLastName;
	private Long parentId;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public ContactPointEmailVo() {
		super();
	}

	public ContactPointEmailVo(Integer id) {
		super();
		this.id = id;
	}

	public ContactPointEmailVo(String emailId, Date startDate, Date endDate, String contactFirstName,
			String contactMiddleName, String contactLastName, Long parentId, Date created, Long createdBy,
			Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.emailId = emailId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contactFirstName = contactFirstName;
		this.contactMiddleName = contactMiddleName;
		this.contactLastName = contactLastName;
		this.parentId = parentId;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactMiddleName() {
		return contactMiddleName;
	}

	public void setContactMiddleName(String contactMiddleName) {
		this.contactMiddleName = contactMiddleName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

}
