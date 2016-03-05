package com.esporte.model.Request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.esporte.model.user.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubCreateRequest {

	
	private String name;
	
	private String description;
	
	private Address clubAddress;
}
