package com.esporte.dal.club;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.Club;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class ClubManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Club createClub(Club club) {
		return entityManager.merge(club);
	}
	
	public Club getClubById(long id) {
		return entityManager.find(Club.class, id);
	}
}
