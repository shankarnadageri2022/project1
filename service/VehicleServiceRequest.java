package com.evehiclemanagementsystem.service;
import java.util.List;

import com.evehiclemanagementsystem.entity.ServiceRequest;
public interface VehicleServiceRequest{
	

	ServiceRequest addServiceRequest(ServiceRequest serviceRequest, int customerId);

	ServiceRequest getServiceRequestById(int id);
	
	List<ServiceRequest> getAllServiceRequest();	
	
	List<ServiceRequest> getAllServiceRequestByStatus(String status);	
	
	ServiceRequest updateServiceRequestStatus(int serivceRequestId,String status);
	
	
}