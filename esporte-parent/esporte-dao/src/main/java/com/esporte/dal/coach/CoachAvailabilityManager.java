package com.esporte.dal.coach;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.coach.CoachAvailability;
import com.esporte.model.user.User;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CoachAvailabilityManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public CoachAvailability create(CoachAvailability coachAvailability) {
		return entityManager.merge(coachAvailability);
	}
	
	public CoachAvailability getById(long id) {
		return entityManager.find(CoachAvailability.class, id);
	}
}
