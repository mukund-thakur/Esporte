package com.esporte.model.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachAvailabilityRequest {
	
	private String date;
	
	private long startHour;
	
	private long endHour;
	
	private long coachSportMappingId;
	
}
