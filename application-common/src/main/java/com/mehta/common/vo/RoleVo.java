package com.mehta.common.vo;

import java.io.Serializable;

public class RoleVo implements Serializable {
	private static final long serialVersionUID = -9188677781250844894L;
	private Integer id;
	private String name;

	public RoleVo() {
		super();
	}

	public RoleVo(Integer id) {
		super();
		this.id = id;
	}

	public RoleVo(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
