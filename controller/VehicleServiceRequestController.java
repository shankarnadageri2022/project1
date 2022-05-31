package com.evehiclemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.entity.ServiceRequest;
import com.evehiclemanagementsystem.service.VehicleServiceRequest;

@RestController
public class VehicleServiceRequestController {
	@Autowired
	private VehicleServiceRequest vechileServiceRequest;

	@PostMapping("/serviceRequest/save")
	public ServiceRequest requestForService(@RequestBody ServiceRequest serviceRequest) {

		ServiceRequest newServiceRequest = vechileServiceRequest.addServiceRequest(serviceRequest);
		return newServiceRequest;

	}
	@GetMapping("/serviceRequest/find/{serviceRequestId}")
	public ServiceRequest fetchServiceRequestById(@PathVariable("serviceRequestId") int serviceRequestId) {
		ServiceRequest newServiceRequest=vechileServiceRequest.getServiceRequestById(serviceRequestId);
		return newServiceRequest;
	}
	
	
//	@GetMapping("/customer/find/{customerId}")
//	public Customer fetchCustomerById(@PathVariable("customerId") int customerId) {
//		Customer customer = customerService.getById(customerId);
//		return customer;
//	}
//	
	
	
	
	
	

}