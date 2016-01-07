package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestUserRegisterRequest {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
