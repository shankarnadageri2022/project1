package com.evehiclemanagementsystem.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerNotFoundException extends RuntimeException{
	
	public  CustomerNotFoundException(String msg) {
		super(msg);
		
	}
}
	


