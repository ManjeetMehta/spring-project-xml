package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mehta.common.vo.CfgRelationshipTypeVo;
import com.mehta.dao.CfgRelationshipTypeDao;
import com.mehta.model.CfgRelationshipType;
import com.mehta.service.CfgRelationshipTypeService;

@Component
public class CfgRelationshipTypeServiceImpl implements CfgRelationshipTypeService {
	
	@Autowired
	private CfgRelationshipTypeDao cfgRelationshipTypeDao;
	
	@Override
	public Integer create(CfgRelationshipTypeVo cfgRelationshipTypeVo) {
		 String name=cfgRelationshipTypeVo.getName();
		 String description=cfgRelationshipTypeVo.getDescription();
		 String category=cfgRelationshipTypeVo.getCategory();
		 String subCategory=cfgRelationshipTypeVo.getSubCategory();
		 Date created=new Date();
		 Long createdBy=cfgRelationshipTypeVo.getCreatedBy(); 
		 Date lastModified=new Date();
		 Long lastModifiedBy=cfgRelationshipTypeVo.getLastModifiedBy();
		 Long createdByTaskId=cfgRelationshipTypeVo.getCreatedByTaskId();
		 
		 CfgRelationshipType cfgRelationshipType=new CfgRelationshipType(name, description, category, subCategory, created, createdBy, lastModified, lastModifiedBy, createdByTaskId);
		 
		 return cfgRelationshipTypeDao.create(cfgRelationshipType);
		 
		 
	}

	@Override
	public void update(CfgRelationshipTypeVo cfgRelationshipTypeVo) {
	
		 CfgRelationshipType cfgRelationshipType=cfgRelationshipTypeDao.read(cfgRelationshipTypeVo.getId());
		 if(cfgRelationshipType!=null){
			 
			 cfgRelationshipType.setName(cfgRelationshipTypeVo.getName());
			 cfgRelationshipType.setDescription(cfgRelationshipTypeVo.getDescription());
			 cfgRelationshipType.setCategory(cfgRelationshipTypeVo.getCategory());
			 cfgRelationshipType.setSubCategory(cfgRelationshipTypeVo.getSubCategory());
			 cfgRelationshipType.setCreated(new Date());
			 cfgRelationshipType.setCreatedBy(cfgRelationshipTypeVo.getCreatedBy());
			 cfgRelationshipType.setLastModified(new Date());
			 cfgRelationshipType.setLastModifiedBy(cfgRelationshipTypeVo.getLastModifiedBy());
			 cfgRelationshipType.setCreatedByTaskId(cfgRelationshipTypeVo.getCreatedByTaskId());
			 
			 cfgRelationshipTypeDao.update(cfgRelationshipType);
			 
		 }
		 else{
				throw new RuntimeException("Record not Found");		
			}
	}

	@Override
	public CfgRelationshipTypeVo read(Integer id) {
		 CfgRelationshipType cfgRelationshipType=cfgRelationshipTypeDao.read(id);
		 
		 if(cfgRelationshipType!=null){
			 CfgRelationshipTypeVo cfgRelationshipTypeVo=new CfgRelationshipTypeVo(id);
			 
			 cfgRelationshipTypeVo.setName(cfgRelationshipType.getName());
			 cfgRelationshipTypeVo.setDescription(cfgRelationshipType.getDescription());
			 cfgRelationshipTypeVo.setCategory(cfgRelationshipType.getCategory());
			 cfgRelationshipTypeVo.setSubCategory(cfgRelationshipType.getSubCategory());
			 cfgRelationshipTypeVo.setCreated(new Date());
			 cfgRelationshipTypeVo.setCreatedBy(cfgRelationshipType.getCreatedBy());
			 cfgRelationshipTypeVo.setLastModified(new Date());
			 cfgRelationshipTypeVo.setLastModifiedBy(cfgRelationshipType.getLastModifiedBy());
			 cfgRelationshipTypeVo.setCreatedByTaskId(cfgRelationshipType.getCreatedByTaskId());
			 
			 
			return cfgRelationshipTypeVo;
		 }else{
				throw new RuntimeException("Exception while reading record");
			}

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CfgRelationshipTypeVo> list() {
		
		 List<CfgRelationshipTypeVo> cfgRelationshipTypeVoList=null;
		 List<CfgRelationshipType> cfgRelationshipTypeList=cfgRelationshipTypeDao.findAll();
		 
		 if(cfgRelationshipTypeList!=null){
			 cfgRelationshipTypeVoList=new ArrayList<CfgRelationshipTypeVo>();

			 for(CfgRelationshipType cfgRelationshipType:cfgRelationshipTypeList){
				 
				 CfgRelationshipTypeVo cfgRelationshipTypeVo=new CfgRelationshipTypeVo(cfgRelationshipType.getId());
				 cfgRelationshipTypeVo.setName(cfgRelationshipType.getName());
				 cfgRelationshipTypeVo.setDescription(cfgRelationshipType.getDescription());
				 cfgRelationshipTypeVo.setCategory(cfgRelationshipType.getCategory());
				 cfgRelationshipTypeVo.setSubCategory(cfgRelationshipType.getSubCategory());
				 cfgRelationshipTypeVo.setCreated(new Date());
				 cfgRelationshipTypeVo.setCreatedBy(cfgRelationshipType.getCreatedBy());
				 cfgRelationshipTypeVo.setLastModified(new Date());
				 cfgRelationshipTypeVo.setLastModifiedBy(cfgRelationshipType.getLastModifiedBy());
				 cfgRelationshipTypeVo.setCreatedByTaskId(cfgRelationshipType.getCreatedByTaskId());
				 
				 cfgRelationshipTypeVoList.add(cfgRelationshipTypeVo);
				 
			 }
			 
		 }else{
			 cfgRelationshipTypeVoList=new ArrayList<CfgRelationshipTypeVo>(0);

		 }
		return cfgRelationshipTypeVoList;
		 
	}
	
}

