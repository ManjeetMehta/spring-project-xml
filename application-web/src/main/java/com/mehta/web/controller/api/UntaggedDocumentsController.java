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

import com.mehta.common.vo.ResponseVo;
import com.mehta.common.vo.UntaggedDocumentsVo;
import com.mehta.service.UntaggedDocumentsService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;

	@RestController
	@RequestMapping(value="untagged-documents")
	public class UntaggedDocumentsController {
		@Autowired
		private UntaggedDocumentsService untaggedDocumentsService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo create(@RequestBody UntaggedDocumentsVo untaggedDocumentVo, Locale locale, Model model){
			Long id= untaggedDocumentsService.createUntaggedDocumentsService(untaggedDocumentVo,"101");
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).id(id).build();
		}
		
		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo read(@PathVariable Long id, Locale locale, Model model){
			UntaggedDocumentsVo untaggedDocumentsVo= untaggedDocumentsService.readUntaggedDocumentsService(id);
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(untaggedDocumentsVo).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody
		ResponseVo update(@RequestBody UntaggedDocumentsVo agentvo, Locale locale, Model model){
			untaggedDocumentsService.updateUntaggedDocumentsService(agentvo,"101");
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).build();
		}
		
	
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo listAgentUnionCustomerIndividual(Locale locale, Model model){
			List<UntaggedDocumentsVo> untaggedDocumentsVo = untaggedDocumentsService.listUntaggedDocumentsService();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(untaggedDocumentsVo).build();
		}
}
