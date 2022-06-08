package com.brycenorthrup.lockpickingapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {
	@NotNull
	@Size(min=2, message="Must be more than one character")
	private String name;
	@NotNull
	@Size(min=2, message="Must be more than one character")
	private String email;
	@NotNull
	@Size(min=6, message="Must be more than five characters")
	private String password;
	
	public UserRegistrationDto() {}
	
	public UserRegistrationDto(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
