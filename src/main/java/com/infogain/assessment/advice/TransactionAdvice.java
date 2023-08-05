package com.infogain.assessment.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.infogain.assessment.exception.ErrorResponse;
import com.infogain.assessment.exception.TransactionException;

@ControllerAdvice
public class TransactionAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<Object> handleInvalidInput(TransactionException transactionException){
		ErrorResponse errorResponse = 
				new ErrorResponse("200",transactionException.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
	

}
