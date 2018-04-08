package com.mehta.common.vo;

import java.io.Serializable;

public class CfgDocumentClassRoleVo implements Serializable {
	private static final long serialVersionUID = 2250033030651801087L;
	private Integer id;
	private Integer cfgDocumentClassId;
	private Integer roleId;

	public CfgDocumentClassRoleVo() {
		// TODO Auto-generated constructor stub
	}

	public CfgDocumentClassRoleVo(Integer id) {
		super();
		this.id = id;
	}

	public CfgDocumentClassRoleVo(Integer cfgDocumentClassId, Integer roleId) {
		super();
		this.cfgDocumentClassId = cfgDocumentClassId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCfgDocumentClassId() {
		return cfgDocumentClassId;
	}

	public void setCfgDocumentClassId(Integer cfgDocumentClassId) {
		this.cfgDocumentClassId = cfgDocumentClassId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
