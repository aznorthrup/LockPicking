package com.brycenorthrup.lockpickingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToolPick{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int toolId;
	private String toolType;
	private String toolUse;
	private String image;
	
	public ToolPick() {}
	
	public ToolPick(String toolType, String toolUse) {
		this.toolType = toolType;
		this.toolUse = toolUse;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
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
		return "The " + toolType + " is used primarily for " + toolUse + " keyways.";
	}

}
