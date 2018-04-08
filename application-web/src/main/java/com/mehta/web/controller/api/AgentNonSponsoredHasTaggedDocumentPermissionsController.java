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

import com.mehta.common.vo.AgentNonSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.service.AgentNonSponsoredHasTaggedDocumentPermissionsService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value="agent-non-sponsored-has-tagged-document-permissions")
public class AgentNonSponsoredHasTaggedDocumentPermissionsController {
	
	@Autowired
	private AgentNonSponsoredHasTaggedDocumentPermissionsService agentNonSponsoredHasTaggedDocumentPermissionsService;
	
	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		Integer id= agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsCreate(agentNonSponsoredHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
	}				
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> read(@PathVariable Integer id, Locale locale, Model model){
		AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsVo= agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsRead(id);
		return new ResponseBuilder().status(ResponseBuilder.Status.success).object(agentNonSponsoredHasTaggedDocumentPermissionsVo).build();
	}
			
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestBody AgentNonSponsoredHasTaggedDocumentPermissionsVo agentNonSponsoredHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsUpdate(agentNonSponsoredHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> list(Locale locale, Model model){
		List<AgentNonSponsoredHasTaggedDocumentPermissionsVo> agentNonSponsoredHasTaggedDocumentPermissionsVos = agentNonSponsoredHasTaggedDocumentPermissionsService.agentNonSponsoredHasTaggedDocumentPermissionsList();
		return new ResponseBuilder().status(ResponseBuilder.Status.success).list(agentNonSponsoredHasTaggedDocumentPermissionsVos).build();
	}
}
