package com.esporte.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;

@Entity
@Table(name="phone_number")
public class PhoneNumber extends BaseData{
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="number")
	private String number;
	
	@Column(name="provider")
	private String provider;
	
	@Column(name="phone_number_type")
	private String phoneNumberType;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}
	
	
}
