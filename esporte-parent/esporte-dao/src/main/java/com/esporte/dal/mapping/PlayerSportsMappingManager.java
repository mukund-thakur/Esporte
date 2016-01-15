package com.esporte.dal.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.sport.Sport;
import com.esporte.model.user.PlayerSportMapping;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerSportsMappingManager {
		
	@PersistenceContext
	private EntityManager entityManager;

	public PlayerSportMapping create(PlayerSportMapping playerSportMapping) {
		return entityManager.merge(playerSportMapping);

	}
	
	public PlayerSportMapping getPlayerSportMappingByUserAndSportId(long userId, long sportId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PlayerSportMapping> criteriaQuery = criteriaBuilder.createQuery(PlayerSportMapping.class);
		Root<PlayerSportMapping> root = criteriaQuery.from(PlayerSportMapping.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("user").get("id"), userId),criteriaBuilder.equal(root.get("sport").get("id"), sportId)));
		List<PlayerSportMapping> playerSportMappings = entityManager.createQuery(criteriaQuery).getResultList();
		if ( playerSportMappings.size() > 0)
			return playerSportMappings.get(0);
		else 
			return null;
		
	}

}
