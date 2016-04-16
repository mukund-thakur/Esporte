package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserSinginRequest {
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String password;

}
