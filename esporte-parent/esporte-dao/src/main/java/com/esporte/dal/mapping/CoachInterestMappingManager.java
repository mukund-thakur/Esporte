package com.esporte.dal.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.CoachInterestMapping;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CoachInterestMappingManager {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CoachInterestMapping getCoachInterestMappingByUserIdAndInterestId(long userId, long interestId) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CoachInterestMapping.class);
		Criteria userCriteria = criteria.createCriteria("user");
		Criteria interestCriteria = criteria.createCriteria("interest");
		userCriteria.add(Restrictions.eq("id", userId));
		interestCriteria.add(Restrictions.eq("id", interestId));
		List<CoachInterestMapping> coachInterestMappings = criteria.list();
		if ( coachInterestMappings.isEmpty()){
			return null;
		} else {
			return coachInterestMappings.get(0);
		}
	}

}
