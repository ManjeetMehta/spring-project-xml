package com.mehta.service;

import java.util.List;

import com.mehta.common.vo.EntityCdrDisplayByDateVo;

public interface CdrService {

	List<EntityCdrDisplayByDateVo> entityCdrDisplay(String date);

}
