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

import com.brycenorthrup.lockpickingapp.entities.LockClass;
import com.brycenorthrup.lockpickingapp.entities.ToolBypass;
import com.brycenorthrup.lockpickingapp.entities.ToolPick;
import com.brycenorthrup.lockpickingapp.entities.ToolTension;
import com.brycenorthrup.lockpickingapp.repositories.LockClassRepository;
import com.brycenorthrup.lockpickingapp.repositories.ToolBypassRepository;
import com.brycenorthrup.lockpickingapp.repositories.ToolPickRepository;
import com.brycenorthrup.lockpickingapp.repositories.ToolTensionRepository;

@Controller
public class LockClassController {
	@Autowired
	private LockClassRepository lockRepository;
	@Autowired
	private ToolPickRepository pickRepository;
	@Autowired
	private ToolTensionRepository tensionRepository;
	@Autowired
	private ToolBypassRepository bypassRepository;

	private Logger logger = LoggerFactory.getLogger(LoggerController.class);

	@GetMapping(path = "/allLocks")
	public String getAllLocks(Model model) {
		Iterable<LockClass> allLocks = lockRepository.findAll();
		logger.info("Displayed all locks.");
		model.addAttribute("locks", allLocks);
		return "allLocks.html";
	}

	@GetMapping(path = "/allLocks/{id}")
	public String getLockById(@PathVariable int id, Model model) {
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid lock id: " + id));
		logger.info("Displayed lock with id: " + id);
		model.addAttribute("lock", lock);
		return "lockPage.html";
	}

	@GetMapping(path = "/addLock")
	public String addLock(LockClass lock, Model model) {
		logger.info("Opened lock creation page.");
		model.addAttribute("pick", pickRepository.findAll());
		model.addAttribute("tension", tensionRepository.findAll());
		model.addAttribute("bestBypass", bypassRepository.findAll());

		return "addLockForm.html";
	}

	@PostMapping(path = "/addLock")
	public String checkLock(@Valid LockClass lock, BindingResult bind) {
		if (bind.hasErrors()) {
			logger.info("Failed to create new lock.");
			return "addLockForm.html";
		} else {
			lockRepository.save(lock);
			logger.info("Saved new lock " + lock.getBrand() + " " + lock.getModel() + " with a " + lock.getMaterial()
					+ " shackle.");
			return "redirect:/allLocks";
		}
	}

	@GetMapping("/updateLock/{id}")
	public String editLock(@PathVariable("id") int id, Model model) {
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid lock id: " + id));
		logger.info("Displayed update page for lock with id: " + id);
		if (pickRepository.findAll() == null) {
			ToolPick pick1 = new ToolPick("Short hook", "narrow");
			ToolPick pick2 = new ToolPick("Medium hook", "open");
			ToolPick pick3 = new ToolPick("Deep hook", "large");
			ToolPick pick4 = new ToolPick("Dimple pick", "dimpled or very thin");
			pickRepository.save(pick1);
			pickRepository.save(pick2);
			pickRepository.save(pick3);
			pickRepository.save(pick4);
		}

		if (tensionRepository.findAll() == null) {
			ToolTension tension1 = new ToolTension("Z-Bar", " bottom of the keyway ", "un-guarded and narrow");
			ToolTension tension3 = new ToolTension("Z-Bar TOK", "top of the keyway", "guarded and complex ");
			ToolTension tension2 = new ToolTension("Spring", "bottom of the keyway",
					"precisely aligned cylinders and narrow");
			ToolTension tension4 = new ToolTension("Mantis", "all tension forms", "cylindrical");
			tensionRepository.save(tension1);
			tensionRepository.save(tension2);
			tensionRepository.save(tension3);
			tensionRepository.save(tension4);
		}

		if (bypassRepository.findAll() == null) {
			ToolBypass bypass1 = new ToolBypass("Rake", "no security pins",
					"trying hundreds of pin combinations in seconds");
			ToolBypass bypass2 = new ToolBypass("Comb", "a loose fitting cylinder",
					"pushing all pins past the cylinder");
			ToolBypass bypass3 = new ToolBypass("Shim", "spring loaded shackle release", "pushing the spring back");
			ToolBypass bypass4 = new ToolBypass("Torch", "poor material composition",
					"melting the lock body or shackle");
			bypassRepository.save(bypass1);
			bypassRepository.save(bypass2);
			bypassRepository.save(bypass3);
			bypassRepository.save(bypass4);
		}

		model.addAttribute("pick", pickRepository.findAll());
		model.addAttribute("tension", tensionRepository.findAll());
		model.addAttribute("bestBypass", bypassRepository.findAll());
		model.addAttribute("lock", lock);
		return "updateLock.html";
	}

	@PostMapping("/updateLock/{id}")
	public String updateLock(@PathVariable int id, @Valid LockClass lock, BindingResult bind, Model model) {
		if (bind.hasErrors()) {
			lock.setLockId(id);
			logger.info("Failed to update lock.");
			return "updateLock.html";
		} else {
			lock.setLockId(id);
			lockRepository.save(lock);
			logger.info("Updated lock with id " + id);
			return "redirect:/allLocks/{id}";
		}
	}

	@GetMapping("/deleteLock/{id}")
	public String deleteLock(@PathVariable("id") int id, Model model) {
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid lock id: " + id));
		logger.info("Deleted lock with id: " + id);
		lockRepository.delete(lock);
		return "redirect:/allLocks";
	}
}