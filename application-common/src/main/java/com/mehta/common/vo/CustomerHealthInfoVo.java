package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class CustomerHealthInfoVo implements Serializable {
	private static final long serialVersionUID = -6932266353806557750L;
	private Integer id;
	private Integer customerId;
	private Double heightCms;
	private Double weightKgs;
	private Boolean isSmoker;
	private Integer ailment;
	private Date effectiveStartDate;
	private Date effectiveEndDate;

	public CustomerHealthInfoVo() {
		super();
	}

	public CustomerHealthInfoVo(Integer id) {
		super();
		this.id = id;
	}

	public CustomerHealthInfoVo(Integer customerId, Double heightCms, Double weightKgs, Boolean isSmoker,
			Integer ailment, Date effectiveStartDate, Date effectiveEndDate) {
		super();
		this.customerId = customerId;
		this.heightCms = heightCms;
		this.weightKgs = weightKgs;
		this.isSmoker = isSmoker;
		this.ailment = ailment;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getHeightCms() {
		return heightCms;
	}

	public void setHeightCms(Double heightCms) {
		this.heightCms = heightCms;
	}

	public Double getWeightKgs() {
		return weightKgs;
	}

	public void setWeightKgs(Double weightKgs) {
		this.weightKgs = weightKgs;
	}

	public Boolean getIsSmoker() {
		return isSmoker;
	}

	public void setIsSmoker(Boolean isSmoker) {
		this.isSmoker = isSmoker;
	}

	public Integer getAilment() {
		return ailment;
	}

	public void setAilment(Integer ailment) {
		this.ailment = ailment;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

}
