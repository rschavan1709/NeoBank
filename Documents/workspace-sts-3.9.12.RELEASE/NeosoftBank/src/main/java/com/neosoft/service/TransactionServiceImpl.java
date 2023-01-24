package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Transaction;
import com.neosoft.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transRepository;
	@Override
	public Transaction add(Transaction trans) {
		return transRepository.save(trans);
	}
	
	@Override
	public List<Transaction> listAll() {
		return transRepository.findAll();
	}
	@Override
	public Transaction getById(int transId) {
		return transRepository.findById(transId).get();
	}

	@Override
	public void delete(int transId) {
		transRepository.deleteById(transId);
	}

	@Override
	public Transaction update(Transaction trans) {
		return transRepository.save(trans);
	}
	
	
	
}
