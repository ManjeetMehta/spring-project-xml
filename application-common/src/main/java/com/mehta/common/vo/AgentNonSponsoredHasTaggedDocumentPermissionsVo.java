package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class AgentNonSponsoredHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = -1538003446044953064L;
	private Integer id;
	private String docUuid;
	private Integer agentNonSponsoredId;
	private Date startDate;
	private Date endDate;

	public AgentNonSponsoredHasTaggedDocumentPermissionsVo() {

	}

	public AgentNonSponsoredHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public AgentNonSponsoredHasTaggedDocumentPermissionsVo(String docUuid, Integer agentNonSponsoredId, Date startDate,
			Date endDate) {
		this.docUuid = docUuid;
		this.agentNonSponsoredId = agentNonSponsoredId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AgentNonSponsoredHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Integer agentNonSponsoredId,
			Date startDate, Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.agentNonSponsoredId = agentNonSponsoredId;
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

	public Integer getAgentNonSponsoredId() {
		return agentNonSponsoredId;
	}

	public void setAgentNonSponsoredId(Integer agentNonSponsoredId) {
		this.agentNonSponsoredId = agentNonSponsoredId;
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
