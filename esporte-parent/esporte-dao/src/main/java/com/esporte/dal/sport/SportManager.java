package com.esporte.dal.sport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.esporte.model.sport.Sport;

@Component
public class SportManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Sport> getAllSports() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Sport> criteriaQuery = criteriaBuilder.createQuery(Sport.class);
		Root<Sport> root = criteriaQuery.from(Sport.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public Sport getSportById(long sportId) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Sport> criteriaQuery = criteriaBuilder.createQuery(Sport.class);
		Root<Sport> root = criteriaQuery.from(Sport.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), sportId));
		List<Sport> reSports = entityManager.createQuery(criteriaQuery).getResultList();
		if ( reSports.size() > 0)
			return reSports.get(0);
		else 
			return null;
					
	}
}
