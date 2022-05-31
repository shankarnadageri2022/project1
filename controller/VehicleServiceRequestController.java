package com.evehiclemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.entity.ServiceRequest;
import com.evehiclemanagementsystem.service.VehicleServiceRequest;

@RestController
public class VehicleServiceRequestController {
	@Autowired
	private VehicleServiceRequest vechileServiceRequest;

	@PostMapping("/serviceRequest/save/{customerId}")
	public ServiceRequest requestForService(@PathVariable int customerId,@RequestBody ServiceRequest serviceRequest) {

		ServiceRequest newServiceRequest = vechileServiceRequest.addServiceRequest(serviceRequest,customerId);
		return newServiceRequest;

	}
	@GetMapping("/serviceRequest/find/all")
	public List<ServiceRequest> fetchServiceRequestById() {
		List<ServiceRequest> serviceRequests=vechileServiceRequest.getAllServiceRequest();
		return serviceRequests;
	}
	
	@GetMapping("/serviceRequest/find/{serviceRequestId}")
	public ServiceRequest fetchServiceRequestById(@PathVariable("serviceRequestId") int serviceRequestId) {
		ServiceRequest newServiceRequest=vechileServiceRequest.getServiceRequestById(serviceRequestId);
		return newServiceRequest;
	}
	
	@GetMapping("/serviceRequest/findall/{status}")
	public List<ServiceRequest> fetchServiceRequestById(@PathVariable String status) {
		List<ServiceRequest> serviceRequests=vechileServiceRequest.getAllServiceRequestByStatus(status);
		return serviceRequests;
	}
	

	@PutMapping("/serviceRequest/update/{serviceRequestId}")
	public ServiceRequest changeServiceRequestStatus(@PathVariable int serviceRequestId,@RequestBody String status) {

		ServiceRequest newServiceRequest = vechileServiceRequest.updateServiceRequestStatus(serviceRequestId, status);
		return newServiceRequest;

	}

}