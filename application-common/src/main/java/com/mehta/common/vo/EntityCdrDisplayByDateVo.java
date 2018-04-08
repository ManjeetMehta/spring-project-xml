package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class EntityCdrDisplayByDateVo implements Serializable {
	private static final long serialVersionUID = 2911753748300680122L;
	private String cdruniqueid;
	private String callerName;
	private String callerNumber;
	private String extnNumber;
	private Integer duration;
	private String reasonForCall;
	private String remarks;
	private Integer inOutFlag;
	private String disposition;
	private String audioFileName;
	private String lastApp;
	private Date calldate;
	private Integer empId;
	private String empName;
	private Integer userId;
	private String entitytype;
	private String entityrelation;
	private String entityname;
	private String entitytaggedinstance;

	public EntityCdrDisplayByDateVo() {
		// TODO Auto-generated constructor stub
	}

	public EntityCdrDisplayByDateVo(String cdruniqueid, String callerName, String callerNumber, String extnNumber,
			Integer duration, String reasonForCall, String remarks, Integer inOutFlag, String disposition,
			String audioFileName, String lastApp, Date calldate, Integer empId, String empName, Integer userId,
			String entitytype, String entityrelation, String entityname, String entitytaggedinstance) {
		super();
		this.cdruniqueid = cdruniqueid;
		this.callerName = callerName;
		this.callerNumber = callerNumber;
		this.extnNumber = extnNumber;
		this.duration = duration;
		this.reasonForCall = reasonForCall;
		this.remarks = remarks;
		this.inOutFlag = inOutFlag;
		this.disposition = disposition;
		this.audioFileName = audioFileName;
		this.lastApp = lastApp;
		this.calldate = calldate;
		this.empId = empId;
		this.empName = empName;
		this.userId = userId;
		this.entitytype = entitytype;
		this.entityrelation = entityrelation;
		this.entityname = entityname;
		this.entitytaggedinstance = entitytaggedinstance;
	}

	public String getCdruniqueid() {
		return cdruniqueid;
	}

	public void setCdruniqueid(String cdruniqueid) {
		this.cdruniqueid = cdruniqueid;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getCallerNumber() {
		return callerNumber;
	}

	public void setCallerNumber(String callerNumber) {
		this.callerNumber = callerNumber;
	}

	public String getExtnNumber() {
		return extnNumber;
	}

	public void setExtnNumber(String extnNumber) {
		this.extnNumber = extnNumber;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getReasonForCall() {
		return reasonForCall;
	}

	public void setReasonForCall(String reasonForCall) {
		this.reasonForCall = reasonForCall;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getInOutFlag() {
		return inOutFlag;
	}

	public void setInOutFlag(Integer inOutFlag) {
		this.inOutFlag = inOutFlag;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getAudioFileName() {
		return audioFileName;
	}

	public void setAudioFileName(String audioFileName) {
		this.audioFileName = audioFileName;
	}

	public String getLastApp() {
		return lastApp;
	}

	public void setLastApp(String lastApp) {
		this.lastApp = lastApp;
	}

	public Date getCalldate() {
		return calldate;
	}

	public void setCalldate(Date calldate) {
		this.calldate = calldate;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public String getEntityrelation() {
		return entityrelation;
	}

	public void setEntityrelation(String entityrelation) {
		this.entityrelation = entityrelation;
	}

	public String getEntityname() {
		return entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public String getEntitytaggedinstance() {
		return entitytaggedinstance;
	}

	public void setEntitytaggedinstance(String entitytaggedinstance) {
		this.entitytaggedinstance = entitytaggedinstance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
