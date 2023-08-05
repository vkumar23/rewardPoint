package com.infogain.assessment.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TRANSACTION")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transcationId;
	private int customerId;
	
	private LocalDateTime transactionDate;
	private double amount;
	private int transactionMonth;
	
	
	public int getTransactionMonth() {
		return transactionMonth;
	}
	public void setTransactionMonth(int transactionMonth) {
		this.transactionMonth = transactionMonth;
	}
	public int getTranscationId() {
		return transcationId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(int transcationId, int customerId, LocalDateTime transactionDate, double amount, int month) {
		super();
		this.transcationId = transcationId;
		this.customerId = customerId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionMonth = month;
	}
	public Transaction() {
		
	}
	@Override
	public String toString() {
		return "Transaction [transcationId=" + transcationId + ", customerId=" + customerId + ", transactionDate="
				+ transactionDate + ", amount=" + amount + ", transactionMonth=" + transactionMonth + "]";
	}

	
	
	
	

}
