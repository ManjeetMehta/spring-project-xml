package com.mehta.common.vo;

import java.io.Serializable;

public class SystemEmailBccVo implements Serializable {
	private static final long serialVersionUID = -6079962450024296574L;

	private Integer id;
	private Integer systemEmailId;
	private String emailAddress;

	public SystemEmailBccVo() {
		super();
	}

	public SystemEmailBccVo(Integer id) {
		super();
		this.id = id;
	}

	public SystemEmailBccVo(Integer systemEmailId, String emailAddress) {
		super();
		this.systemEmailId = systemEmailId;
		this.emailAddress = emailAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSystemEmailId() {
		return systemEmailId;
	}

	public void setSystemEmailId(Integer systemEmailId) {
		this.systemEmailId = systemEmailId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
