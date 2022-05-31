package com.evehiclemanagementsystem.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.entity.ServiceRequest;
import com.evehiclemanagementsystem.exception.CustomerNotFoundException;
import com.evehiclemanagementsystem.exception.ServiceRequestNotFoundException;
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

	@Override
	public ServiceRequest getServiceRequestById(int serviRequestId) throws ServiceRequestNotFoundException {
		Optional<ServiceRequest> serviceRequestById=vechileServiceRequestRepository.findById(serviRequestId);
		if(serviceRequestById.isEmpty()) {
			throw new ServiceRequestNotFoundException("service request not found");
		}
		ServiceRequest serviceRequest = serviceRequestById.get();
		
		return serviceRequest;
	}	
//	public Customer getById(int customerId) throws CustomerNotFoundException {
//		Optional<Customer> customerById = customerRepository.findById(customerId);
//		if (customerById.isEmpty()) {
//			throw new CustomerNotFoundException(customerId + " customer not found");
//		}
//		Customer customer = customerById.get();
//		return customer;
//	}
	
	
	
	
	

}