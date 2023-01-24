package com.neosoft.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.repository.AdminRepository;
import com.neosoft.utility.TransactionType;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	Transaction transaction;
	
	@Override
	public User add(User user) {
		return adminRepository.save(user);
	}
	
	public List<User> listAll() {
		return adminRepository.findAll();
	}

	@Override
	public User getByAccNo(long accNo) {
		User user=null;
		try {
				user= adminRepository.findByAccNo((int) accNo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(long accNo,User user) {
		User user1=adminRepository.findByAccNo(accNo);
		System.out.println(user1);
		user1=user;
		return adminRepository.save(user1);
	}

	@Override
	public void deleteByAccNo(long accNo) {
		User user=adminRepository.findByAccNo(accNo);
		adminRepository.delete(user);
	}

	@Override
	public void deposit(long accNo, BigDecimal amt) {
		User user=adminRepository.findByAccNo(accNo);
		if(user!=null) {
			BigDecimal amount=user.getBalance().add(amt);
			user.setBalance(amount);
			transaction=new Transaction(accNo,TransactionType.DEPOSIT,amt,user.getBalance());
			Set<Transaction> set=new HashSet<Transaction>();
			set.add(transaction);
			user.setTransaction(set);
			adminRepository.save(user);
		}
	}

	
	
}
