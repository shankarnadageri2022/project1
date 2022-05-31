package com.evehiclemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evehiclemanagementsystem.entity.Enquiry;
import com.evehiclemanagementsystem.model.EnquiryRequest;
import com.evehiclemanagementsystem.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/enquiry/save")
	public Enquiry addEnquiry(@RequestBody EnquiryRequest enquiryRequest) {

		Enquiry newEnquiry = enquiryService.saveEnquiry(enquiryRequest.getEnquiryText(),enquiryRequest.getCustomerId());

		return newEnquiry;
	}

	@GetMapping("/enquiry/find/{enquiryId}")
	public Enquiry fetchEnquiryById(@PathVariable("enquiryId") int enquiryId) {
		Enquiry enquiry = enquiryService.getById(enquiryId);
		return enquiry;
	}
}