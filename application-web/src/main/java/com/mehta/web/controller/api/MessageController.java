package com.mehta.web.controller.api;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehta.common.vo.MessageVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.MessageService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

	@RestController
	@RequestMapping(value="message")
	public class MessageController {
		@Autowired
		private MessageService messageService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> create(@RequestBody MessageVo messageVo, Locale locale,
				Model model) {

			Integer id = messageService.createMessageService(messageVo,"101");
			if (id == null)
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).id(id).build();
			return new ResponseBuilder(false).status(ResponseBuilder.Status.success).id(id).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> update(@RequestBody MessageVo messageVo, Locale locale,
				Model model) {

			if (messageVo.getId() != null) {
				messageService.updateMessageService(messageVo, "202");
				return new ResponseBuilder(false).status(ResponseBuilder.Status.success).build();
			} else {
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).build();
			}
		}

		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> read(@RequestBody Map<String, Object> requestMap, Locale locale,
				Model model) {
			try {
				MessageVo messageVo = null;
				if (requestMap.get("id").toString() != null && !(requestMap.get("id").toString().trim().isEmpty())) {
					String id = (String) (requestMap.get("id").toString());

					Integer id1 = Integer.parseInt(id.trim());
					if (id1 > 0) {
						messageVo = messageService.readMessageService(id1);
						return new ResponseBuilder(false).status(ResponseBuilder.Status.success).object(messageVo)
								.build();
					}
				}
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(messageVo).build();
			} catch (Exception e) {
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(null).build();
			}
		}
		
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo list(Locale locale, Model model){
			List<MessageVo> messageVo = messageService.listMessageService();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(messageVo).build();
		}
}
