package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.EmployeeUntaggedDocuments;

public interface EmployeeUntaggedDocumentsDao extends GenericDao<EmployeeUntaggedDocuments, Long> {
	List<EmployeeUntaggedDocuments> findAll();
}
