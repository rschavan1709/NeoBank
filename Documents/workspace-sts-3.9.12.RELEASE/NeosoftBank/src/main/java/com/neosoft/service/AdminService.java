package com.neosoft.service;

import java.math.BigDecimal;
import java.util.List;

import com.neosoft.model.User;

public interface AdminService {
	public User add(User user);
	public List<User> listAll();
	public void deleteByAccNo(long accNo);
	public User update(long accNo,User user);
	public User getByAccNo(long accNo);
	public void deposit(long accNo,BigDecimal amt);
}
