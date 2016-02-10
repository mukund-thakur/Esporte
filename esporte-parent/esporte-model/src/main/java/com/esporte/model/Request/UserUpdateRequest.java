package com.esporte.model.Request;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.esporte.model.Base.Sex;
import com.esporte.model.Base.UserType;
import com.esporte.model.sport.Sport;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserUpdateRequest {
	
	@JsonProperty
	private long userId;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String dateOfBirth;
	
	@JsonProperty
	private Sex sex;
	
	@JsonProperty
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@JsonProperty
	private List<Address> address;
	
	@JsonProperty
	private List<SportDetails> sports;
	
	@JsonProperty
	private List<Long> interestIds;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<SportDetails> getSports() {
		return sports;
	}

	public void setSports(List<SportDetails> sports) {
		this.sports = sports;
	}

	public List<Long> getInterestIds() {
		return interestIds;
	}

	public void setInterestIds(List<Long> interestIds) {
		this.interestIds = interestIds;
	}
	
	

}
