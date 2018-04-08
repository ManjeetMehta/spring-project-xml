package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.PrincipalVo;
import com.mehta.dao.PrincipalDao;
import com.mehta.model.Principal;
import com.mehta.service.PrincipalService;

@Component
public class PrincipalServiceImpl implements PrincipalService {

	@Autowired
	private PrincipalDao principalDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Integer create(PrincipalVo principalVo) {

		String name = principalVo.getName();
		String legalName = principalVo.getLegalName();
		Integer addressGeoLocationId = principalVo.getAddressGeoLocationId();
		String storageFolderName = principalVo.getStorageFolderName();
		Date created = new Date();
		Long createdBy = 1l;
		Date lastModified = new Date();
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		if (storageFolderName == null) {
			logger.warn("storageFolderName is not available... Record Not Created");
			return null;
		}

		Principal principal = new Principal(name, legalName, addressGeoLocationId, storageFolderName, created,
				createdBy, lastModified, lastModifiedBy, createdByTaskId);

		return principalDao.create(principal);

	}

	@Override
	public Set<Integer> createList(Set<PrincipalVo> principalVoSet) {
		Set<Principal> principalSet = new LinkedHashSet<Principal>();

		for (PrincipalVo principalVo : principalVoSet) {
			String name = principalVo.getName();
			String legalName = principalVo.getLegalName();
			Integer addressGeoLocationId = principalVo.getAddressGeoLocationId();
			String storageFolderName = principalVo.getStorageFolderName();
			Date created = new Date();
			Long createdBy = 1l;
			Date lastModified = new Date();
			Long lastModifiedBy = 1l;
			Long createdByTaskId = 1l;
			if (storageFolderName == null) {
				logger.warn("storageFolderName is not available... Record Not Created");
				return null;
			}
			Principal principal = new Principal(name, legalName, addressGeoLocationId, storageFolderName, created,
					createdBy, lastModified, lastModifiedBy, createdByTaskId);
			principalSet.add(principal);
		}

		return principalDao.createList(principalSet);

	}

	@Override
	public void update(PrincipalVo principalVo) {

		Principal principal = principalDao.read(principalVo.getId());

		if (principal != null) {

			if (principalVo.getName() != null)
				principal.setName(principalVo.getName());
			if (principalVo.getLegalName() != null)
				principal.setLegalName(principalVo.getLegalName());
			if (principalVo.getAddressGeoLocationId() != null)
				principal.setAddressGeoLocationId(principalVo.getAddressGeoLocationId());
			if (principalVo.getStorageFolderName() != null)
				principal.setStorageFolderName(principalVo.getStorageFolderName());

			principal.setLastModified(new Date());
			principal.setLastModifiedBy(2l);

			principalDao.update(principal);
		} else {
			logger.warn("Record not Found");
			return;
		}

	}

	@Override
	public void merge(PrincipalVo principalVo) {
		if (principalVo != null) {
			Principal principal = new Principal();
			if (principalVo.getId() == null)
				throw new HibernateException("Id must not be null...");

			principal.setId(principalVo.getId());
			if (principalVo.getName() != null)
				principal.setName(principalVo.getName());
			if (principalVo.getLegalName() != null)
				principal.setLegalName(principalVo.getLegalName());
			if (principalVo.getAddressGeoLocationId() != null)
				principal.setAddressGeoLocationId(principalVo.getAddressGeoLocationId());
			if (principalVo.getStorageFolderName() != null)
				principal.setStorageFolderName(principalVo.getStorageFolderName());

			principal.setLastModified(new Date());
			principal.setLastModifiedBy(2l);

			principalDao.merge(principal);
		} else {
			logger.warn("Record merger with new data....");
			return;
		}

	}

	@Override
	public void executeQuery(PrincipalVo principalVo) {
		if (principalVo != null) {
			Principal principal = new Principal();
			if (principalVo.getId() == null)
				throw new HibernateException("Id must not be null...");
			String sql = "update principal set id=" + principalVo.getId();
			principal.setId(principalVo.getId());
			if (principalVo.getName() != null)
				sql = sql + ", name='" + principalVo.getName() + "'";

			if (principalVo.getLegalName() != null)
				sql = sql + ", legal_name='" + principalVo.getLegalName() + "'";

			if (principalVo.getAddressGeoLocationId() != null)
				sql = sql + ", address_geo_location_id=" + principalVo.getAddressGeoLocationId();

			if (principalVo.getStorageFolderName() != null)
				sql = sql + ", storage_folder_name='" + principalVo.getStorageFolderName() + "'";
			sql = sql + ", last_modified_by=" + 2l;
			sql = sql + " where id=" + principalVo.getId();
			principalDao.executeQuery(sql);
		} else {
			logger.warn("Record updated with new data....");
			return;
		}
	}

	public void executeQueryMap(PrincipalVo principalVo) {
		Map<String, Object> queryMap = new HashMap<String, Object>();

		if (principalVo != null) {
			queryMap.put("tableName", "principal");
			if (principalVo.getId() == null) {
				logger.warn("Id must not be null...");
				return;
			}
			if (principalVo.getName() != null)
				queryMap.put("name", principalVo.getName());
			if (principalVo.getLegalName() != null)
				queryMap.put("legal_name", principalVo.getLegalName());
			if (principalVo.getAddressGeoLocationId() != null)
				queryMap.put("address_geo_location_id", principalVo.getAddressGeoLocationId());
			if (principalVo.getStorageFolderName() != null)
				queryMap.put("storage_folder_name", principalVo.getStorageFolderName());

			queryMap.put("last_modified_by", 1l);
			queryMap.put("id", principalVo.getId());
			principalDao.executeQueryMap(queryMap);
		} else {
			logger.warn("Record updated with new data....");
			return;
		}
	}

	@Override
	public PrincipalVo read(Integer id) {
		Principal principal = principalDao.read(id);

		if (principal != null) {
			PrincipalVo principalVo = new PrincipalVo(id);

			principalVo.setName(principal.getName());
			principalVo.setLegalName(principal.getLegalName());
			principalVo.setAddressGeoLocationId(principal.getAddressGeoLocationId());
			principalVo.setStorageFolderName(principal.getStorageFolderName());

			return principalVo;
		} else {
			logger.warn("Exception while reading record");
			return null;
		}

	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public List<PrincipalVo> list() {
		List<Principal> principalList = principalDao.findAll();

		List<PrincipalVo> principalVoList = null;

		if (principalList.size() > 0) {
			principalVoList = new ArrayList<PrincipalVo>();

			for (Principal principal : principalList) {

				PrincipalVo principalVo = new PrincipalVo(principal.getId());

				principalVo.setName(principal.getName());
				principalVo.setLegalName(principal.getLegalName());
				principalVo.setAddressGeoLocationId(principal.getAddressGeoLocationId());
				principalVo.setStorageFolderName(principal.getStorageFolderName());

				principalVoList.add(principalVo);

			}

		} else {
			principalVoList = new ArrayList<PrincipalVo>(0);
		}
		return principalVoList;
	}

}
