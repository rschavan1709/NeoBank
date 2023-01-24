package com.neosoft.service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Authentication;
import com.neosoft.model.Notifications;
import com.neosoft.model.User;
import com.neosoft.model.UserVerification;
import com.neosoft.repository.AdminRepository;
import com.neosoft.repository.AuthenticationRepository;
import com.neosoft.repository.NotificationsRepository;

import net.bytebuddy.asm.Advice.Local;

@Service
public class UserVerificationServiceImpl implements UserVerficationService{

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	Authentication authentication;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	AuthenticationRepository authenticationRepository;
	
	@Autowired
	Notifications notifications;
	
	@Autowired
	NotificationsRepository notificationsRepository;
	
	@Autowired
	List<Authentication> authentications;
	
	@Override
	public String userVerification(UserVerification userVerifi) {
		String username= userVerifi.getUsername();
		String otp1=null;
		User user = adminRepository.findByUsername(username);
	    Authentication authentication2=authenticationRepository.findByUsername(username);
		if(user != null) {
			if(userVerifi.getPassword().equals(user.getPassword()) && userVerifi.getMobileNo().equals(user.getMobileNo())) {
			
				if(authentication2 != null) {
				Date date2 = authentication2.getOtpRequestedTime();
				Date date3 = new Date(date2.getYear(),date2.getMonth(),date2.getDate(),date2.getHours(),date2.getMinutes(),date2.getSeconds()+30);
				Date date1=new Date();
				if(date1.before(date3)) {
					return "otp has already generated and time is not expire";
				}}
				 otp1= new DecimalFormat("000000").format(new Random().nextInt(999999));;
				
				 authentication.setMobileNo(userVerifi.getMobileNo());
				 authentication.setPassword(userVerifi.getPassword());
				 authentication.setUsername(username);
				 authentication.setOtp(otp1);
				 authentication.setOtpRequestedTime(new Date());
				 notifications.setTitle("Otp generated");
				 notifications.setBody("Your one time password is "+otp1+" you have to use it before 30 secs" );
				 notifications.setStatus("Your otp is generated");
				 authenticationService.add(authentication);
				// notificationsRepository.save(notifications);
			}
		}    
		return otp1;
	}

	@Override
	public String otpVerify(Authentication authentication) {
		String otpVerifi=null;
		Authentication authentication2=  authenticationRepository.findByUsername(authentication.getUsername());
		if(authentication2 != null) {
			Date date=new Date();
			authentication2.setOtpEnterdTimeDate(date);
			Date date1 = authentication2.getOtpRequestedTime();
			Date date2 = new Date(date1.getYear(),date1.getMonth(),date1.getDate(),date1.getHours(),date1.getMinutes(),date1.getSeconds()+30);
			if(authentication.getOtp().equals(authentication2.getOtp()) && authentication2.getOtpEnterdTimeDate().before(date2)) {
				otpVerifi="Otp verified successfully!!";
				authentication2.setOtpVerfiy(true);
				//User user=adminRepository.findByUsername(authentication.getUsername());
				authenticationRepository.save(authentication2);
			}
			else {
				return "otp time expires";
			}
		}
		return otpVerifi;
	}
	
	/*
	 * public boolean isOTPRequired() { if (authentication.getOtp()== null) { return
	 * false; }
	 * 
	 * long currentTimeInMillis = System.currentTimeMillis(); long
	 * otpRequestedTimeInMillis = authentication.getOtpRequestedTime().getTime();
	 * 
	 * if (otpRequestedTimeInMillis + Authentication.OTP_VALID_DURATION <
	 * currentTimeInMillis) { // OTP expires return false; }
	 * 
	 * return true; }
	 */
}
