package com.mehta.dao;

import java.util.List;

import com.mehta.dao.framework.GenericDao;
import com.mehta.model.AgentSponsored;

public interface AgentSponsoredDao extends GenericDao< AgentSponsored, Integer> {

	List<AgentSponsored> findAll();	

}
