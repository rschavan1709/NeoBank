package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Authentication;
import com.neosoft.model.UserVerification;
import com.neosoft.service.AuthenticationService;
import com.neosoft.service.UserVerficationService;

@RestController
public class UserVerificationController {
	
	@Autowired
	UserVerficationService userVerficationService;
	
	@PostMapping("/verifyUser")
	public String userVerification(@RequestBody  UserVerification userVerifi) {
		return userVerficationService.userVerification(userVerifi);
	}
	
	@PostMapping("/otpverify")
	public String otpVerfication(@RequestBody Authentication authentication) {
		return userVerficationService.otpVerify(authentication);
	}
}
