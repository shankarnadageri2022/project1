package com.evehiclemanagementsystem.model;

public class LoginResponse {

	private int customeId;
	private String customerName;
	private String customerEmail;
	private long customerPhone;
	private String address;
	public int getCustomeId() {
		return customeId;
	}
	public void setCustomeId(int customeId) {
		this.customeId = customeId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
