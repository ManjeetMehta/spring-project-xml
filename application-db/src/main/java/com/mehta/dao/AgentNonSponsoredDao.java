package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.AgentNonSponsored;

public interface AgentNonSponsoredDao extends GenericDao<AgentNonSponsored, Integer> {

	List<AgentNonSponsored> findAll();

}
