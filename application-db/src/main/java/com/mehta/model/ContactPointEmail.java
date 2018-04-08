package com.mehta.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "contact_point_email")
public class ContactPointEmail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672379629244409088L;

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
	
	public ContactPointEmail() {
		super();
	}
	
	public ContactPointEmail(Integer id) {
		super();
		this.id = id;
	}
	
	
	
	public ContactPointEmail(String emailId, Date startDate, Date endDate, String contactFirstName,
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "email_id", length = 45, unique = true)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "contact_first_name", length = 45)
	public String getContactFirstName() {
		return contactFirstName;
	}
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}
	@Column(name = "contact_middle_name", length = 45)
	public String getContactMiddleName() {
		return contactMiddleName;
	}
	public void setContactMiddleName(String contactMiddleName) {
		this.contactMiddleName = contactMiddleName;
	}
	@Column(name = "contact_last_name", length = 45)
	public String getContactLastName() {
		return contactLastName;
	}
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	@Column(name="parent_id", length=20)
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name = "created_by", length = 20, nullable = false)
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified", nullable = false)
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	@Column(name = "last_modified_by", length = 20, nullable = false)
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	@Column(name = "created_by_task_id", length = 20)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}
	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
