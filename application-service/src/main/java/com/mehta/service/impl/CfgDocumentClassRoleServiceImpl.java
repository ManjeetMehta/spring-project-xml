package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.CfgDocumentClassRoleVo;
import com.mehta.dao.CfgDocumentClassDao;
import com.mehta.dao.CfgDocumentClassRoleDao;
import com.mehta.dao.RoleDao;
import com.mehta.model.CfgDocumentClass;
import com.mehta.model.CfgDocumentClassRole;
import com.mehta.model.Role;
import com.mehta.service.CfgDocumentClassRoleService;

@Component
public class CfgDocumentClassRoleServiceImpl implements CfgDocumentClassRoleService {

	@Autowired
	private CfgDocumentClassRoleDao cfgDocumentClassRoleDao;

	@Autowired
	private CfgDocumentClassDao cfgDocumentClassDao;

	@Autowired
	private RoleDao roleDao;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CfgDocumentClassRoleServiceImpl.class);

	@Override
	public Integer create(CfgDocumentClassRoleVo cfgDocumentClassRoleVo) {

		CfgDocumentClass cfgDocumentClass = null;
		if (cfgDocumentClassRoleVo.getCfgDocumentClassId() != null) {
			cfgDocumentClass = cfgDocumentClassDao.read(cfgDocumentClassRoleVo.getCfgDocumentClassId());
			if (cfgDocumentClass == null) {
				logger.warn("Parent Id of (cfgDocumentClass) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (cfgDocumentClass) is null.... (Record Not Created)");
			return null;
		}

		Role role = null;
		if (cfgDocumentClassRoleVo.getRoleId() != null) {
			role = roleDao.read(cfgDocumentClassRoleVo.getRoleId());
			if (role == null) {
				logger.warn("Parent Id of (role) is Not Matched.... (Record Not Created)");
				return null;
			}
		} else {
			logger.warn("Parent Id of (role) is null.... (Record Not Created)");
			return null;
		}

		Date created = new Date();
		Long createdBy = 1l;
		Long lastModifiedBy = 1l;
		Long createdByTaskId = 1l;

		CfgDocumentClassRole cfgDocumentClassRole = new CfgDocumentClassRole(cfgDocumentClass, role, created, createdBy,
				lastModifiedBy, createdByTaskId);

		cfgDocumentClassRole.setLastModified(new Date());

		return cfgDocumentClassRoleDao.create(cfgDocumentClassRole);
	}

	@Override
	public void update(CfgDocumentClassRoleVo cfgDocumentClassRoleVo) {

		CfgDocumentClassRole cfgDocumentClassRole = cfgDocumentClassRoleDao.read(cfgDocumentClassRoleVo.getId());

		if (cfgDocumentClassRole != null) {

			CfgDocumentClass cfgDocumentClass = null;
			if (cfgDocumentClassRoleVo.getCfgDocumentClassId() != null) {
				cfgDocumentClass = cfgDocumentClassDao.read(cfgDocumentClassRoleVo.getCfgDocumentClassId());
				if (cfgDocumentClass == null) {
					logger.warn("Parent Id of (cfgDocumentClass) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("Parent Id of (cfgDocumentClass) is null.... ");

			Role role = null;
			if (cfgDocumentClassRoleVo.getRoleId() != null) {
				role = roleDao.read(cfgDocumentClassRoleVo.getRoleId());
				if (role == null) {
					logger.warn("Parent Id of (role) is Not Matched.... (Record Not Created)");
					return;
				}
			} else
				logger.warn("Parent Id of (role) is null.... ");

			if (cfgDocumentClass != null)
				cfgDocumentClassRole.setCfgDocumentClass(cfgDocumentClass);
			if (role != null)
				cfgDocumentClassRole.setRole(role);

			cfgDocumentClassRole.setLastModified(new Date());
			cfgDocumentClassRole.setLastModifiedBy(2l);
			cfgDocumentClassRole.setCreatedByTaskId(2l);

			cfgDocumentClassRoleDao.update(cfgDocumentClassRole);
		} else {
			logger.warn("Record not Found for updatation...");
			return;
		}

	}

	@Override
	public CfgDocumentClassRoleVo read(Integer id) {
		CfgDocumentClassRole cfgDocumentClassRole = cfgDocumentClassRoleDao.read(id);

		if (cfgDocumentClassRole != null) {
			CfgDocumentClassRoleVo cfgDocumentClassRoleVo = new CfgDocumentClassRoleVo(cfgDocumentClassRole.getId());
			if (cfgDocumentClassRole.getCfgDocumentClass() != null)
				cfgDocumentClassRoleVo.setCfgDocumentClassId(cfgDocumentClassRole.getCfgDocumentClass().getId());
			if (cfgDocumentClassRole.getRole() != null)
				cfgDocumentClassRoleVo.setRoleId(cfgDocumentClassRole.getRole().getId());

			return cfgDocumentClassRoleVo;
		} else {
			logger.warn("Exception while reading record...");
			return null;
		}

	}

	@Override
	public List<CfgDocumentClassRoleVo> list() {
		List<CfgDocumentClassRole> cfgDocumentClassRoleList = cfgDocumentClassRoleDao.findAll();

		List<CfgDocumentClassRoleVo> cfgDocumentClassRoleVoList = null;

		if (cfgDocumentClassRoleList.size() > 0) {
			cfgDocumentClassRoleVoList = new ArrayList<CfgDocumentClassRoleVo>();

			for (CfgDocumentClassRole cfgDocumentClassRole : cfgDocumentClassRoleList) {
				CfgDocumentClassRoleVo cfgDocumentClassRoleVo = new CfgDocumentClassRoleVo(
						cfgDocumentClassRole.getId());
				if (cfgDocumentClassRole.getCfgDocumentClass() != null)
					cfgDocumentClassRoleVo.setCfgDocumentClassId(cfgDocumentClassRole.getCfgDocumentClass().getId());
				if (cfgDocumentClassRole.getRole() != null)
					cfgDocumentClassRoleVo.setRoleId(cfgDocumentClassRole.getRole().getId());

				cfgDocumentClassRoleVoList.add(cfgDocumentClassRoleVo);
			}

		} else {
			cfgDocumentClassRoleVoList = new ArrayList<CfgDocumentClassRoleVo>(0);

		}
		return cfgDocumentClassRoleVoList;
	}

}
