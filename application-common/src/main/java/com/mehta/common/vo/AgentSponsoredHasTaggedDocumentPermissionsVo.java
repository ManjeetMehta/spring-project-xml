package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class AgentSponsoredHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = -1538003446044953064L;
	private Integer id;
	private String docUuid;
	private Integer agentSponsoredId;
	private Date startDate;
	private Date endDate;

	public AgentSponsoredHasTaggedDocumentPermissionsVo() {

	}

	public AgentSponsoredHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public AgentSponsoredHasTaggedDocumentPermissionsVo(String docUuid, Integer agentSponsoredId, Date startDate,
			Date endDate) {
		this.docUuid = docUuid;
		this.agentSponsoredId = agentSponsoredId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AgentSponsoredHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Integer agentSponsoredId,
			Date startDate, Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.agentSponsoredId = agentSponsoredId;
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

	public Integer getAgentSponsoredId() {
		return agentSponsoredId;
	}

	public void setAgentSponsoredId(Integer agentSponsoredId) {
		this.agentSponsoredId = agentSponsoredId;
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
