package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class PrincipalHasEmailVo implements Serializable {
	private static final long serialVersionUID = -595084568839187513L;
	private Integer id;
	private Integer principalId;
	private Integer emailContactPointId;
	private Integer relationshipTypeId;
	private Integer priority;
	private String remarks;
	private Boolean active;
	private Date startDate;
	private Date endDate;

	public PrincipalHasEmailVo() {
		// TODO Auto-generated constructor stub
	}

	public PrincipalHasEmailVo(Integer id) {
		super();
		this.id = id;
	}

	public PrincipalHasEmailVo(Integer principalId, Integer emailContactPointId, Integer relationshipTypeId,
			Integer priority, String remarks, Boolean active, Date startDate, Date endDate) {
		super();
		this.principalId = principalId;
		this.emailContactPointId = emailContactPointId;
		this.relationshipTypeId = relationshipTypeId;
		this.priority = priority;
		this.remarks = remarks;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Integer principalId) {
		this.principalId = principalId;
	}

	public Integer getEmailContactPointId() {
		return emailContactPointId;
	}

	public void setEmailContactPointId(Integer emailContactPointId) {
		this.emailContactPointId = emailContactPointId;
	}

	public Integer getRelationshipTypeId() {
		return relationshipTypeId;
	}

	public void setRelationshipTypeId(Integer relationshipTypeId) {
		this.relationshipTypeId = relationshipTypeId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
