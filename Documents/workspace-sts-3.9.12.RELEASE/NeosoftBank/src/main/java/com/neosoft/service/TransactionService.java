package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Transaction;

public interface TransactionService {
	public Transaction add(Transaction trans);
	public List<Transaction> listAll();
	public Transaction getById(int transId);
	public void delete(int transId);
	public Transaction update(Transaction trans);
}
