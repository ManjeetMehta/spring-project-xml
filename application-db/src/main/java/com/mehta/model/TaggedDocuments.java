package com.mehta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
@Entity
@Table(name="tagged_documents")
public class TaggedDocuments implements Serializable {

private String docUuid;
private Date created;
private Long createdBy; 
private Date lastModified;
private Long lastModifiedBy; 
private Long createdByTaskId;
public TaggedDocuments() {
	super();
}
public TaggedDocuments(String docUuid) {
	super();
	this.docUuid = docUuid;
}
public TaggedDocuments(Date created, Long createdBy, Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
	super();
	this.created = created;
	this.createdBy = createdBy;
	this.lastModified = lastModified;
	this.lastModifiedBy = lastModifiedBy;
	this.createdByTaskId = createdByTaskId;
}
@Id
@Column(name = "doc_uuid", unique = true, nullable = false, length = 100)
public String getDocUuid() {
	return docUuid;
}
public void setDocUuid(String docUuid) {
	this.docUuid = docUuid;
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
@Version
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
