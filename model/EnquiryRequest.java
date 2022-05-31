package com.evehiclemanagementsystem.model;


public class EnquiryRequest {

	private int customerId;
	private String enquiryText;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEnquiryText() {
		return enquiryText;
	}
	public void setEnquiryText(String enquiryText) {
		this.enquiryText = enquiryText;
	}	
}