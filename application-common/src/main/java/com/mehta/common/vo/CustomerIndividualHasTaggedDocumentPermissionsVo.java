package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class CustomerIndividualHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = -696571237840637206L;
	private Integer id;
	private String docUuid;
	private Integer customerIndividualId;
	private Date startDate;
	private Date endDate;

	public CustomerIndividualHasTaggedDocumentPermissionsVo() {

	}

	public CustomerIndividualHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public CustomerIndividualHasTaggedDocumentPermissionsVo(String docUuid, Integer customerIndividualId,
			Date startDate, Date endDate) {
		this.docUuid = docUuid;
		this.customerIndividualId = customerIndividualId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CustomerIndividualHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Integer customerIndividualId,
			Date startDate, Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.customerIndividualId = customerIndividualId;
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

	public Integer getCustomerIndividualId() {
		return customerIndividualId;
	}

	public void setCustomerIndividualId(Integer customerIndividualId) {
		this.customerIndividualId = customerIndividualId;
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
