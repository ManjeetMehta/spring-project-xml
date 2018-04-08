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

import com.mehta.common.vo.EmployeeVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.EmployeeService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;


@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody ResponseVo create(@RequestBody EmployeeVo currencyvo, Locale locale, Model model){
		int id= employeeService.create(currencyvo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	ResponseVo update(@RequestBody EmployeeVo currencyvo, Locale locale, Model model){
		employeeService.update(currencyvo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	ResponseVo read(@PathVariable int id, Locale locale, Model model){
		EmployeeVo currencyVo= employeeService.read(id);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(currencyVo).build();
	}

    @RequestMapping(value = Constants.OPERATION_DELETE, method = RequestMethod.GET)	
	public @ResponseBody
	ResponseVo delete(@PathVariable int id, Locale locale, Model model){
    	employeeService.delete(id);
    	return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
    }
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	ResponseVo list(Locale locale, Model model){
		List<EmployeeVo> currencyVos = employeeService.list();
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).list(currencyVos).build();
	}
}
