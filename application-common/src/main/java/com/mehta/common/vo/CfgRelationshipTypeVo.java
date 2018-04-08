package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class CfgRelationshipTypeVo implements Serializable {
	private static final long serialVersionUID = -2722786743091241653L;
	private Integer id;
	private String name;
	private String description;
	private String category;
	private String subCategory;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public CfgRelationshipTypeVo() {
		// TODO Auto-generated constructor stub
	}

	public CfgRelationshipTypeVo(Integer id) {
		super();
		this.id = id;
	}

	public CfgRelationshipTypeVo(String name, String description, String category, String subCategory, Date created,
			Long createdBy, Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.subCategory = subCategory;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
