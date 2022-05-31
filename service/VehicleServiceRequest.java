package com.evehiclemanagementsystem.service;
import com.evehiclemanagementsystem.entity.ServiceRequest;
public interface VehicleServiceRequest{
	
	ServiceRequest addServiceRequest(ServiceRequest serviceRequest);
	public ServiceRequest getServiceRequestById(int id);
	
	
}