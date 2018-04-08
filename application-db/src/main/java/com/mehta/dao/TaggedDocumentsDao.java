package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.TaggedDocuments;

public interface TaggedDocumentsDao extends GenericDao<TaggedDocuments, String> {
	public List<TaggedDocuments> findAll();

}
