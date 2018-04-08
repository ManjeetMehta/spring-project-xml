
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.ProcessInstanceUntaggedDocuments;

public interface ProcessInstanceUntaggedDocumentsDao extends GenericDao<ProcessInstanceUntaggedDocuments, Long> {
	List<ProcessInstanceUntaggedDocuments> findAll();
}
