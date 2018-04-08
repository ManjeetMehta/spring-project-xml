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

import com.mehta.common.vo.SystemEmailBccVo;
import com.mehta.service.SystemEmailBccService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value = "system-email-bcc")
public class SystemEmailBccController {

	@Autowired
	SystemEmailBccService systemEmailBccService;

	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> create(@RequestBody SystemEmailBccVo systemEmailBccVo, Locale locale, Model model) {

		Integer id = systemEmailBccService.createSystemEmailBccService(systemEmailBccVo, "101");
		if (id == null)
			return new ResponseBuilder(false).status(ResponseBuilder.Status.error).id(id).build();
		return new ResponseBuilder(false).status(ResponseBuilder.Status.success).id(id).build();
	}

	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> update(@RequestBody SystemEmailBccVo systemEmailBccVo, Locale locale, Model model) {

		if (systemEmailBccVo.getId() != null) {
			systemEmailBccService.updateSystemEmailBccService(systemEmailBccVo, "202");
			return new ResponseBuilder(false).status(ResponseBuilder.Status.success).build();
		} else {
			return new ResponseBuilder(false).status(ResponseBuilder.Status.error).build();
		}
	}

	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> read(@RequestBody Map<String, Object> requestMap, Locale locale,
			Model model) {
		try {
			SystemEmailBccVo systemEmailBccVo = null;
			if (requestMap.get("id").toString() != null && !(requestMap.get("id").toString().trim().isEmpty())) {
				String id = (String) (requestMap.get("id").toString());

				Integer id1 = Integer.parseInt(id.trim());
				if (id1 > 0) {
					systemEmailBccVo = systemEmailBccService.readSystemEmailBccService(id1);
					return new ResponseBuilder(false).status(ResponseBuilder.Status.success).object(systemEmailBccVo).build();
				}
			}
			return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(systemEmailBccVo).build();
		} catch (Exception e) {
			return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(null).build();
		}
	}

	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> list(Locale locale, Model model) {
		List<SystemEmailBccVo> systemEmailBccVo = systemEmailBccService.listSystemEmailBccService();
		return new ResponseBuilder(false).status(ResponseBuilder.Status.success).object(systemEmailBccVo).build();
	}

}
