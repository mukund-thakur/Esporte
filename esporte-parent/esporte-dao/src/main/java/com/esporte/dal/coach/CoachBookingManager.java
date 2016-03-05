package com.esporte.dal.coach;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.Request.CoachBookingRequest;
import com.esporte.model.coach.CoachBooking;

import lombok.extern.apachecommons.CommonsLog;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CoachBookingManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CoachBooking create(CoachBooking coachBooking) {
		return entityManager.merge(coachBooking);
	}
	public CoachBooking getById(long id) {
		return entityManager.find(CoachBooking.class, id);
	}
	public CoachBooking update(CoachBooking coachBooking) {
		return entityManager.merge(coachBooking);
	}
}
