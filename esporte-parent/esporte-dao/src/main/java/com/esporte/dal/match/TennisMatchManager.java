package com.esporte.dal.match;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.match.TennisMatch;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("tennisMatchManager")
@Transactional(propagation = Propagation.REQUIRED)
public class TennisMatchManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public TennisMatch create(TennisMatch tennisMatch) {
		return entityManager.merge(tennisMatch);
	}

	public TennisMatch update(TennisMatch tennisMatch){
		return entityManager.merge(tennisMatch);
	}
	
	public TennisMatch getMatchById(long matchId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TennisMatch> criteriaQuery = builder.createQuery(TennisMatch.class);
		Root<TennisMatch> root = criteriaQuery.from(TennisMatch.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"),matchId));
		List<TennisMatch> tennisMatch = entityManager.createQuery(criteriaQuery).getResultList();
		if(tennisMatch.size() > 0 )
			return tennisMatch.get(0);
		else
			return null;
	}
}
