package com.neosoft.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.neosoft.utility.TransactionType;

@Entity
@Component
public class Transaction extends CommonDetails{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int transId;
	//private LocalDateTime date;
	private long accNo;
	private TransactionType transType;
	private BigDecimal amt;
	private BigDecimal balance;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	public Transaction(long accNo, TransactionType transType, BigDecimal amt, BigDecimal balance) {
		super();
		this.accNo = accNo;
		this.transType = transType;
		this.amt = amt;
		this.balance = balance;
	}

	
	
	/*
	 * public int getTransId() { return transId; }
	 * 
	 * public void setTransId(int transId) { this.transId = transId; }
	 */

	/*
	 * public LocalDateTime getDate() { return date; }
	 * 
	 * public void setDate(LocalDateTime date) { this.date = date; }
	 */

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TransactionType getTransType() {
		return transType;
	}

	public void setTransType(TransactionType transType) {
		this.transType = transType;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "Transaction [ accNo=" + accNo + ", transType=" + transType
				+ ", amt=" + amt + ", balance=" + balance + "]";
	}

	
	
}
