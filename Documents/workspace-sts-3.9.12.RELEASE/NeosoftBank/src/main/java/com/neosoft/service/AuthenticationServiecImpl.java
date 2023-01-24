package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Authentication;
import com.neosoft.model.User;
import com.neosoft.repository.AdminRepository;
import com.neosoft.repository.AuthenticationRepository;

@Service
public class AuthenticationServiecImpl implements AuthenticationService{

	@Autowired
	AuthenticationRepository authenticationRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Authentication add(Authentication authentication) {
		return authenticationRepository.save(authentication);
	}

}
