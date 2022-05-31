package com.evehiclemanagementsystem.service;

import com.evehiclemanagementsystem.entity.Enquiry;

public interface EnquiryService {

	public Enquiry saveEnquiry(String enquiryText,int customerId);

	public Enquiry getById(int id);

}