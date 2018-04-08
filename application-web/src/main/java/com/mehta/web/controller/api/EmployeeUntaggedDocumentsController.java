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

import com.mehta.common.vo.EmployeeUntaggedDocumentsVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.EmployeeUntaggedDocumentsService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;

	@RestController
	@RequestMapping(value="employee-untagged-documents")
	public class EmployeeUntaggedDocumentsController {
		@Autowired
		private EmployeeUntaggedDocumentsService employeeUntaggedDocumentsService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo create(@RequestBody EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo, Locale locale, Model model){
			Long id= employeeUntaggedDocumentsService.createEmployeeUntaggedDocumentsService(employeeUntaggedDocumentsVo, "101");
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
		}
		
		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo read(@PathVariable Long id, Locale locale, Model model){
			EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo= employeeUntaggedDocumentsService.readEmployeeUntaggedDocumentsService(id);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(employeeUntaggedDocumentsVo).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo update(@RequestBody EmployeeUntaggedDocumentsVo employeeUntaggedDocumentsVo, Locale locale, Model model){
			employeeUntaggedDocumentsService.updateEmployeeUntaggedDocumentsService(employeeUntaggedDocumentsVo, "202");
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
		}
		
	
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo list(Locale locale, Model model){
			List<EmployeeUntaggedDocumentsVo> employeeUntaggedDocumentsVo = employeeUntaggedDocumentsService.listEmployeeUntaggedDocumentsService();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(employeeUntaggedDocumentsVo).build();
		}
}
