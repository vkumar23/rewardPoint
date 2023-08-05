package com.infogain.assessment.service;

public class MonthlyResponse {
	private int month;
	private int rewardpoint;
	public MonthlyResponse(int month, int rewardpoint) {
		super();
		this.month = month;
		this.rewardpoint = rewardpoint;
	}
	public MonthlyResponse() {
	
		
	}
	public int getMonth() {
		return month;
	}
	public int getRewardpoint() {
		return rewardpoint;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setRewardpoint(int rewardpoint) {
		this.rewardpoint = rewardpoint;
	}
	
	
	
	
	
	
}
