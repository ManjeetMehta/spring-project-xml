package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class SystemEmailVo implements Serializable {
	private static final long serialVersionUID = -6079962450024296574L;

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

	public SystemEmailVo() {
		super();
	}

	public SystemEmailVo(Integer id) {
		super();
		this.id = id;
	}

	public SystemEmailVo(String subject, String subjectUniqueId, String body, String contentType, String senderEmailId,
			Date receiveTime, Date sendTime, Integer attachmentCount, Date pullTime, String status, String quartzJobId,
			Integer parentId, String subjectRefToken, Boolean tagged, Boolean archrived, Boolean classified,
			Boolean fallbackLocked, Integer inOutFlag) {
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
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectUniqueId() {
		return subjectUniqueId;
	}

	public void setSubjectUniqueId(String subjectUniqueId) {
		this.subjectUniqueId = subjectUniqueId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getAttachmentCount() {
		return attachmentCount;
	}

	public void setAttachmentCount(Integer attachmentCount) {
		this.attachmentCount = attachmentCount;
	}

	public Date getPullTime() {
		return pullTime;
	}

	public void setPullTime(Date pullTime) {
		this.pullTime = pullTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuartzJobId() {
		return quartzJobId;
	}

	public void setQuartzJobId(String quartzJobId) {
		this.quartzJobId = quartzJobId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getSubjectRefToken() {
		return subjectRefToken;
	}

	public void setSubjectRefToken(String subjectRefToken) {
		this.subjectRefToken = subjectRefToken;
	}

	public Boolean getTagged() {
		return tagged;
	}

	public void setTagged(Boolean tagged) {
		this.tagged = tagged;
	}

	public Boolean getArchrived() {
		return archrived;
	}

	public void setArchrived(Boolean archrived) {
		this.archrived = archrived;
	}

	public Boolean getClassified() {
		return classified;
	}

	public void setClassified(Boolean classified) {
		this.classified = classified;
	}

	public Boolean getFallbackLocked() {
		return fallbackLocked;
	}

	public void setFallbackLocked(Boolean fallbackLocked) {
		this.fallbackLocked = fallbackLocked;
	}

	public Integer getInOutFlag() {
		return inOutFlag;
	}

	public void setInOutFlag(Integer inOutFlag) {
		this.inOutFlag = inOutFlag;
	}

}
