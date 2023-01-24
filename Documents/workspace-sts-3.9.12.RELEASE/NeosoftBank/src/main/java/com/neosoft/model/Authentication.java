package com.neosoft.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Authentication extends CommonDetails {
	
	/*
	 * @Transient public static final long OTP_VALID_DURATION = 5 * 60 * 1000;
	 */
	
	private int userId;
	private String username;
	private String mobileNo;
	private String password;
	private String otp;
	private Boolean otpVerfiy=false;
	private Date otpRequestedTime;
	private Date otpEnterdTimeDate;
	
	 public Date getOtpEnterdTimeDate() {
		return otpEnterdTimeDate;
	}

	public void setOtpEnterdTimeDate(Date otpEnterdTimeDate) {
		this.otpEnterdTimeDate = otpEnterdTimeDate;
	}

	public Date getOtpRequestedTime() { return otpRequestedTime; }
	  
	 public void setOtpRequestedTime(Date otpRequestedTime) {
	 this.otpRequestedTime = otpRequestedTime; }
	 

	public Boolean getOtpVerfiy() {
		return otpVerfiy;
	}

	public void setOtpVerfiy(Boolean otpVerfiy) {
		this.otpVerfiy = otpVerfiy;
	}

	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Authentication(String username, String otp) {
		super();
		this.username = username;
		this.otp = otp;
	}

	public Authentication(String username, String mobileNo, String password, String otp) {
		super();
		this.username = username;
		this.mobileNo = mobileNo;
		this.password = password;
		this.otp = otp;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Authentication [username=" + username + ", mobileNo=" + mobileNo + ", password=" + password + ", otp="
				+ otp + ", otpVerfiy=" + otpVerfiy + "]";
	}

	
	
}
