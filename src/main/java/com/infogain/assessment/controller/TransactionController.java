package com.infogain.assessment.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.assessment.model.Transaction;
import com.infogain.assessment.repository.TransactionRepository;
import com.infogain.assessment.service.TransactionResponse;
import com.infogain.assessment.service.TransactionService;




@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	Logger logger=LoggerFactory.getLogger(TransactionController.class);

	
	@Autowired private TransactionRepository transactionRepository;
	 
	@Autowired
	private TransactionService transactionService;

	List<Transaction> list = new ArrayList<Transaction>();

	@PostConstruct
	void loadData() {
		List<Transaction> of = List.of(
				new Transaction(1, 1, LocalDateTime.now(), 120, LocalDateTime.now().getMonthValue()),
				new Transaction(2, 1, LocalDateTime.now(), 60, LocalDateTime.now().getMonthValue()),
				new Transaction(3, 1, LocalDateTime.now().minusDays(40), 60,
						LocalDateTime.now().minusDays(40).getMonthValue()),
				new Transaction(3, 1, LocalDateTime.now().minusDays(120), 40,
						LocalDateTime.now().minusDays(120).getMonthValue()),
				new Transaction(4, 1, LocalDateTime.now().minusDays(80), 170,
						LocalDateTime.now().minusDays(80).getMonthValue()));

			transactionRepository.saveAll(of);

	}

	
	
	  @GetMapping("/rewards/{id}/{month}") public List<Transaction>
	  getAllTransactions(@PathVariable int id, @PathVariable int month) { return
	  transactionRepository.findByCustomerIdAndTransactionMonth(id, month); }
	 
	
	@GetMapping("/rewards")
	public TransactionResponse getRewardForEachMonthByDate(@RequestParam("id") int customerId,
		@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    	LocalDateTime date ) {
		logger.info("getRewardForMonthByDate for customer id " + customerId +" and from date" +date);
		return transactionService.getRewardForEachMonth(customerId, date);

	}

	
	
}
