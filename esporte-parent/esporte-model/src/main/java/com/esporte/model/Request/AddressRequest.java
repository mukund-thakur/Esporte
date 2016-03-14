package com.esporte.model.Request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.neo4j.cypher.internal.commands.expressions.Add;

import com.esporte.model.Base.AddressType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
	
	@JsonProperty
	private long id;
	
	@JsonProperty
	private String country;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String locality;
	
	@JsonProperty
	private String subLocality;
	
	@JsonProperty
	private String address;
	
	@JsonProperty
	private long pin;
	
	@JsonProperty
	private String landmark;
	
	@JsonProperty
	private String coordinates;
	
	@JsonProperty
	private String state;

	@JsonProperty
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
