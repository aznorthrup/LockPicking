package com.brycenorthrup.lockpickingapp.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brycenorthrup.lockpickingapp.entities.ToolPick;
import com.brycenorthrup.lockpickingapp.repositories.ToolPickRepository;

@Controller
public class ToolPickController {

	@Autowired
	ToolPickRepository pickRepository;

	private Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@GetMapping(path = "/allPick")
	public String getAllPick(Model model) {

		Iterable<ToolPick> pick = pickRepository.findAll();
		int count = 0;
		for (@SuppressWarnings("unused") Object i : pick) {
			count++;
		}
		if (count==0) {
			ToolPick pick1 = new ToolPick("Short hook", "narrow");
			ToolPick pick2 = new ToolPick("Medium hook", "open");
			ToolPick pick3 = new ToolPick("Deep hook", "large");
			ToolPick pick4 = new ToolPick("Dimple pick", "dimpled/smiley");
			pickRepository.save(pick4);
			pickRepository.save(pick3);
			pickRepository.save(pick2);
			pickRepository.save(pick1);
		}
		pick = pickRepository.findAll();
		logger.info("Displayed all pick tools");
		model.addAttribute("pick", pick);
		return "allPick.html";
	}

	@GetMapping(path = "/allPick/{id}")
	public String getPickById(@PathVariable int id, Model model) {
		ToolPick pick = pickRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid pick id: " + id));
		logger.info("Displayed picking tool with id: " + id);
		model.addAttribute("pick", pick);
		return "pickPage.html";
	}

	@GetMapping(path = "/addPick")
	public String addPick(ToolPick toolPick) {
		logger.info("Opened pick creation page");
		return "addPickForm.html";
	}

	@PostMapping(path = "/addPick")
	public String checkPick(@Valid ToolPick pick, BindingResult bind) {
		if (bind.hasErrors()) {
			logger.info("Failed to create new picking tool.");
			return "addPickForm.html";
		} else {
			pickRepository.save(pick);
			logger.info("Saved new picking tool " + pick.getToolType() + " with use " + pick.getToolUse() + ".");
			return "redirect:/allPick";
		}
	}

	@GetMapping("/updatePick/{id}")
	public String editPick(@PathVariable("id") int id, Model model) {
		ToolPick pick = pickRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid pick id: " + id));
		logger.info("Displayed update page for picking tool with id: " + id);
		model.addAttribute("pick", pick);
		return "updatePick.html";
	}

	@PostMapping("/updatePick/{id}")
	public String updatePick(@PathVariable("id") int id, @Valid ToolPick pick, BindingResult bind, Model model) {
		if (bind.hasErrors()) {
			pick.setToolId(id);
			logger.info("Failed to update picking tool.");
			return "updatePick.html";
		} else {
			pick.setToolId(id);
			pickRepository.save(pick);
			logger.info("Updated picking tool with id: " + id);
			return "redirect:/allPick/{id}";
		}
	}

	@GetMapping("/deletePick/{id}")
	public String deletePick(@PathVariable("id") int id, Model model) {
		ToolPick pick = pickRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid pick tool id: " + id));
		logger.info("Deleted pick tool with id: " + id);
		pickRepository.delete(pick);
		return "redirect:/allPick";
	}

}
