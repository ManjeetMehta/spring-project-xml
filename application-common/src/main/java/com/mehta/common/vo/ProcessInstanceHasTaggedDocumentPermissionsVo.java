package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class ProcessInstanceHasTaggedDocumentPermissionsVo implements Serializable {
	private static final long serialVersionUID = -1134201449325386498L;
	private Integer id;
	private String docUuid;
	private Long processInstanceId;
	private Date startDate;
	private Date endDate;

	public ProcessInstanceHasTaggedDocumentPermissionsVo() {

	}

	public ProcessInstanceHasTaggedDocumentPermissionsVo(Integer id) {
		this.id = id;
	}

	public ProcessInstanceHasTaggedDocumentPermissionsVo(String docUuid, Long processInstanceId, Date startDate,
			Date endDate) {
		this.docUuid = docUuid;
		this.processInstanceId = processInstanceId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ProcessInstanceHasTaggedDocumentPermissionsVo(Integer id, String docUuid, Long processInstanceId,
			Date startDate, Date endDate) {
		this.id = id;
		this.docUuid = docUuid;
		this.processInstanceId = processInstanceId;
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

	public Long getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(Long processInstanceId) {
		this.processInstanceId = processInstanceId;
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
