package com.esporte.model.Request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.esporte.model.Base.CoachBookingStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachBookingRequest {

	private Long bookingId;
	
	private Long playerId;
	
	private Long coachAvailabilityId;
	
	private Boolean isCoachVisiting;
	
	private String address;
	
	private Boolean isGroupBooking;
	
	@Enumerated(EnumType.STRING)
	private CoachBookingStatus status;
	
	
}
