package com.infogain.assessment.service;

import java.util.ArrayList;
import java.util.List;

public class TransactionResponse {
	private int total;
	private List<MonthlyResponse> monthly = new ArrayList<>();
	public TransactionResponse(int total, List<MonthlyResponse> monthly) {
		super();
		this.total = total;
		this.monthly = monthly;
	}
	public int getTotal() {
		return total;
	}
	public List<MonthlyResponse> getMonthly() {
		return monthly;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setMonthly(List<MonthlyResponse> monthly) {
		this.monthly = monthly;
	}
	public TransactionResponse() {
	}
	
	
	
	
	
	
	

}
