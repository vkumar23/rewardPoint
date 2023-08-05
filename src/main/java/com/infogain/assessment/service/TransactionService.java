package com.infogain.assessment.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infogain.assessment.business.RewardPoint;
import com.infogain.assessment.exception.TransactionException;
import com.infogain.assessment.model.Transaction;
import com.infogain.assessment.repository.TransactionRepository;

@Component
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private RewardPoint rewardPoint;

	private List<Transaction> list;
	
	
	
	// This is if the month is passed in path variable
	
	public Integer getRewardForMonth(int id,int month) { 
		  if (month<0 || month>2) {
			  throw new TransactionException("month is not valid");
		  }
		  	 int sum=0;
			  List<Transaction> list =transactionRepository.findByCustomerIdAndTransactionMonth(id,month);
			  sum = list.stream().mapToInt(t->rewardPoint.evaluatePoints(t.getAmount())).sum();
			  return sum;

	  }
	  
	  
	
	  // This will give total and monthly for a customer
	  public TransactionResponse getRewardForEachMonth(int id,LocalDateTime dateTime) { 
		  	 
		  	 List<MonthlyResponse> monthlyResponse= new ArrayList<MonthlyResponse>();
		  	 
			 list = transactionRepository.findByCustomerIdAndTransactionDateBetween(id,dateTime.minusMonths(3),dateTime);
			 
			Map<Integer, Integer> map = list.stream().collect(Collectors.groupingBy(t->t.getTransactionDate().getMonth().getValue(),
					Collectors.summingInt(t->rewardPoint.evaluatePoints(t.getAmount()))));
			
			map.entrySet().stream().forEach(e->{
				monthlyResponse.add(new MonthlyResponse(e.getKey(), e.getValue()));
			});
			
			int sum = monthlyResponse.stream().mapToInt(i->i.getRewardpoint()).sum();
			
			TransactionResponse response = new TransactionResponse(sum,monthlyResponse) ;
			
			 return response;

	  }
	
	
	
	
	

}
