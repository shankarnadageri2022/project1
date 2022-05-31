package com.evehiclemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.model.ChangePasswordRequest;
import com.evehiclemanagementsystem.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer/save")
	public Customer addCustomer(@RequestBody Customer customer) {


		return customerService.saveCustomer(customer);
	}

	@GetMapping("/customer/find/{customerId}")
	public Customer fetchCustomerById(@PathVariable("customerId") int customerId) {
		
		return customerService.getById(customerId);
	}
	@GetMapping("/customer/recoverPassword/{customerId}")
	public String recoverPassword(@PathVariable int customerId) {
	
		return customerService.recoverPassword(customerId);
	}
	@PostMapping("/customer/update")
	public Customer updatedProfile(@RequestBody Customer customer) {
		
		return customerService.updateProfile(customer);
	}
	
	@PutMapping("/customer/changePassword")
	public String changePassword(@RequestBody ChangePasswordRequest changePasswordRequest ) {
		String response=customerService.changePassword(changePasswordRequest.getCustomerId(), changePasswordRequest.getOldPassword(),changePasswordRequest.getNewPassword());
		return response;
	}


}
