package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Transaction;
import com.neosoft.model.User;
import com.neosoft.service.TransactionServiceImpl;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionServiceImpl transactionService;
	
	@PostMapping("/add")
	public Transaction addTransaction(@RequestBody Transaction trans) {
		return transactionService.add(trans);
	}
	
	@GetMapping("/getAll")
	public List<Transaction> getAllUsers() {
		return transactionService.listAll();
	}
	
	@GetMapping("/getById/{transId}")
	public Transaction getById(@PathVariable int transId){
		return transactionService.getById(transId);
	}
	
	@DeleteMapping("/delete/{transId}")
	public void deleteById(@PathVariable int transId) {
		transactionService.delete(transId);
	}
	
	@PutMapping("/update")
	public Transaction update(@RequestBody Transaction trans) {
		return transactionService.update(trans);
	}
}
