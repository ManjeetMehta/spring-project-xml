package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.EmployeeVo;
import com.mehta.dao.EmployeeDao;
import com.mehta.model.Employee;
import com.mehta.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Integer create(EmployeeVo employeeVo) {

		String firstName = employeeVo.getFirstName();
		String storageFolderName = employeeVo.getStorageFolderName();
		String middleName = employeeVo.getMiddleName();
		String lastName = employeeVo.getLastName();
		String contactNumber = employeeVo.getContactNumber();
		Integer addressGeoLocationId = employeeVo.getAddressGeoLocationId();
		Date dateOfBirth = employeeVo.getDateOfBirth();
		String maritalStatus = employeeVo.getMaritalStatus();
		Integer officeGeoLocationId = employeeVo.getOfficeGeoLocationId();
		String nationality = employeeVo.getNationality();
		String gender = employeeVo.getGender();
		String email = employeeVo.getEmail();
		String passportNumber = employeeVo.getPassportNumber();
		String residentPermit = employeeVo.getResidentPermit();
		Short active = employeeVo.getActive();
		Integer userId = employeeVo.getUserId();
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		if (storageFolderName == null) {
			logger.warn("storageFolderName is not available.... Record not Created");
			return null;
		}

		if (userId == null) {
			logger.warn("userId is not available... Record not Created");
			return null;
		}

		Employee employee = new Employee(firstName, storageFolderName, middleName, lastName, contactNumber,
				addressGeoLocationId, dateOfBirth, maritalStatus, officeGeoLocationId, nationality, gender, email,
				passportNumber, residentPermit, active, userId, created, createdBy, lastModified, lastModifiedBy,
				createdByTaskId);

		return employeeDao.create(employee);
	}

	@Override
	public void update(EmployeeVo employeeVo) {
		Employee employee = employeeDao.read(employeeVo.getId());

		if (employee != null) {

			if (employeeVo.getFirstName() != null)
				employee.setFirstName(employeeVo.getFirstName());
			if (employeeVo.getStorageFolderName() != null)
				employee.setStorageFolderName(employeeVo.getStorageFolderName());
			if (employeeVo.getMiddleName() != null)
				employee.setMiddleName(employeeVo.getMiddleName());
			if (employeeVo.getLastName() != null)
				employee.setLastName(employeeVo.getLastName());
			if (employeeVo.getContactNumber() != null)
				employee.setContactNumber(employeeVo.getContactNumber());
			if (employeeVo.getOfficeGeoLocationId() != null)
				employee.setOfficeGeoLocationId(employeeVo.getOfficeGeoLocationId());
			if (employeeVo.getDateOfBirth() != null)
				employee.setDateOfBirth(employeeVo.getDateOfBirth());
			if (employeeVo.getMaritalStatus() != null)
				employee.setMaritalStatus(employeeVo.getMaritalStatus());
			if (employeeVo.getOfficeGeoLocationId() != null)
				employee.setOfficeGeoLocationId(employeeVo.getOfficeGeoLocationId());
			if (employeeVo.getNationality() != null)
				employee.setNationality(employeeVo.getNationality());
			if (employeeVo.getGender() != null)
				employee.setGender(employeeVo.getGender());
			if (employeeVo.getEmail() != null)
				employee.setEmail(employeeVo.getEmail());
			if (employeeVo.getPassportNumber() != null)
				employee.setPassportNumber(employeeVo.getPassportNumber());
			if (employeeVo.getResidentPermit() != null)
				employee.setResidentPermit(employeeVo.getResidentPermit());
			if (employeeVo.getActive() != null)
				employee.setActive(employeeVo.getActive());
			if (employeeVo.getUserId() != null)
				employee.setUserId(employeeVo.getUserId());

			employee.setLastModified(new Date());
			employee.setLastModifiedBy(2l);

			employeeDao.update(employee);

		} else {
			logger.warn("Record not Found");
			return;
		}

	}

	@Override
	public EmployeeVo read(Integer id) {
		Employee employee = employeeDao.read(id);
		EmployeeVo employeeVo = null;
		if (employee != null) {
			employeeVo = new EmployeeVo(id);

			employeeVo.setFirstName(employee.getFirstName());
			employeeVo.setStorageFolderName(employee.getStorageFolderName());
			employeeVo.setMiddleName(employee.getMiddleName());
			employeeVo.setLastName(employee.getLastName());
			employeeVo.setContactNumber(employee.getContactNumber());
			employeeVo.setOfficeGeoLocationId(employee.getOfficeGeoLocationId());
			employeeVo.setDateOfBirth(employee.getDateOfBirth());
			employeeVo.setMaritalStatus(employee.getMaritalStatus());
			employeeVo.setOfficeGeoLocationId(employee.getOfficeGeoLocationId());
			employeeVo.setNationality(employee.getNationality());
			employeeVo.setGender(employee.getGender());
			employeeVo.setEmail(employee.getEmail());
			employeeVo.setPassportNumber(employee.getPassportNumber());
			employeeVo.setResidentPermit(employee.getResidentPermit());
			employeeVo.setActive(employee.getActive());
			employeeVo.setUserId(employee.getUserId());
		} else {
			logger.warn("Exception while reading record");
			return null;
		}

		return employeeVo;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeVo> list() {
		List<Employee> employeeList = employeeDao.findAll();

		List<EmployeeVo> employeeVoList = null;

		if (employeeList.size() > 0) {
			employeeVoList = new ArrayList<EmployeeVo>();

			for (Employee employee : employeeList) {

				EmployeeVo employeeVo = new EmployeeVo(employee.getId());

				employeeVo.setFirstName(employee.getFirstName());
				employeeVo.setStorageFolderName(employee.getStorageFolderName());
				employeeVo.setMiddleName(employee.getMiddleName());
				employeeVo.setLastName(employee.getLastName());
				employeeVo.setContactNumber(employee.getContactNumber());
				employeeVo.setOfficeGeoLocationId(employee.getOfficeGeoLocationId());
				employeeVo.setDateOfBirth(employee.getDateOfBirth());
				employeeVo.setMaritalStatus(employee.getMaritalStatus());
				employeeVo.setOfficeGeoLocationId(employee.getOfficeGeoLocationId());
				employeeVo.setNationality(employee.getNationality());
				employeeVo.setGender(employee.getGender());
				employeeVo.setEmail(employee.getEmail());
				employeeVo.setPassportNumber(employee.getPassportNumber());
				employeeVo.setResidentPermit(employee.getResidentPermit());
				employeeVo.setActive(employee.getActive());
				employeeVo.setUserId(employee.getUserId());

				employeeVoList.add(employeeVo);

			}

		} else {
			employeeVoList = new ArrayList<EmployeeVo>(0);

		}
		return employeeVoList;
	}

}
