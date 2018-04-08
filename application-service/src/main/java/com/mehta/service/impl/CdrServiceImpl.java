package com.mehta.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mehta.common.vo.EntityCdrDisplayByDateVo;
import com.mehta.dao.CdrDao;
import com.mehta.service.CdrService;

@Component
public class CdrServiceImpl implements CdrService {

	@Autowired
	private CdrDao cdrDao;

	@Override
	public List<EntityCdrDisplayByDateVo> entityCdrDisplay(String date) {

		ObjectMapper mapper = new ObjectMapper();

		List<EntityCdrDisplayByDateVo> entityCdrDisplayVoList = new ArrayList<EntityCdrDisplayByDateVo>();

		List<Object[]> compositeVoList = cdrDao.findAllByDate(date);

		GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Gson gson = builder.create();

		Map<String, List<EntityCdrDisplayByDateVo>> entityVoMap = null;
		List<EntityCdrDisplayByDateVo> tempVoList = null;
		try {
			List<Object> compositeentityCdrDisplayVoOutgoingObjectList = cdrDao.convertToObjectList(compositeVoList,
					new EntityCdrDisplayByDateVo(), null, null);
			entityCdrDisplayVoList = mapper.readValue(gson.toJson(compositeentityCdrDisplayVoOutgoingObjectList),
					new TypeReference<List<EntityCdrDisplayByDateVo>>() {
					});

			entityVoMap = new HashMap<String, List<EntityCdrDisplayByDateVo>>();

			for (EntityCdrDisplayByDateVo cdrEntityVo : entityCdrDisplayVoList) {

				if (!cdrEntityVo.getDisposition().trim().equalsIgnoreCase("ANSWERED"))
					cdrEntityVo.setDuration(0);

				if (cdrEntityVo.getDisposition().trim().equalsIgnoreCase("ANSWERED") && cdrEntityVo.getDuration() == 0)
					cdrEntityVo.setDisposition("NO ANSWER");

				tempVoList = null;
				if (entityVoMap.containsKey(cdrEntityVo.getCdruniqueid())) {
					tempVoList = entityVoMap.get(cdrEntityVo.getCdruniqueid());
					tempVoList.add(cdrEntityVo);
					entityVoMap.put(cdrEntityVo.getCdruniqueid(), tempVoList);
				} else {
					tempVoList = new ArrayList<EntityCdrDisplayByDateVo>();
					tempVoList.add(cdrEntityVo);
					entityVoMap.put(cdrEntityVo.getCdruniqueid(), tempVoList);
				}
			}

		} catch (Exception e) {
			new RuntimeException("Error in converting");
		}

		entityCdrDisplayVoList.clear();

		Set keys = entityVoMap.keySet();
		Iterator itr = keys.iterator();

		while (itr.hasNext()) {
			entityCdrDisplayVoList.addAll(entityVoMap.get(itr.next()));
		}
		return entityCdrDisplayVoList;

	}

}
