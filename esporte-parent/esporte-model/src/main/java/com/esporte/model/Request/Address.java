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
public class Address {
	
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getSubLocality() {
		return subLocality;
	}

	public void setSubLocality(String subLocality) {
		this.subLocality = subLocality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
	
}
