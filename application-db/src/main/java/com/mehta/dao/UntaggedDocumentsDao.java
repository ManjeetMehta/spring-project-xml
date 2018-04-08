
package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.UntaggedDocuments;

public interface UntaggedDocumentsDao extends GenericDao<UntaggedDocuments, Long> {
	List<UntaggedDocuments> findAll();
}
