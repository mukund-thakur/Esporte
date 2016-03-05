package com.esporte.model.Request;

import java.net.Inet4Address;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachInterestDetails {

	private long interestId;
	
	private String qualification;
	
	private String experience;
	
	private String groupFee;
	
	private String fee;
	
	private long maxPlayerPerGroup;
	
	private boolean coachCanVisit;
	
	private List<Integer> clubIds;
}
