package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class CustomerCorporateHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = -3578037891633163408L;
	private Integer id;
	private String docUuid;
	private Integer customerCorporateId;
	private Date startDate;
	private Date endDate;

	public CustomerCorporateHasTaggedDocumentPermissionsVo() {

	}

	public CustomerCorporateHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public CustomerCorporateHasTaggedDocumentPermissionsVo(String docUuid, Integer customerCorporateId, Date startDate,
			Date endDate) {
		this.docUuid = docUuid;
		this.customerCorporateId = customerCorporateId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CustomerCorporateHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Integer customerCorporateId,
			Date startDate, Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.customerCorporateId = customerCorporateId;
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

	public Integer getCustomerCorporateId() {
		return customerCorporateId;
	}

	public void setCustomerCorporateId(Integer customerCorporateId) {
		this.customerCorporateId = customerCorporateId;
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
