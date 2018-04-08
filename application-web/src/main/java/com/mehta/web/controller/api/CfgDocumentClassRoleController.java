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

import com.mehta.common.vo.CfgDocumentClassRoleVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.CfgDocumentClassRoleService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;

	@RestController
	@RequestMapping(value="cfg-document-class-role")
	public class CfgDocumentClassRoleController {
		@Autowired
		private CfgDocumentClassRoleService cfgDocumentClassRoleService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo create(@RequestBody CfgDocumentClassRoleVo cfgDocumentClassRoleVo, Locale locale, Model model){
			Integer id= cfgDocumentClassRoleService.create(cfgDocumentClassRoleVo);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
		}
		
		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo read(@PathVariable Integer id, Locale locale, Model model){
			CfgDocumentClassRoleVo cfgDocumentClassRoleVo=cfgDocumentClassRoleService.read(id);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(cfgDocumentClassRoleVo).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo update(@RequestBody CfgDocumentClassRoleVo cfgDocumentClassRoleVo, Locale locale, Model model){
			cfgDocumentClassRoleService.update(cfgDocumentClassRoleVo);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
		}
		
	
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo list(Locale locale, Model model){
			List<CfgDocumentClassRoleVo> cfgDocumentClassRoleVo = cfgDocumentClassRoleService.list();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(cfgDocumentClassRoleVo).build();
		}
}
