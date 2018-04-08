package com.mehta.common.vo;

import java.io.Serializable;

public class PrincipalVo implements Serializable {
	private static final long serialVersionUID = -6079962450024296574L;
	private Integer id;
	private String name;
	private String legalName;
	private Integer addressGeoLocationId;
	private String storageFolderName;
		
	public PrincipalVo() {
		super();
	}

	public PrincipalVo(Integer id) {
		super();
		this.id = id;
	}

	public PrincipalVo(String name, String legalName, Integer addressGeoLocationId, String storageFolderName) {
		super();
		this.name = name;
		this.legalName = legalName;
		this.addressGeoLocationId = addressGeoLocationId;
		this.storageFolderName = storageFolderName;

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

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public Integer getAddressGeoLocationId() {
		return addressGeoLocationId;
	}

	public void setAddressGeoLocationId(Integer addressGeoLocationId) {
		this.addressGeoLocationId = addressGeoLocationId;
	}

	public String getStorageFolderName() {
		return storageFolderName;
	}

	public void setStorageFolderName(String storageFolderName) {
		this.storageFolderName = storageFolderName;
	}

}
