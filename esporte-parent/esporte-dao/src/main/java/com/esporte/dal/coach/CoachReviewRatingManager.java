package com.esporte.dal.coach;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.coach.CoachReviewRating;

import lombok.extern.apachecommons.CommonsLog;

@Component
@Transactional(propagation=Propagation.REQUIRED)
public class CoachReviewRatingManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CoachReviewRating create(CoachReviewRating coachReviewRating) {
		return entityManager.merge(coachReviewRating);
	}

}
