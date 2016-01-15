package com.esporte.dal.interest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.model.user.UserInterest;

@Component
public class InterestManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UserInterest> getAllInterests() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserInterest> criteriaQuery = criteriaBuilder.createQuery(UserInterest.class);
		Root<UserInterest> userInterestRoot = criteriaQuery.from(UserInterest.class);
		criteriaQuery.select(userInterestRoot);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public UserInterest getInterestById(long interestId) {
		return entityManager.find(UserInterest.class, interestId);
	}
}
