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

import com.brycenorthrup.lockpickingapp.entities.ToolTension;
import com.brycenorthrup.lockpickingapp.repositories.ToolTensionRepository;

@Controller
public class ToolTensionController {

	@Autowired
	ToolTensionRepository tensionRepository;
	
	private Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	@GetMapping(path="/allTension")
	public String getAllTension(Model model) {
		Iterable<ToolTension> tension = tensionRepository.findAll();
		int count = 0;
		for (@SuppressWarnings("unused") Object i : tension) {
			count++;
		}
		if (count==0) {
			ToolTension tension1 = new ToolTension("Z-Bar", " bottom of the keyway ", "un-guarded and narrow");
			ToolTension tension3 = new ToolTension("Z-Bar TOK", "top of the keyway", "guarded and complex ");
			ToolTension tension2 = new ToolTension("Spring", "bottom of the keyway",
					"precisely aligned cylinders and narrow");
			ToolTension tension4 = new ToolTension("Mantis", "all tension forms", "cylindrical");
			tensionRepository.save(tension4);
			tensionRepository.save(tension3);
			tensionRepository.save(tension2);
			tensionRepository.save(tension1);
		}
		tension = tensionRepository.findAll();
		logger.info("Displayed all tension tools");
		model.addAttribute("tension", tension);
		return "allTension.html";
	}
	
	@GetMapping(path="/allTension/{id}")
	public String getTensionById(@PathVariable int id, Model model) {
		ToolTension tension = tensionRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid tension id: " + id));
		logger.info("Displayed tension tool with id: " + id);
		model.addAttribute("tension", tension);
		return "tensionPage.html";
	}
	
	@GetMapping(path="/addTension")
	public String addTension(ToolTension toolTension){
		logger.info("Opened tension creation page");
		return "addTensionForm.html";
	}

	@PostMapping(path="/addTension")
	public String checkTension(@Valid ToolTension tension, BindingResult bind) {
		if (bind.hasErrors()) {
			logger.info("Failed to create new tension tool.");
			return "addTensionForm.html";
		}else {
			tensionRepository.save(tension);
			logger.info("Saved new tension tool " + tension.getToolType() + " with use " + tension.getToolUse() + " and tension type " + tension.getTensionType() + ".");
			return "redirect:/allTension";
		}
	}
	
	@GetMapping("/updateTension/{id}")
	public String editTension(@PathVariable("id") int id, Model model) {
		ToolTension tension = tensionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid tension id: " + id));
		logger.info("Displayed update page for tension tool with id: " + id);
		model.addAttribute("tension", tension);
		return "updateTension.html";
	}
	
	@PostMapping("/updateTension/{id}")
	public String updateTension(@PathVariable("id") int id, @Valid ToolTension tension, BindingResult bind, Model model) {
		if (bind.hasErrors()) {
			tension.setToolId(id);
			logger.info("Failed to update tension tool.");
			return "updateTension.html";
		}else {
			tension.setToolId(id);
			tensionRepository.save(tension);
			logger.info("Updated tension tool with id: " + id);
			return "redirect:/allTension/{id}";
		}
	}

	@GetMapping("/deleteTension/{id}")
	public String deleteTension(@PathVariable("id") int id, Model model) {
		ToolTension tension = tensionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid tension tool id: " + id));
		logger.info("Deleted tension tool with id: " + id);
		tensionRepository.delete(tension);
		return "redirect:/allTension";
	}
	
}
