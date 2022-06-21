package com.brycenorthrup.lockpickingapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	@GetMapping("/login")
	public String login() {
		logger.info("Displayed login page");
		return "login.html";
	}

	@GetMapping("/error")
	public String error() {
		logger.info("Displayed error page");
		return "error.html";
	}

}
