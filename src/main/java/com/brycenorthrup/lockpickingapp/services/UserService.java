package com.brycenorthrup.lockpickingapp.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.brycenorthrup.lockpickingapp.dto.UserRegistrationDto;
import com.brycenorthrup.lockpickingapp.entities.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
