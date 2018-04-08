package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class PrincipalHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = 6656182501141980088L;
	private Integer id;
	private String docUuid;
	private Integer principalId;
	private Date startDate;
	private Date endDate;

	public PrincipalHasTaggedDocumentPermissionsVo() {

	}

	public PrincipalHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public PrincipalHasTaggedDocumentPermissionsVo(String docUuid, Integer principalId, Date startDate, Date endDate) {
		this.docUuid = docUuid;
		this.principalId = principalId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public PrincipalHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Integer principalId, Date startDate,
			Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.principalId = principalId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocUuid() {
		return docUuid;
	}

	public void setDocUuid(String docUuid) {
		this.docUuid = docUuid;
	}

	public Integer getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Integer principalId) {
		this.principalId = principalId;
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
