package com.brycenorthrup.lockpickingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToolTension{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int toolId;
	private String toolType;
	private String tensionType;
	private String toolUse;
	
	public ToolTension() {}
	
	public ToolTension(String toolType, String tensionType, String toolUse) {
		this.toolType = toolType;
		this.tensionType = tensionType;
		this.toolUse = toolUse;
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

	public String getTensionType() {
		return tensionType;
	}

	public void setTensionType(String tensionType) {
		this.tensionType = tensionType;
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
		return "The " + toolType + " provides " + tensionType + " for locks with " + toolUse + " keyways.";
	}
	
}
