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
import javax.persistence.Version;

@Entity
@Table(name = "untagged_documents")
public class UntaggedDocuments implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private TaggedDocuments taggedDocuments;
	private byte[] docContents;
	private String fileName;
	private String fileSize;
	private Boolean deleted;
	private String remarks;
	private User uploadedBy;
	private Date taggedOn;
	private User taggedBy;
	private User copiedBy;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public UntaggedDocuments() {
		super();
	}

	public UntaggedDocuments(Long id) {
		super();
		this.id = id;
	}

	public UntaggedDocuments(TaggedDocuments taggedDocuments, byte[] docContents, String fileName, String fileSize,
			Boolean deleted, String remarks, User uploadedBy, Date taggedOn, User taggedBy, User copiedBy,
			Date created, Long createdBy, Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.taggedDocuments = taggedDocuments;
		this.docContents = docContents;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.deleted = deleted;
		this.remarks = remarks;
		this.uploadedBy = uploadedBy;
		this.taggedOn = taggedOn;
		this.taggedBy = taggedBy;
		this.copiedBy = copiedBy;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="doc_uuid")
	public TaggedDocuments getTaggedDocuments() {
		return taggedDocuments;
	}

	public void setTaggedDocuments(TaggedDocuments taggedDocuments) {
		this.taggedDocuments = taggedDocuments;
	}

	
	@Column(name = "doc_contents", nullable = false)
	public byte[] getDocContents() {
		return docContents;
	}

	public void setDocContents(byte[] docContents) {
		this.docContents = docContents;
	}

	@Column(name = "file_name", length = 200, nullable = false)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_size", length = 45, nullable = false)
	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "deleted")
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "remarks", length=200)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="uploaded_by")
	public User getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(User uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tagged_on")
	public Date getTaggedOn() {
		return taggedOn;
	}

	public void setTaggedOn(Date taggedOn) {
		this.taggedOn = taggedOn;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tagged_by")
	public User getTaggedBy() {
		return taggedBy;
	}

	public void setTaggedBy(User taggedBy) {
		this.taggedBy = taggedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="copied_by")
	public User getCopiedBy() {
		return copiedBy;
	}

	public void setCopiedBy(User copiedBy) {
		this.copiedBy = copiedBy;
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

	// @Version
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

	@Column(name = "created_by_task_id", length = 20, nullable = false)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

}
