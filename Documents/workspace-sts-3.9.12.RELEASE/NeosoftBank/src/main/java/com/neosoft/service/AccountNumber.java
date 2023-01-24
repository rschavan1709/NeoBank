package com.neosoft.service;

public class AccountNumber {
	private static AccountNumber accountNumber=null;
	private static long accNo=11110000;
	private AccountNumber() {

	}
	public static AccountNumber getInstance() {
		if(accountNumber==null) {
			accountNumber=new AccountNumber();
		}
		return accountNumber;
	}
	
	public long getAccountNumber() {
		return accNo++;
	}

}
