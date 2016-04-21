package com.esporte.dal.team;

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
import com.esporte.model.team.Team;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("teamManager")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamManager {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Team create(Team team) {
		return entityManager.merge(team);
	}
	
	public Team update(Team team) {
		return entityManager.merge(team);
	}
	public Team getTeamById(long teamId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Team> criteriaQuery = builder.createQuery(Team.class);
		Root<Team> root = criteriaQuery.from(Team.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"), teamId));
		List<Team> teams = entityManager.createQuery(criteriaQuery).getResultList();
		if (teams.size() > 0)
			return teams.get(0);
		else
			return null;
	}
	
}
