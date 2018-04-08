package com.mehta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "principal")
public class Principal implements Serializable {

	private static final long serialVersionUID = 5293850336554192517L;

	private Integer id;
	private String name;
	private String legalName;
	private Integer addressGeoLocationId;
	private String storageFolderName;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public Principal(Integer id) {
		super();
		this.id = id;
	}

	public Principal(String name, String legalName, Integer addressGeoLocationId, String storageFolderName,
			Date created, Long createdBy, Date lastModified, Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.name = name;
		this.legalName = legalName;
		this.addressGeoLocationId = addressGeoLocationId;
		this.storageFolderName = storageFolderName;
		this.created = created;
		this.createdBy = createdBy;
		this.lastModified = lastModified;
		this.lastModifiedBy = lastModifiedBy;
		this.createdByTaskId = createdByTaskId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "legal_name", length = 45, nullable = true)
	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	@Column(name = "address_geo_location_id", length = 11, nullable = true)
	public Integer getAddressGeoLocationId() {
		return addressGeoLocationId;
	}

	public void setAddressGeoLocationId(Integer addressGeoLocationId) {
		this.addressGeoLocationId = addressGeoLocationId;
	}

	@Column(name = "storage_folder_name", length = 45, nullable = false, unique = true)
	public String getStorageFolderName() {
		return storageFolderName;
	}

	public void setStorageFolderName(String storageFolderName) {
		this.storageFolderName = storageFolderName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "created_by", length = 20, nullable = false)
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified", nullable = false)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Column(name = "last_modified_by", length = 20, nullable = false)
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Column(name = "created_by_task_id", length = 20, nullable = true)
	public Long getCreatedByTaskId() {
		return createdByTaskId;
	}

	public void setCreatedByTaskId(Long createdByTaskId) {
		this.createdByTaskId = createdByTaskId;
	}
}