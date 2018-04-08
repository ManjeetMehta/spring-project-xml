package com.mehta.common.vo;

import java.io.Serializable;

public class MessageHashTagVo implements Serializable {
	private static final long serialVersionUID = -78651791363633165L;
	private Integer id;
	private String tagName;
	private String category;
	private String subCategory;
	private String token;
	private String description;

	public MessageHashTagVo() {
		super();
	}

	public MessageHashTagVo(Integer id) {
		super();
		this.id = id;
	}

	public MessageHashTagVo(String tagName, String category, String subCategory, String token, String description) {
		super();
		this.tagName = tagName;
		this.category = category;
		this.subCategory = subCategory;
		this.token = token;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
