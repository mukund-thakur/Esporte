package com.esporte.dal.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.CoachSportsMapping;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CoachSportsMappingManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CoachSportsMapping getCoachSportsMappingByUserIdAndSportsId(long userId,long sportId) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CoachSportsMapping.class);
		Criteria userCriteria =criteria.createCriteria("user");
		Criteria sportCriteria = criteria.createCriteria("sport");
		userCriteria.add(Restrictions.eq("id", userId));
		sportCriteria.add(Restrictions.eq("id", sportId));
		List<CoachSportsMapping> coachSportsMappings = criteria.list();
		if ( !coachSportsMappings.isEmpty()) {
			return coachSportsMappings.get(0);
		} else {
			return null;
		}
		
	}
	
	public CoachSportsMapping getCoachSportsMappingById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CoachSportsMapping.class);
		criteria.add(Restrictions.eq("id", id));
		List<CoachSportsMapping> coachSportsMappings = criteria.list();
		if ( !coachSportsMappings.isEmpty()) {
			return coachSportsMappings.get(0);
		} else {
			return null;
		}
		
	}
	
	
}
