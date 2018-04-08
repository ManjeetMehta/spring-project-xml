package com.mehta.common.vo;

import java.io.Serializable;

public class UntaggedDocumentsVo implements Serializable {
	private static final long serialVersionUID = -6079962450024296574L;
	
	private Long id;
	private String taggedDocumentsId;
	private byte[] docContents;
	private String fileName;
	private String fileSize;
	private Boolean deleted;
	private String remarks;
	private Integer uploadedBy;
	private Long taggedOn;
	private Integer taggedBy;
	private Integer copiedBy;
	
	public UntaggedDocumentsVo() {
		super();
	}

	public UntaggedDocumentsVo(Long id) {
		super();
		this.id = id;
	}

	public UntaggedDocumentsVo(String taggedDocumentsId, byte[] docContents, String fileName, String fileSize,
			Boolean deleted, String remarks, Integer uploadedBy, Long taggedOn, Integer taggedBy, Integer copiedBy) {
		super();
		this.taggedDocumentsId = taggedDocumentsId;
		this.docContents = docContents;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.deleted = deleted;
		this.remarks = remarks;
		this.uploadedBy = uploadedBy;
		this.taggedOn = taggedOn;
		this.taggedBy = taggedBy;
		this.copiedBy = copiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getTaggedDocumentsId() {
		return taggedDocumentsId;
	}

	public void setTaggedDocumentsId(String taggedDocumentsId) {
		this.taggedDocumentsId = taggedDocumentsId;
	}

	public byte[] getDocContents() {
		return docContents;
	}

	public void setDocContents(byte[] docContents) {
		this.docContents = docContents;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Integer uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Long getTaggedOn() {
		return taggedOn;
	}

	public void setTaggedOn(Long taggedOn) {
		this.taggedOn = taggedOn;
	}

	public Integer getTaggedBy() {
		return taggedBy;
	}

	public void setTaggedBy(Integer taggedBy) {
		this.taggedBy = taggedBy;
	}

	public Integer getCopiedBy() {
		return copiedBy;
	}

	public void setCopiedBy(Integer copiedBy) {
		this.copiedBy = copiedBy;
	}
}
