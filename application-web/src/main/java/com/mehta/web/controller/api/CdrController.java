package com.mehta.web.controller.api;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.common.vo.EntityCdrDisplayByDateVo;
import com.mehta.service.CdrService;
import com.mehta.web.utils.ResponseBuilder;



@RestController
@RequestMapping(value="cdrController")
public class CdrController {
	
	@Autowired
	private CdrService cdrService;
	

	@RequestMapping(value = "call-dashboard", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> read(@RequestBody Map<String, Object> requestMap, Locale locale, Model model) {
		try {
			
				String date = (String) requestMap.get("date");
				List<EntityCdrDisplayByDateVo> objArray = cdrService.entityCdrDisplay(date);
				return new ResponseBuilder(false).status(ResponseBuilder.Status.success).object(objArray ).build();
			
		} catch (Exception e) {
			System.out.println("exception "+ e);
			return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(null).build();
		}
	}

}
