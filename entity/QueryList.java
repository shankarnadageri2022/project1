package com.evehiclemanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="queryList_tbl")
public class QueryList {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="query_id")
	private int queryId;
	
	@Column(name="query")
	private String query;
	
	@Column(name="response")
	private String response;
	
    @Column(name="status")
	private int status;

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}

