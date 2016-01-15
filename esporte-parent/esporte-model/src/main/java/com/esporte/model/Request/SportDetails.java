package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportDetails {
	
	@JsonProperty
	private long sportId;
	
	@JsonProperty
	private int hasVenue;
	
	@JsonProperty
	private int hasKit;
	
	@JsonProperty
	private int hasExtraKit;
}
