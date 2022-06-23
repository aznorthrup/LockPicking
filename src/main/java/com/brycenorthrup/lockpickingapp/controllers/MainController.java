package com.brycenorthrup.lockpickingapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@GetMapping(path = "/")
	public String showHomePage(Model model) {
		logger.info("Displayed home page");
		return "home.html";
	}

	@GetMapping(path = "/terminology")
	public String showTermsPage(Model model) {
		logger.info("Displayed terminology page");
		return "terms.html";
	}

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
