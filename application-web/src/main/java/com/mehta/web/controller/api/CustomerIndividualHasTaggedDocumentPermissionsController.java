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

import com.mehta.common.vo.CustomerIndividualHasTaggedDocumentPermissionsVo;
import com.mehta.service.CustomerIndividualHasTaggedDocumentPermissionsService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value="customer-individual-has-tagged-document-permissions")
public class CustomerIndividualHasTaggedDocumentPermissionsController {
	
	@Autowired
	private CustomerIndividualHasTaggedDocumentPermissionsService customerIndividualHasTaggedDocumentPermissionsService;
	
	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		Integer id= customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsCreate(customerIndividualHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
	}				
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> read(@PathVariable Integer id, Locale locale, Model model){
		CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsVo= customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsRead(id);
		return new ResponseBuilder().status(ResponseBuilder.Status.success).object(customerIndividualHasTaggedDocumentPermissionsVo).build();
	}
			
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestBody CustomerIndividualHasTaggedDocumentPermissionsVo customerIndividualHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsUpdate(customerIndividualHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> list(Locale locale, Model model){
		List<CustomerIndividualHasTaggedDocumentPermissionsVo> customerIndividualHasTaggedDocumentPermissionsVos = customerIndividualHasTaggedDocumentPermissionsService.customerIndividualHasTaggedDocumentPermissionsList();
		return new ResponseBuilder().status(ResponseBuilder.Status.success).list(customerIndividualHasTaggedDocumentPermissionsVos).build();
	}
}
