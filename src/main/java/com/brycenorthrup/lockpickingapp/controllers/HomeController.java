package com.brycenorthrup.lockpickingapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	@GetMapping(path="/")
	public String showHomePage(Model model) {
		logger.info("Displayed home page");
		return "home.html";
	}
}
