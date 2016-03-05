package com.esporte.model.Request;

import java.sql.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.esporte.model.Base.Sex;
import com.esporte.model.Base.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachUpdateRequest {

	@JsonProperty
	private long userId;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private Date dateOfBirth;
	
	@JsonProperty
	private Sex sex;
	
	@JsonProperty
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@JsonProperty
	private List<AddressRequest> address;
	
	@JsonProperty
	private List<CoachSportsDetails> coachSportsMappingDetails;
	
	@JsonProperty
	private List<CoachInterestDetails> coachInterestMappingDetails;
}
