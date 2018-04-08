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

@Entity
@Table(name = "system_email")
public class SystemEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String subject;
	private String subjectUniqueId;
	private String body;
	private String contentType;
	private String senderEmailId;
	private Date receiveTime;
	private Date sendTime;
	private Integer attachmentCount;
	private Date pullTime;
	private String status;
	private String quartzJobId;
	private Integer parentId;
	private String subjectRefToken;
	private Boolean tagged;
	private Boolean archrived;
	private Boolean classified;
	private Boolean fallbackLocked;
	private Integer inOutFlag;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public SystemEmail() {
		super();
	}

	public SystemEmail(Integer id) {
		super();
		this.id = id;
	}

	public SystemEmail(String subject, String subjectUniqueId, String body, String contentType, String senderEmailId,
			Date receiveTime, Date sendTime, Integer attachmentCount, Date pullTime, String status, String quartzJobId,
			Integer parentId, String subjectRefToken, Boolean tagged, Boolean archrived, Boolean classified,
			Boolean fallbackLocked, Integer inOutFlag, Date created, Long createdBy, Date lastModified,
			Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.subject = subject;
		this.subjectUniqueId = subjectUniqueId;
		this.body = body;
		this.contentType = contentType;
		this.senderEmailId = senderEmailId;
		this.receiveTime = receiveTime;
		this.sendTime = sendTime;
		this.attachmentCount = attachmentCount;
		this.pullTime = pullTime;
		this.status = status;
		this.quartzJobId = quartzJobId;
		this.parentId = parentId;
		this.subjectRefToken = subjectRefToken;
		this.tagged = tagged;
		this.archrived = archrived;
		this.classified = classified;
		this.fallbackLocked = fallbackLocked;
		this.inOutFlag = inOutFlag;
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

	@Column(name = "subject", length = 1000)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "subject_unique_id", length = 20)
	public String getSubjectUniqueId() {
		return subjectUniqueId;
	}

	public void setSubjectUniqueId(String subjectUniqueId) {
		this.subjectUniqueId = subjectUniqueId;
	}

	@Column(name = "body")
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Column(name = "content_type", length = 100)
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "sender_email_id", length = 100)
	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receive_time")
	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_time")
	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "attachment_count", length = 21)
	public Integer getAttachmentCount() {
		return attachmentCount;
	}

	public void setAttachmentCount(Integer attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pull_time")
	public Date getPullTime() {
		return pullTime;
	}

	public void setPullTime(Date pullTime) {
		this.pullTime = pullTime;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "quartz_job_id", length = 100)
	public String getQuartzJobId() {
		return quartzJobId;
	}

	public void setQuartzJobId(String quartzJobId) {
		this.quartzJobId = quartzJobId;
	}

	@Column(name = "parent_id", length = 11)
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "subject_ref_token", length = 200)
	public String getSubjectRefToken() {
		return subjectRefToken;
	}

	public void setSubjectRefToken(String subjectRefToken) {
		this.subjectRefToken = subjectRefToken;
	}

	@Column(name = "tagged")
	public Boolean getTagged() {
		return tagged;
	}

	public void setTagged(Boolean tagged) {
		this.tagged = tagged;
	}

	@Column(name = "archrived")
	public Boolean getArchrived() {
		return archrived;
	}

	public void setArchrived(Boolean archrived) {
		this.archrived = archrived;
	}

	@Column(name = "classified")
	public Boolean getClassified() {
		return classified;
	}

	public void setClassified(Boolean classified) {
		this.classified = classified;
	}

	@Column(name = "fallback_locked")
	public Boolean getFallbackLocked() {
		return fallbackLocked;
	}

	public void setFallbackLocked(Boolean fallbackLocked) {
		this.fallbackLocked = fallbackLocked;
	}

	@Column(name = "in_out_flag", length = 11)
	public Integer getInOutFlag() {
		return inOutFlag;
	}

	public void setInOutFlag(Integer inOutFlag) {
		this.inOutFlag = inOutFlag;
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

	@Column(name = "created_by_task_id", length = 20)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

}
