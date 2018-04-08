package com.mehta.web.controller.api;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.common.vo.PrincipalHasEmailVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.PrincipalHasEmailService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;

@RestController
@RequestMapping(value = "principal-has-email")
public class PrincipalHasEmailController {
	@Autowired
	private PrincipalHasEmailService principalHasEmailService;

	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody ResponseVo create(@RequestBody PrincipalHasEmailVo principalHasEmailVo, Locale locale,
			Model model) {
		int id = principalHasEmailService.create(principalHasEmailVo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
	}

	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody ResponseVo read(@PathVariable int id, Locale locale, Model model) {
		PrincipalHasEmailVo agentVo = principalHasEmailService.read(id);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(agentVo).build();
	}

	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody ResponseVo update(@RequestBody PrincipalHasEmailVo agentvo, Locale locale, Model model) {
		principalHasEmailService.update(agentvo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
	}

	@RequestMapping(value = Constants.OPERATION_DELETE, method = RequestMethod.POST)
	public @ResponseBody ResponseVo delete(@PathVariable int id, Locale locale, Model model) {
		principalHasEmailService.delete(id);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
	}

	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody ResponseVo listAgentUnionCustomerIndividual(Locale locale, Model model) {
		List<PrincipalHasEmailVo> entityVos = principalHasEmailService.list();
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(entityVos).build();
	}
}
