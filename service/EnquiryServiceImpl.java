package com.evehiclemanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehiclemanagementsystem.entity.Customer;
import com.evehiclemanagementsystem.entity.Enquiry;
import com.evehiclemanagementsystem.exception.CustomerNotFoundException;
import com.evehiclemanagementsystem.repository.CustomerRepository;
import com.evehiclemanagementsystem.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Enquiry saveEnquiry( String enquiryText,int customerId ) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
		throw new CustomerNotFoundException("Customer not existing with id: "+customerId);
		}
		Customer customer = optionalCustomer.get();
		Enquiry enquiry = new Enquiry();
		enquiry.setQuery(enquiryText);
		enquiry.setStatus("New");
		enquiry.setResponse("");
		enquiry.setCustomer(customer);
		Enquiry newEnquiry = enquiryRepository.save(enquiry);
		return newEnquiry;
	}

	@Override
	public Enquiry getById(int enquiryId) {
		Optional<Enquiry> enquiryById = enquiryRepository.findById(enquiryId);
		Enquiry enquiry = enquiryById.get();
		return enquiry;
	}

}