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

import com.mehta.common.vo.AgentSponsoredHasTaggedDocumentPermissionsVo;
import com.mehta.service.AgentSponsoredHasTaggedDocumentPermissionsService;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

@RestController
@RequestMapping(value="agent-sponsored-has-tagged-document-permissions")
public class AgentSponsoredHasTaggedDocumentPermissionsController {
	
	@Autowired
	private AgentSponsoredHasTaggedDocumentPermissionsService agentSponsoredHasTaggedDocumentPermissionsService;
	
	@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		Integer id= agentSponsoredHasTaggedDocumentPermissionsService.create(agentSponsoredHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).id(id).build();
	}				
	
	@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> read(@PathVariable Integer id, Locale locale, Model model){
		AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsVo= agentSponsoredHasTaggedDocumentPermissionsService.read(id);
		return new ResponseBuilder().status(ResponseBuilder.Status.success).object(agentSponsoredHasTaggedDocumentPermissionsVo).build();
	}
			
	@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> update(@RequestBody AgentSponsoredHasTaggedDocumentPermissionsVo agentSponsoredHasTaggedDocumentPermissionsvo, Locale locale, Model model){
		agentSponsoredHasTaggedDocumentPermissionsService.update(agentSponsoredHasTaggedDocumentPermissionsvo,"10000");
		return new ResponseBuilder().status(ResponseBuilder.Status.success).build();
	}
	
	@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> list(Locale locale, Model model){
		List<AgentSponsoredHasTaggedDocumentPermissionsVo> agentSponsoredHasTaggedDocumentPermissionsVos = agentSponsoredHasTaggedDocumentPermissionsService.list();
		return new ResponseBuilder().status(ResponseBuilder.Status.success).list(agentSponsoredHasTaggedDocumentPermissionsVos).build();
	}
}
