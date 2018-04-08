package com.mehta.common.vo;

import java.io.Serializable;

public class EmployeeUntaggedDocumentsVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer employeeId;
	private Long untaggedDocumentsId;
	private Long startDate;
	private Long endDate;
	private String remarks;

	public EmployeeUntaggedDocumentsVo() {
		super();
	}

	public EmployeeUntaggedDocumentsVo(Long id) {
		super();
		this.id = id;
	}

	public EmployeeUntaggedDocumentsVo(Integer employeeId, Long untaggedDocumentsId, Long startDate, Long endDate,
			String remarks) {
		super();
		this.employeeId = employeeId;
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
