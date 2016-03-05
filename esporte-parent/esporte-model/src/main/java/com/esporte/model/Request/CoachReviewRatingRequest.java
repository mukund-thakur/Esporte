package com.esporte.model.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachReviewRatingRequest {
	
	private Long playerId;
	
	private Long coachSportsMappingId;
	
	private String review;
	
	private Double rating;
		
}
