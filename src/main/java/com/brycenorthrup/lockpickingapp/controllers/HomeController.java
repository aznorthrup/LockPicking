package com.brycenorthrup.lockpickingapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class HomeController {
	@GetMapping(path="/")
	public String showHomePage(Model model) {
		return "home.html";
	}
}
