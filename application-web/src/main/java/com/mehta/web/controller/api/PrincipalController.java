package com.mehta.web.controller.api;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.common.vo.PrincipalVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.PrincipalService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;

	@RestController
	@RequestMapping(value="principal")
	public class PrincipalController {
		@Autowired
		private PrincipalService principalService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo create(@RequestBody PrincipalVo principalVo, Locale locale, Model model){
			int id= principalService.create(principalVo);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
		}
		
		@RequestMapping(value = Constants.OPERATION_CREATE_LIST, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo createList(@RequestBody Set<PrincipalVo> principalVoSet, Locale locale, Model model){
			Set<Integer> idSet= principalService.createList(principalVoSet);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(idSet).build();
		}
		
		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo read(@PathVariable int id, Locale locale, Model model){
			PrincipalVo agentVo= principalService.read(id);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(agentVo).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo update(@RequestBody PrincipalVo agentvo, Locale locale, Model model){
			principalService.update(agentvo);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
		}
		
	    @RequestMapping(value = Constants.OPERATION_DELETE, method = RequestMethod.POST)	
		public @ResponseBody
		ResponseVo delete(@PathVariable int id, Locale locale, Model model){
	    	principalService.delete(id);
	    	return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
	    }
		
		
		
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo list(Locale locale, Model model){
			List<PrincipalVo> entityVos = principalService.list();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(entityVos).build();
		}
}
