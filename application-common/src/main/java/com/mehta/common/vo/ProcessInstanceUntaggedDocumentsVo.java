package com.mehta.common.vo;

import java.io.Serializable;

public class ProcessInstanceUntaggedDocumentsVo implements Serializable {
	private static final long serialVersionUID = 1l;

	private Long id;
	private Long processInstanceId;
	private Long untaggedDocumentsId;
	private Long startDate;
	private Long endDate;
	private String remarks;

	public ProcessInstanceUntaggedDocumentsVo() {
		super();
	}

	public ProcessInstanceUntaggedDocumentsVo(Long id) {
		super();
		this.id = id;
	}

	public ProcessInstanceUntaggedDocumentsVo(Long processInstanceId, Long untaggedDocumentsId, Long startDate,
			Long endDate, String remarks) {
		super();
		this.processInstanceId = processInstanceId;
		this.untaggedDocumentsId = untaggedDocumentsId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(Long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public Long getUntaggedDocumentsId() {
		return untaggedDocumentsId;
	}

	public void setUntaggedDocumentsId(Long untaggedDocumentsId) {
		this.untaggedDocumentsId = untaggedDocumentsId;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
