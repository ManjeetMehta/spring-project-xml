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

import com.mehta.common.vo.EmployeeHasEmailVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.EmployeeHasEmailService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;


@RestController
@RequestMapping(value="employee-has-email")
public class EmployeeHasEmailController {
	@Autowired
	private EmployeeHasEmailService employeeHasEmailService;

	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody ResponseVo create(@RequestBody EmployeeHasEmailVo employeeHasEmailvo, Locale locale, Model model){
		int id= employeeHasEmailService.create(employeeHasEmailvo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	ResponseVo update(@RequestBody EmployeeHasEmailVo employeeHasEmailVo, Locale locale, Model model){
		employeeHasEmailService.update(employeeHasEmailVo);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(employeeHasEmailVo.getId()).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	ResponseVo read(@PathVariable Integer id, Locale locale, Model model){
		EmployeeHasEmailVo employeeHasEmailVo= employeeHasEmailService.read(id);
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(employeeHasEmailVo).build();
	}

    @RequestMapping(value = Constants.OPERATION_DELETE, method = RequestMethod.GET)	
	public @ResponseBody
	ResponseVo delete(@PathVariable int id, Locale locale, Model model){
    	employeeHasEmailService.delete(id);
    	return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
    }
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	ResponseVo list(Locale locale, Model model){
		List<EmployeeHasEmailVo> employeeHasEmailVos = employeeHasEmailService.list();
		return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).list(employeeHasEmailVos).build();
	}
}
