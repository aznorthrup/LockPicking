package com.brycenorthrup.lockpickingapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

@Entity
public class LockClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lockId;
	@NotNull
	@Size(min = 2, message = "Must be more than one character.")
	private String brand;
	@NotNull
	@Size(min = 2, message = "Must be more than one character.")
	private String model;
	@NotNull
	@Size(min = 2, message = "Must be more than one character.")
	private String material;
	@OneToOne
	@Nullable
	private ToolPick pick;
	@OneToOne
	@Nullable
	private ToolTension tension;
	@OneToOne
	@Nullable
	private ToolBypass bestBypass;

	public LockClass() {
	}

	public LockClass(int lockId, String brand, String model, String material) {
		this.lockId = lockId;
		this.brand = brand;
		this.model = model;
		this.material = material;
	}

	public int getLockId() {
		return lockId;
	}

	public void setLockId(int lockId) {
		this.lockId = lockId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public ToolPick getPick() {
		return pick;
	}

	public void setPick(ToolPick pick) {
		this.pick = pick;
	}

	public ToolTension getTension() {
		return tension;
	}

	public void setTension(ToolTension tension) {
		this.tension = tension;
	}

	public ToolBypass getBestBypass() {
		return bestBypass;
	}

	public void setBestBypass(ToolBypass bestBypass) {
		this.bestBypass = bestBypass;
	}
	
	public String toShortString() {
		return brand + " " + model;
	}

	@Override
	public String toString() {
		if (this.pick != null && this.tension != null && this.bestBypass == null) {
			return "The " + brand + " " + model + " has a " + material + " shackle." + "It can be picked with a " + pick.getToolType() + " and a " + tension.getToolType() + ". It's best bypass method is not known... yet!";
		}
		if (this.pick == null || this.tension == null || this.bestBypass == null) {
			return "The " + brand + " " + model + " has a " + material + " shackle." + "And it still needs picking information!";
		}
		return "The " + brand + " " + model + " has a " + material + " shackle." + "It can be picked with a " + pick.getToolType() + " and a " + tension.getToolType() + ", and is best bypassed with a " + bestBypass.getToolType();
	}

}
