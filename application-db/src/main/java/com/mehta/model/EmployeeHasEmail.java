package com.mehta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_has_email")
public class EmployeeHasEmail implements Serializable {

	private Integer id;
	private Employee employee;
	private ContactPointEmail contactPointEmail;
	private CfgRelationshipType cfgRelationshipType;
	private Integer priority;
	private String remarks;
	private Boolean active;
	private Date startDate;
	private Date endDate;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public EmployeeHasEmail() {
		super();
	}

	public EmployeeHasEmail(Integer id) {
		super();
		this.id = id;
	}

	public EmployeeHasEmail(Employee employee, ContactPointEmail contactPointEmail, CfgRelationshipType cfgRelationshipType, Integer priority,
			String remarks, Boolean active, Date startDate, Date endDate, Date created, Long createdBy,
			Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.employee = employee;
		this.contactPointEmail = contactPointEmail;
		this.cfgRelationshipType = cfgRelationshipType;
		this.priority = priority;
		this.remarks = remarks;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="email_contact_point_id")
	public ContactPointEmail getContactPointEmail() {
		return contactPointEmail;
	}

	public void setContactPointEmail(ContactPointEmail contactPointEmail) {
		this.contactPointEmail = contactPointEmail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="relationship_type_id")
	public CfgRelationshipType getCfgRelationshipType() {
		return cfgRelationshipType;
	}

	public void setCfgRelationshipType(CfgRelationshipType cfgRelationshipType) {
		this.cfgRelationshipType = cfgRelationshipType;
	}

	@Column(name = "priority")
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Column(name = "created_by_task_id", length = 20, nullable = true)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

}
