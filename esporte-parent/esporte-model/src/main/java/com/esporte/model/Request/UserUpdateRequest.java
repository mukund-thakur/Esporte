package com.esporte.model.Request;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.esporte.model.Base.Sex;
import com.esporte.model.Base.UserType;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.Address;
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
	private List<AddressRequest> address;
	
	@JsonProperty
	private List<SportDetailsRequest> sports;
	
	@JsonProperty
	private List<Long> interestIds;


}
