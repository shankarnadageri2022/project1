package com.evehiclemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService ;
	
	@PostMapping("/customer/save")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		Customer newCustomer= customerService.saveCustomer(customer);
		return newCustomer;
	}
	
}
