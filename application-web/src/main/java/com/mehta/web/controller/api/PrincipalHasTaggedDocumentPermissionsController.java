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

import com.mehta.common.vo.PrincipalHasTaggedDocumentPermissionsVo;
import com.mehta.service.PrincipalHasTaggedDocumentPermissionsService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value="principal-has-tagged-document-permissions")
public class PrincipalHasTaggedDocumentPermissionsController {
	
	@Autowired
	private PrincipalHasTaggedDocumentPermissionsService principalHasTaggedDocumentPermissionsService;
	
	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		Integer id= principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsCreate(principalHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
	}				
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> read(@PathVariable Integer id, Locale locale, Model model){
		PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsVo= principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsRead(id);
		return new ResponseBuilder().status(ResponseBuilder.Status.success).object(principalHasTaggedDocumentPermissionsVo).build();
	}
			
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestBody PrincipalHasTaggedDocumentPermissionsVo principalHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsUpdate(principalHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> list(Locale locale, Model model){
		List<PrincipalHasTaggedDocumentPermissionsVo> principalHasTaggedDocumentPermissionsVos = principalHasTaggedDocumentPermissionsService.principalHasTaggedDocumentPermissionsList();
		return new ResponseBuilder().status(ResponseBuilder.Status.success).list(principalHasTaggedDocumentPermissionsVos).build();
	}
}
