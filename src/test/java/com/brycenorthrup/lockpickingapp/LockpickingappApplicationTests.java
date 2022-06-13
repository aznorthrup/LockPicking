package com.brycenorthrup.lockpickingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.brycenorthrup.lockpickingapp.entities.LockClass;
import com.brycenorthrup.lockpickingapp.entities.ToolBypass;
import com.brycenorthrup.lockpickingapp.entities.ToolPick;
import com.brycenorthrup.lockpickingapp.entities.ToolTension;

@SpringBootTest
class LockpickingappApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createPickTest() {
		ToolPick testPick= new ToolPick("TestPickType","TestPickUse");
		assertEquals("TestPickType", testPick.getToolType());
		assertEquals("TestPickUse", testPick.getToolUse());
	}
	
	@Test
	void createTensionTest() {
		ToolTension testTension = new ToolTension("TestTensionToolType","TestTensionTensionType","TestTensionUse");
		assertEquals("TestTensionToolType", testTension.getToolType());
		assertEquals("TestTensionTensionType", testTension.getTensionType());
		assertEquals("TestTensionUse", testTension.getToolUse());
	}
	
	@Test
	void createBypassTest() {
		ToolBypass testBypass = new ToolBypass("TestBypassType","TestBypassLockVuln","TestBypassUse");
		assertEquals("TestBypassType", testBypass.getToolType());
		assertEquals("TestBypassLockVuln", testBypass.getLockVuln());
		assertEquals("TestBypassUse", testBypass.getToolUse());
	}
	
	@Test
	void createLockTest() {
		ToolPick testPick= new ToolPick("TestPickType","TestPickUse");
		ToolTension testTension = new ToolTension("TestTensionType","TestTensionTensionType","TestTensionUse");
		ToolBypass testBypass = new ToolBypass("TestBypassType","TestBypassLockVuln","TestBypassUse");
		LockClass lock = new LockClass("TestBrand","TestModel","TestMaterial");
		lock.setPick(testPick);
		lock.setTension(testTension);
		lock.setBestBypass(testBypass);
		assertEquals("TestBrand",lock.getBrand());
		assertEquals("TestModel",lock.getModel());
		assertEquals("TestMaterial",lock.getMaterial());
		assertEquals(testPick.getToolId(),lock.getPick().getToolId());
		assertEquals(testTension.getToolId(),lock.getTension().getToolId());
		assertEquals(testBypass.getToolId(),lock.getBestBypass().getToolId());
	}

}
