package com.mehta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String storageFolderName;
	private String contactNumber;
	private Integer addressGeoLocationId;
	private Date dateOfBirth;
	private String maritalStatus;
	private Integer officeGeoLocationId;
	private String nationality;
	private String gender;
	private String email;
	private String passportNumber;
	private String residentPermit;
	private Short active;
	private Integer userId;
	private Date created;
	private Long createdBy;
	private Date lastModified;
	private Long lastModifiedBy;
	private Long createdByTaskId;

	public Employee() {
		super();
	}

	public Employee(Integer id) {
		super();
		this.id = id;
	}

	public Employee(String firstName, String storageFolderName, String middleName, String lastName,
			String contactNumber, Integer addressGeoLocationId, Date dateOfBirth, String maritalStatus,
			Integer officeGeoLocationId, String nationality, String gender, String email, String passportNumber,
			String residentPermit, Short active, Integer userId, Date created, Long createdBy, Date lastModified,
			Long lastModifiedBy, Long createdByTaskId) {
		super();
		this.firstName = firstName;
		this.storageFolderName = storageFolderName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.addressGeoLocationId = addressGeoLocationId;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.officeGeoLocationId = officeGeoLocationId;
		this.nationality = nationality;
		this.gender = gender;
		this.email = email;
		this.passportNumber = passportNumber;
		this.residentPermit = residentPermit;
		this.active = active;
		this.userId = userId;
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

	@Column(name = "first_name", length = 45, nullable = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name", length = 45, nullable = true)
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", length = 45, nullable = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "storage_folder_name", length = 45, nullable = false, unique = true)
	public String getStorageFolderName() {
		return storageFolderName;
	}

	public void setStorageFolderName(String storageFolderName) {
		this.storageFolderName = storageFolderName;
	}
	
	@Column(name = "contact_number", length = 45, nullable = true)
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "address_geo_location_id", length = 11, nullable = true)
	public Integer getAddressGeoLocationId() {
		return addressGeoLocationId;
	}

	public void setAddressGeoLocationId(Integer addressGeoLocationId) {
		this.addressGeoLocationId = addressGeoLocationId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_birth", nullable = true)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "marital_status", length = 10, nullable = true)
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "office_geo_location_id", length = 11, nullable = true)
	public Integer getOfficeGeoLocationId() {
		return officeGeoLocationId;
	}

	public void setOfficeGeoLocationId(Integer officeGeoLocationId) {
		this.officeGeoLocationId = officeGeoLocationId;
	}

	@Column(name = "nationality", length = 20, nullable = true)
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "gender", length = 6, nullable = true)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "email", length = 60, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "passport_number", length = 45, nullable = true)
	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(name = "resident_permit", length = 45, nullable = true)
	public String getResidentPermit() {
		return residentPermit;
	}

	public void setResidentPermit(String residentPermit) {
		this.residentPermit = residentPermit;
	}

	@Column(name = "active", length = 1, nullable = true)
	public Short getActive() {
		return active;
	}

	public void setActive(Short active) {
		this.active = active;
	}

	@Column(name = "user_id", length = 11, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
