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
}
