package com.evehiclemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "queryResponesed_tbl")
public class QueryResponsed {
	
	@Id
	@JoinColumn(name="queryResponsed_id")
	private int queryResponsedId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="enquiry_id")
	private int enquiryId;

	public int getQueryResponsedId() {
		return queryResponsedId;
	}

	public void setQueryResponsedId(int queryResponsedId) {
		this.queryResponsedId = queryResponsedId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

}
