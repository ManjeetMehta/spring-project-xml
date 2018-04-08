package com.mehta.common.vo;

import java.io.Serializable;

public class CfgDocumentClassVo implements Serializable {
	private static final long serialVersionUID = -3693975983522207840L;
	private Integer id;

	public CfgDocumentClassVo() {
		super();
	}

	public CfgDocumentClassVo(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
