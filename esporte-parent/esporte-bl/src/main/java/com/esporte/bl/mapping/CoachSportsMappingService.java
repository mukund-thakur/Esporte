package com.esporte.bl.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.mapping.CoachSportsMappingManager;
import com.esporte.model.user.CoachSportsMapping;

@Component
public class CoachSportsMappingService {
	
	@Autowired
	private CoachSportsMappingManager coachSportsMappingManager;
	
	public CoachSportsMapping getCoachSporsMappingById(long id) {
		return coachSportsMappingManager.getCoachSportsMappingById(id);
	}
}
