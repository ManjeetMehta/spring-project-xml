package com.mehta.common.vo;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVo implements Serializable {
	private static final long serialVersionUID = -8866384597589508905L;
	private Integer id;
	private String firstName;
	private String storageFolderName;
	private String middleName;
	private String lastName;
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

	public EmployeeVo() {
		super();
	}

	public EmployeeVo(Integer id) {
		super();
		this.id = id;
	}

	public EmployeeVo(String firstName, String storageFolderName, String middleName, String lastName,
			String contactNumber, Integer addressGeoLocationId, Date dateOfBirth, String maritalStatus,
			Integer officeGeoLocationId, String nationality, String gender, String email, String passportNumber,
			String residentPermit, Short active, Integer userId) {
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

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStorageFolderName() {
		return storageFolderName;
	}

	public void setStorageFolderName(String storageFolderName) {
		this.storageFolderName = storageFolderName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getAddressGeoLocationId() {
		return addressGeoLocationId;
	}

	public void setAddressGeoLocationId(Integer addressGeoLocationId) {
		this.addressGeoLocationId = addressGeoLocationId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getOfficeGeoLocationId() {
		return officeGeoLocationId;
	}

	public void setOfficeGeoLocationId(Integer officeGeoLocationId) {
		this.officeGeoLocationId = officeGeoLocationId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getResidentPermit() {
		return residentPermit;
	}

	public void setResidentPermit(String residentPermit) {
		this.residentPermit = residentPermit;
	}

	public Short getActive() {
		return active;
	}

	public void setActive(Short active) {
		this.active = active;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
