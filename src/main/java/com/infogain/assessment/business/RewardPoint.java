package com.infogain.assessment.business;

import org.springframework.stereotype.Component;

@Component
public class RewardPoint {
	
	
	public  int evaluatePoints(double amount) {
		double rewardPoint = 0;
		if (amount <= 0) {
			return 0;
		}
		
		int quotient = (int)amount / 100;
		int  remainder = (int)amount % 100;
		if (quotient>=1) {
		rewardPoint = (remainder * 2);
		rewardPoint= rewardPoint+1*50;
		}else{
			int quotient50 = (int)amount / 50;
			int  remainder50 = (int)amount % 50;
			if(quotient50>=1) {
			rewardPoint= remainder50*1;
			}
		}
		return (int) rewardPoint;

	}

}
