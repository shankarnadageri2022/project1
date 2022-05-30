package com.evehiclemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<String> handleServiceNotFoundException(Exception e){
	ResponseEntity<String> responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	return responseEntity;
	}	
}
