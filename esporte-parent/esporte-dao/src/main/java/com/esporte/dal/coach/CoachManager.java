package com.esporte.dal.coach;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.User;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CoachManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public User update(User user) {
		return entityManager.merge(user);
	}

}
