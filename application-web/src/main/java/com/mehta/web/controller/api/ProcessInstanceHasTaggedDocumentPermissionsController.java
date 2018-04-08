package com.mehta.web.controller.api;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.common.vo.ProcessInstanceHasTaggedDocumentPermissionsVo;
import com.mehta.service.ProcessInstanceHasTaggedDocumentPermissionsService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value="process-instance-has-tagged-document-permissions")
public class ProcessInstanceHasTaggedDocumentPermissionsController {
	
	@Autowired
	private ProcessInstanceHasTaggedDocumentPermissionsService processInstanceHasTaggedDocumentPermissionsService;
	
	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		Integer id= processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsCreate(processInstanceHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
	}				
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> read(@PathVariable Integer id, Locale locale, Model model){
		ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsVo= processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsRead(id);
		return new ResponseBuilder().status(ResponseBuilder.Status.success).object(processInstanceHasTaggedDocumentPermissionsVo).build();
	}
			
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestBody ProcessInstanceHasTaggedDocumentPermissionsVo processInstanceHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsUpdate(processInstanceHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> list(Locale locale, Model model){
		List<ProcessInstanceHasTaggedDocumentPermissionsVo> processInstanceHasTaggedDocumentPermissionsVos = processInstanceHasTaggedDocumentPermissionsService.processInstanceHasTaggedDocumentPermissionsList();
		return new ResponseBuilder().status(ResponseBuilder.Status.success).list(processInstanceHasTaggedDocumentPermissionsVos).build();
	}
}
