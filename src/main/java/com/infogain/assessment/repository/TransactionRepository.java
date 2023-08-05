package com.infogain.assessment.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infogain.assessment.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	List<Transaction> findByCustomerId(int customerId);
	
	
	


	List<Transaction> findByCustomerIdAndTransactionMonth(int id, int month);



	List<Transaction> findByCustomerIdAndTransactionDateBetween(int id, LocalDateTime dateTime,
			LocalDateTime minusMonths);

}
