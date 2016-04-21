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

import com.esporte.model.team.PlayerTeamMapping;
import com.esporte.model.user.PlayerSportMapping;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerTeamMappingManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public PlayerTeamMapping getPlayerTeamMappingByUserAndTeamId(long userId, long teamId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PlayerTeamMapping> criteriaQuery = criteriaBuilder.createQuery(PlayerTeamMapping.class);
		Root<PlayerTeamMapping> root = criteriaQuery.from(PlayerTeamMapping.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("user").get("id"), userId),criteriaBuilder.equal(root.get("team").get("id"), teamId)));
		List<PlayerTeamMapping> playerTeamMappings = entityManager.createQuery(criteriaQuery).getResultList();
		if ( playerTeamMappings.size() > 0)
			return playerTeamMappings.get(0);
		else 
			return null;
		
	}
}
