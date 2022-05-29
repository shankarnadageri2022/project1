package com.evehiclemanagementsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehiclemanagementsystem.entity.ServiceRequest;
import com.evehiclemanagementsystem.repository.VehicleServiceRequestRepository;


@Service
public class VehicleServiceRequestImpl implements VehicleServiceRequest {
	
	@Autowired
	private VehicleServiceRequestRepository vechileServiceRequestRepository;

	@Override
	public ServiceRequest addServiceRequest(ServiceRequest serviceRequest) {
		ServiceRequest newServicerequest= vechileServiceRequestRepository.save(serviceRequest);
		return newServicerequest;
	}	

}