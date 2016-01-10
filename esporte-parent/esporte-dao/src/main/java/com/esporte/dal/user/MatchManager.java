package com.esporte.dal.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.Match;
import com.esporte.model.user.TestUser;

@Repository("matchManager")
@Transactional(propagation = Propagation.REQUIRED)
public class MatchManager {

	@PersistenceContext
	EntityManager entityManager;
	
	public Match createNewMatch(Match match) {
		return entityManager.merge(match);
	}

	public Match updateMatch(Match match) {
		// TODO Auto-generated method stub
		return entityManager.merge(match);
	}
	
	public Match getMatchById(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Match> criteriaQuery = builder.createQuery(Match.class);
		Root<Match> root = criteriaQuery.from(Match.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"), id));
		return entityManager.createQuery(criteriaQuery).getResultList().get(0);
	}
}
