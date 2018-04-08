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

import com.mehta.common.vo.MessageHashTagVo;
import com.mehta.common.vo.ResponseVo;
import com.mehta.service.MessageHashTagService;
import com.mehta.web.utils.ApiResponseBuilder;
import com.mehta.web.utils.Constants;
import com.mehta.web.utils.ResponseBuilder;

	@RestController
	@RequestMapping(value="message-hash-tag")
	public class MessageHashTagController {
		@Autowired
		private MessageHashTagService messageHashTagService;
		
		@RequestMapping(value = Constants.OPERATION_CREATE, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> create(@RequestBody MessageHashTagVo messageHashTagVo, Locale locale,
				Model model) {

			Integer id = messageHashTagService.createMessageHashTagService(messageHashTagVo,"101");
			if (id == null)
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).id(id).build();
			return new ResponseBuilder(false).status(ResponseBuilder.Status.success).id(id).build();
		}

		@RequestMapping(value = Constants.OPERATION_UPDATE, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> update(@RequestBody MessageHashTagVo messageHashTagVo, Locale locale,
				Model model) {

			if (messageHashTagVo.getId() != null) {
				messageHashTagService.updateMessageHashTagService(messageHashTagVo, "202");
				return new ResponseBuilder(false).status(ResponseBuilder.Status.success).build();
			} else {
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).build();
			}
		}

		@RequestMapping(value = Constants.OPERATION_READ, method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> read(@RequestBody Map<String, Object> requestMap, Locale locale,
				Model model) {
			try {
				MessageHashTagVo messageHashTagVo = null;
				if (requestMap.get("id").toString() != null && !(requestMap.get("id").toString().trim().isEmpty())) {
					String id = (String) (requestMap.get("id").toString());

					Integer id1 = Integer.parseInt(id.trim());
					if (id1 > 0) {
						messageHashTagVo = messageHashTagService.readMessageHashTagService(id1);
						return new ResponseBuilder(false).status(ResponseBuilder.Status.success).object(messageHashTagVo)
								.build();
					}
				}
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(messageHashTagVo).build();
			} catch (Exception e) {
				return new ResponseBuilder(false).status(ResponseBuilder.Status.error).object(null).build();
			}
		}
		
		@RequestMapping(value = Constants.OPERATION_LIST, method = RequestMethod.GET)
		public @ResponseBody
		ResponseVo list(Locale locale, Model model){
			List<MessageHashTagVo> messageHashTagVo = messageHashTagService.listMessageHashTagService();
			return new ApiResponseBuilder().status(ApiResponseBuilder.Status.success).object(messageHashTagVo).build();
		}
}
