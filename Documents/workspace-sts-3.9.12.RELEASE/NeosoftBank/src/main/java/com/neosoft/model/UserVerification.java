package com.neosoft.model;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

public class UserVerification extends CommonDetails{
	
	private String username;
	private String password;
	private String mobileNo;
	//private String otp;
	@OneToOne
	private User user;
	
	public UserVerification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVerification(String username, String password, String mobileNo) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public String getOtp() { return otp; }
	 * 
	 * public void setOtp(String otp) { this.otp = otp; }
	 */
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "UserVerification [username=" + username + ", password=" + password + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
