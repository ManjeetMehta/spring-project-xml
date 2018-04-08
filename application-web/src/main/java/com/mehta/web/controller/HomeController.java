package com.mehta.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {

	private static final Logger	logger	= LoggerFactory.getLogger(HomeController.class);

		/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		
		return "home";

	}

	@RequestMapping(value = "/open/403", method = RequestMethod.GET)
	public String notAllowed(Locale locale, Model model) {

		logger.info("Got 403!");

		return "error-not-authorized";
	}

	@RequestMapping(value = "/open/404", method = RequestMethod.GET)
	public String notFound(Locale locale, Model model) {

		logger.info("Got 404!");

		return "error-bad-request";
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> testJson(Locale locale, Model model) {

		Map<String, Object> map = new HashMap<>();
		map.put("response_code", 1);
		map.put("message", "value");

		return map;
	}

	

}
