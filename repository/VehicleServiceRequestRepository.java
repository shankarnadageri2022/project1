package com.evehiclemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evehiclemanagementsystem.entity.ServiceRequest;

@Repository
public interface VehicleServiceRequestRepository extends JpaRepository<ServiceRequest,Integer> {
	List<ServiceRequest> findByStatus(String status);
}
