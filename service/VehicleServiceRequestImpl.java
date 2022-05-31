package com.evehiclemanagementsystem.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.entity.ServiceList;
import com.evehiclemanagementsystem.entity.ServiceRequest;
import com.evehiclemanagementsystem.exception.CustomerNotFoundException;
import com.evehiclemanagementsystem.exception.ResourceNotFoundException;
import com.evehiclemanagementsystem.exception.ServiceRequestNotFoundException;
import com.evehiclemanagementsystem.repository.CustomerRepository;
import com.evehiclemanagementsystem.repository.ServiceListRepository;
import com.evehiclemanagementsystem.repository.VehicleServiceRequestRepository;


@Service
public class VehicleServiceRequestImpl implements VehicleServiceRequest {
	

	@Autowired
	private VehicleServiceRequestRepository vechileServiceRequestRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceListRepository serviceListRepository;
	

	@Override
	public ServiceRequest addServiceRequest(ServiceRequest serviceRequest,int customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not existing with id: "+customerId);
		}
		Customer customer = optionalCustomer.get();
		
		int serviceId = serviceRequest.getServiceListId();
		
		Optional<ServiceList> optionalServiceList = serviceListRepository.findById(serviceId);
		if(optionalServiceList.isEmpty()) {
			throw new ResourceNotFoundException("Service not existing with id: "+serviceId);
		}
		
		ServiceList serviceList = optionalServiceList.get();
		
		serviceRequest.setTotalAmount(serviceList.getPrice());
		serviceRequest.setDate(LocalDateTime.now());
		serviceRequest.setStatus("Pending");
		serviceRequest.setCustomer(customer);
		
		return vechileServiceRequestRepository.save(serviceRequest);
	}

	@Override
	public ServiceRequest getServiceRequestById(int serviRequestId) throws ServiceRequestNotFoundException {
		Optional<ServiceRequest> serviceRequestById=vechileServiceRequestRepository.findById(serviRequestId);
		if(serviceRequestById.isEmpty()) {
			throw new ServiceRequestNotFoundException("service request not found");
		}	
		return serviceRequestById.get();
	}

	@Override
	public List<ServiceRequest> getAllServiceRequest() {
		
		return vechileServiceRequestRepository.findAll();
	}

	@Override
	public List<ServiceRequest> getAllServiceRequestByStatus(String status) {
	
		return vechileServiceRequestRepository.findByStatus(status);
	}

	@Override
	public ServiceRequest updateServiceRequestStatus(int serviceRequestId,String status) {
	
		Optional<ServiceRequest> serviceRequestById=vechileServiceRequestRepository.findById(serviceRequestId);
		if(serviceRequestById.isEmpty()) {
			throw new ServiceRequestNotFoundException("service request not found");
		}	
		
		ServiceRequest serviceRequest = serviceRequestById.get();
		
		serviceRequest.setStatus(status);
		
		ServiceRequest updatedServiceRequest = vechileServiceRequestRepository.save(serviceRequest);
		
		return updatedServiceRequest;
	}	

}