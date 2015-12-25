package com.esporte.model.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegisterResponse {

	@JsonProperty
	private long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String emailId;
	
	@JsonProperty
	private String phoneNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty
	private String password;
	
	@JsonProperty
	private String status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
