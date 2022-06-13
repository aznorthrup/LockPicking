package com.brycenorthrup.lockpickingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToolBypass{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int toolId;
	private String toolType;
	private String toolUse;
	private String lockVuln;
	private String videoLink;
	private int start;
	private String image;
	
	public ToolBypass(){}
	
	public ToolBypass(String toolType, String lockVuln, String toolUse) {
		this.toolType = toolType;
		this.toolUse = toolUse;
		this.lockVuln = lockVuln;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	public String getLockVuln() {
		return lockVuln;
	}

	public void setLockVuln(String lockVuln) {
		this.lockVuln = lockVuln;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolUse(String toolUse) {
		this.toolUse = toolUse;
	}

	public String getToolUse() {
		return this.toolUse;
	}
	
	public String toShortString() {
		return toolType;
	}

	@Override
	public String toString() {
		return "The " + toolType + " is used for locks with " + lockVuln + " and works by " + toolUse + ".";
	}

}
