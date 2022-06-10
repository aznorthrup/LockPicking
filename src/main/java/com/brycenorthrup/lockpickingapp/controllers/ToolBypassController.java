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

import com.brycenorthrup.lockpickingapp.entities.ToolBypass;
import com.brycenorthrup.lockpickingapp.repositories.ToolBypassRepository;

@Controller
public class ToolBypassController {

	@Autowired
	ToolBypassRepository bypassRepository;

	private Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@GetMapping(path = "/allBypass")
	public String getAllBypass(Model model) {
		Iterable<ToolBypass> bypass = bypassRepository.findAll();
		int count = 0;
		for (@SuppressWarnings("unused") Object i : bypass) {
			count++;
		}
		if (count==0) {
			ToolBypass bypass1 = new ToolBypass("Breaker Bar", "weak pin materials",
					"breaking the pins in half at the shear line");
			ToolBypass bypass2 = new ToolBypass("Bump Key", "generally similar keyways", "repeatedly pushing in and turning with slight force");
			ToolBypass bypass3 = new ToolBypass("Bypass Hook", "openings in the back of the keyway adjascent to the shackle lock",
					"twisting towards the bottom of the keyway, releasing the shackle lock");
			ToolBypass bypass4 = new ToolBypass("Bypass Knife", "unguarded shackle release",
					"pushing to the back of the keyway and pulling down towards the pins");
			ToolBypass bypass5 = new ToolBypass("Comb", "a loose fitting cylinder",
					"pushing all pins past the cylinder");
			ToolBypass bypass6 = new ToolBypass("Common Key", "the same exact key (CH751, C415A, etc.)", "just using the key, this is surprisingly common");
			ToolBypass bypass7 = new ToolBypass("Pick Gun", "no security pins",
					"violently striking the pins, much like a rake but slightly easier");
			ToolBypass bypass8 = new ToolBypass("Rake", "no security pins",
					"trying hundreds of pin combinations in seconds");
			ToolBypass bypass9 = new ToolBypass("Rocking", "simple or generic",
					"rocking back and forth to adjust pins en masse");
			ToolBypass bypass10 = new ToolBypass("Shim", "spring loaded shackle release", "pushing the spring back");
			ToolBypass bypass11 = new ToolBypass("Torch", "poor material composition",
					"melting the lock body or shackle");
			ToolBypass bypass12 = new ToolBypass("Warded Pick", "older warded locks",
					"using it like a normal key");
			bypassRepository.save(bypass1);
			bypassRepository.save(bypass2);
			bypassRepository.save(bypass3);
			bypassRepository.save(bypass4);
			bypassRepository.save(bypass5);
			bypassRepository.save(bypass6);
			bypassRepository.save(bypass7);
			bypassRepository.save(bypass8);
			bypassRepository.save(bypass9);
			bypassRepository.save(bypass10);
			bypassRepository.save(bypass11);
			bypassRepository.save(bypass12);
		}
		bypass = bypassRepository.findAll();
		logger.info("Displayed all bypass tools");
		model.addAttribute("bypass", bypass);
		return "allBypass.html";
	}

	@GetMapping(path = "/allBypass/{id}")
	public String getBypassById(@PathVariable int id, Model model) {
		ToolBypass bypass = bypassRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bypass id: " + id));
		logger.info("Displayed bypass tool with id: " + id);
		model.addAttribute("bypass", bypass);
		return "bypassPage.html";
	}

	@GetMapping(path = "/addBypass")
	public String addBypass(ToolBypass toolBypass) {
		logger.info("Opened bypass creation page");
		return "addBypassForm.html";
	}

	@PostMapping(path = "/addBypass")
	public String checkBypass(@Valid ToolBypass bypass, BindingResult bind) {
		if (bind.hasErrors()) {
			logger.info("Failed to create new bypass tool.");
			return "addBypassForm.html";
		} else {
			bypassRepository.save(bypass);
			logger.info("Saved new bypass tool " + bypass.getToolType() + " with use " + bypass.getToolUse()
					+ " and bypass type " + bypass.getLockVuln() + ".");
			return "redirect:/allBypass";
		}
	}

	@GetMapping("/updateBypass/{id}")
	public String editBypass(@PathVariable("id") int id, Model model) {
		ToolBypass bypass = bypassRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bypass id: " + id));
		logger.info("Displayed update page for bypass tool with id: " + id);
		model.addAttribute("bypass", bypass);
		return "updateBypass.html";
	}

	@PostMapping("/updateBypass/{id}")
	public String updateBypass(@PathVariable("id") int id, @Valid ToolBypass bypass, BindingResult bind, Model model) {
		if (bind.hasErrors()) {
			bypass.setToolId(id);
			logger.info("Failed to update bypass tool.");
			return "updateBypass.html";
		} else {
			bypass.setToolId(id);
			bypassRepository.save(bypass);
			logger.info("Updated bypass tool with id: " + id);
			return "redirect:/allBypass/{id}";
		}
	}

	@GetMapping("/deleteBypass/{id}")
	public String deleteBypass(@PathVariable("id") int id, Model model) {
		ToolBypass bypass = bypassRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bypass tool id: " + id));
		logger.info("Deleted bypass tool with id: " + id);
		bypassRepository.delete(bypass);
		return "redirect:/allBypass";
	}

}
