package com.esporte.model.user;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClubAddress extends Address{
	
	@JsonIgnore
	@OneToOne(mappedBy="clubAddress",fetch=FetchType.LAZY)
	private Club club;
	
}
