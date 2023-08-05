package com.infogain.assessment.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RewardPointTest {
	
	RewardPoint rewardPoint;
	
	@BeforeEach
	public void init() {
	rewardPoint= new RewardPoint();	
	}

	@Test
	void testwithAmountzero() {
	rewardPoint.evaluatePoints(0);
	assertEquals(0, 0);	
	}
	
	@Test
	void testwithAmount120() {
	rewardPoint.evaluatePoints(120);
	assertEquals(90, 90);	
	}
	
	@Test
	void testNegativewithAmount120() {
	int actual=rewardPoint.evaluatePoints(120);
	assertThat( actual != 90);	
	}
	
	@AfterEach
	public void destroy() {
	if (rewardPoint !=null) {
		rewardPoint=null;
	}
		
	}

}
