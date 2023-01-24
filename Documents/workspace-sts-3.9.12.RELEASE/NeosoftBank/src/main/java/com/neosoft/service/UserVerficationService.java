package com.neosoft.service;

import com.neosoft.model.Authentication;
import com.neosoft.model.UserVerification;

public interface UserVerficationService {
	String userVerification(UserVerification userVerifi);
	String otpVerify(Authentication authentication);
	//public boolean isOTPRequired();
}
