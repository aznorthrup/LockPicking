package com.brycenorthrup.lockpickingapp.controllers;

import java.util.List;

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
import com.brycenorthrup.lockpickingapp.exceptions.LockException;
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
		int count = 0;
		for (@SuppressWarnings("unused") Object i : allLocks) {
			count++;
		}
		if (count == 0) {
			List<ToolPick> picks = (List<ToolPick>) pickRepository.findAll();
			List<ToolTension> tensions = (List<ToolTension>) tensionRepository.findAll();
			List<ToolBypass> bypasses = (List<ToolBypass>) bypassRepository.findAll();
			logger.info("Added initial batch of locks.");
			LockClass lock1 = new LockClass("Abus","37RK-80","Boron-Alloy");
			lock1.setPick(picks.get(0));
			lock1.setTension(tensions.get(0));
			lock1.setBestBypass(bypasses.get(0));
			lock1.setImage("/img/lock/37RK-80.jpg");
			LockClass lock2 = new LockClass("Abus","37ST-55","Boron-Alloy");
			lock2.setPick(picks.get(0));
			lock2.setTension(tensions.get(0));
			lock2.setBestBypass(bypasses.get(0));
			lock2.setImage("/img/lock/37ST-55.jpg");
			LockClass lock3 = new LockClass("Ace","ace2","Steel");
			lock3.setPick(picks.get(0));
			lock3.setTension(tensions.get(0));
			lock3.setBestBypass(bypasses.get(0));
			lock3.setImage("/img/lock/ace2.jpg");
			LockClass lock4 = new LockClass("Ace","ST33L","Steel-Alloy");
			lock4.setPick(picks.get(0));
			lock4.setTension(tensions.get(0));
			lock4.setBestBypass(bypasses.get(0));
			lock4.setImage("/img/lock/ST33L.jpg");
			LockClass lock5 = new LockClass("American-Lock","A5261KA","Steel-Alloy");
			lock5.setPick(picks.get(0));
			lock5.setTension(tensions.get(0));
			lock5.setBestBypass(bypasses.get(0));
			lock5.setImage("/img/lock/A5261KA.jpg");
			LockClass lock6 = new LockClass("American-Lock","A5360","Steel-Alloy");
			lock6.setPick(picks.get(0));
			lock6.setTension(tensions.get(0));
			lock6.setBestBypass(bypasses.get(0));
			lock6.setImage("/img/lock/A5360.jpg");
			LockClass lock7 = new LockClass("Kwikset","Mechanical Deadbolt","Bronze-Alloy");
			lock7.setPick(picks.get(0));
			lock7.setTension(tensions.get(0));
			lock7.setBestBypass(bypasses.get(0));
			lock7.setImage("/img/lock/MechanicalDeadbolt.jpg");
			LockClass lock8 = new LockClass("Kwikset","KS23F2300C","Steel-Alloy");
			lock8.setPick(picks.get(0));
			lock8.setTension(tensions.get(0));
			lock8.setBestBypass(bypasses.get(0));
			lock8.setImage("/img/lock/KS23F2300C.jpg");
			LockClass lock9 = new LockClass("Master","130D","Steel");
			lock9.setPick(picks.get(0));
			lock9.setTension(tensions.get(0));
			lock9.setBestBypass(bypasses.get(0));
			lock9.setImage("/img/lock/130D.jpg");
			LockClass lock10 = new LockClass("Master","131T","Steel-Alloy");
			lock10.setPick(picks.get(0));
			lock10.setTension(tensions.get(0));
			lock10.setBestBypass(bypasses.get(0));
			lock10.setImage("/img/lock/131T.jpg");
			LockClass lock11 = new LockClass("ORIA","Locker","Aluminum");
			lock11.setPick(picks.get(0));
			lock11.setTension(tensions.get(0));
			lock11.setBestBypass(bypasses.get(0));
			lock11.setImage("/img/lock/oria-locker.jpg");
			LockClass lock12 = new LockClass("Schlage","Touch Screen Deadbolt","Bronze-Alloy");
			lock12.setPick(picks.get(0));
			lock12.setTension(tensions.get(0));
			lock12.setBestBypass(bypasses.get(0));
			lock12.setImage("/img/lock/SchlageTouchScreen.jpg");
			LockClass lock13 = new LockClass("Schlage","026SMT","Steel");
			lock13.setPick(picks.get(0));
			lock13.setTension(tensions.get(0));
			lock13.setBestBypass(bypasses.get(0));
			lock13.setImage("/img/lock/026SMT.jpg");
			LockClass lock14 = new LockClass("Stanley","CD8710","Steel");
			lock14.setPick(picks.get(0));
			lock14.setTension(tensions.get(0));
			lock14.setBestBypass(bypasses.get(0));
			lock14.setImage("/img/lock/CD8710.jpg");
			LockClass lock15 = new LockClass("Stanley","CD8821","Steel");
			lock15.setPick(picks.get(0));
			lock15.setTension(tensions.get(0));
			lock15.setBestBypass(bypasses.get(0));
			lock15.setImage("/img/lock/CD8821.jpg");
			lockRepository.save(lock1);
			lockRepository.save(lock2);
			lockRepository.save(lock3);
			lockRepository.save(lock4);
			lockRepository.save(lock5);
			lockRepository.save(lock6);
			lockRepository.save(lock7);
			lockRepository.save(lock8);
			lockRepository.save(lock9);
			lockRepository.save(lock10);
			lockRepository.save(lock11);
			lockRepository.save(lock12);
			lockRepository.save(lock13);
			lockRepository.save(lock14);
			lockRepository.save(lock15);
		}
		allLocks = lockRepository.findAll();
		logger.info("Displayed all locks.");
		model.addAttribute("locks", allLocks);
		model.addAttribute("lockCount", lockRepository.countLocks());
		return "allLocks.html";
	}

	@GetMapping(path = "/allLocks/{id}")
	public String getLockById(@PathVariable int id, Model model) throws LockException{
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new LockException("Invalid lock id: " + id));
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
	public String editLock(@PathVariable("id") int id, Model model) throws LockException{
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new LockException("Invalid lock id: " + id));
		logger.info("Displayed update page for lock with id: " + id);

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
	public String deleteLock(@PathVariable("id") int id, Model model) throws LockException{
		LockClass lock = lockRepository.findById(id)
				.orElseThrow(() -> new LockException("Invalid lock id: " + id));
		logger.info("Deleted lock with id: " + id);
		lockRepository.delete(lock);
		return "redirect:/allLocks";
	}
	
}