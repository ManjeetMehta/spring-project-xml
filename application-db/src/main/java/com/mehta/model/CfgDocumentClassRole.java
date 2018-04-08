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
@Table(name = "cfg_document_class_role")
public class CfgDocumentClassRole implements Serializable {

	private Integer id;
	private CfgDocumentClass cfgDocumentClass;
	private Role role;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public CfgDocumentClassRole() {
		super();
	}

	public CfgDocumentClassRole(Integer id) {
		super();
		this.id = id;
	}

	public CfgDocumentClassRole(CfgDocumentClass cfgDocumentClass, Role role, Date created, Long createdBy,
			Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.setCfgDocumentClass(cfgDocumentClass);
		this.setRole(role);
		this.created = created;
		this.createdBy = createdBy;
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
	@JoinColumn(name="cfg_document_class_id", nullable = false)
	public CfgDocumentClass getCfgDocumentClass() {
		return cfgDocumentClass;
	}

	public void setCfgDocumentClass(CfgDocumentClass cfgDocumentClass) {
		this.cfgDocumentClass = cfgDocumentClass;
	}



	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
