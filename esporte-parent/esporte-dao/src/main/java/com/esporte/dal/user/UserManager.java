package com.esporte.dal.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.Base.UserType;
import com.esporte.model.Request.UserSearchRequest;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("userManager")
@Transactional(propagation = Propagation.REQUIRED)
public class UserManager {

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> getAllUsers() {
		String hqlString = "from user";
		List<User> users = entityManager.createNamedQuery("User.findAll", User.class).getResultList();
		return users;
	}

	public User create(User user) {
		return entityManager.merge(user);
	}

	public User update(User user) {
		return entityManager.merge(user);
	}

	public User getUserByName(String userName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("userName"), userName));
		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public User getUserById(long userId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"), userId));
		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public User getUserByPhone(String phoneNumber) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		Criteria phoneCriteria = criteria.createCriteria("phoneNumbers");
		phoneCriteria.add(Restrictions.eq("number", phoneNumber));
		List<User> users = criteria.list();
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public User getUserByEmail(String email) {
		// CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		// CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		// Root<User> root = criteriaQuery.from(User.class);
		// criteriaQuery.select(root);
		// criteriaQuery.where(builder.equal(root.get("emailIds").get("email"),
		// email));
		// List<User> users =
		// entityManager.createQuery(criteriaQuery).getResultList();
		// if(users.size() > 0 )
		// return users.get(0);
		// else
		// return null;
		//
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		Criteria emailCriteria = criteria.createCriteria("emailIds");
		emailCriteria.add(Restrictions.eq("email", email));
		List<User> list = criteria.list();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);

	}

	public List<User> userSearch(UserSearchRequest userSearchRequest){
		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		Criteria sportsCritera = criteria.createCriteria("playerSportMappings");
		Criteria sportsIdCriteria =sportsCritera.createCriteria("sport");
		
		
		List<Long> sportIdsList = userSearchRequest.getSportsIds();
		
		 
		sportsIdCriteria.add(Restrictions.in("id",sportIdsList));

		
		
		
		/*List<String> location = userSearchRequest.getLocation();
		if(location!= null && location.size()>0){
		
		ArrayList<SimpleExpression> se = new ArrayList<SimpleExpression>();
		for(int i=0; i<location.length; i++){
		se.add(Restrictions.eq("location", location[i]));
		}
		Criterion cr1 =Restrictions.in("locality",location);
		cr2 = Restrictions.and(cr2, cr1);
		}
				
		String city = userSearchRequest.getCity();
		if(city!=null){
		Criterion cr3= Restrictions.eq("city", city);
		cr2 = Restrictions.and(cr2, cr3);
		}
		double distance = userSearchRequest.getDistance();
		Criterion cr4 = Restrhttp://stackoverflow.com/questions/13858876/hibernate-criteria-query-multiple-criteriaictions.le("distance", distance);
		
		int minAge = userSearchRequest.getMinAge();
		if(minAge!=0){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.YEAR, -minAge);
			java.sql.Date sqlDate2=new java.sql.Date(now.getTimeInMillis());
		Criterion cr5 = Restrictions.ge("dob", sqlDate2);
		cr2 = Restrictions.and(cr2, cr5);
		}
		
		int maxAge = userSearchRequest.getMaxAge();
		if(maxAge!=0){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.YEAR, -maxAge);
			java.sql.Date sqlDate3=new java.sql.Date(now.getTimeInMillis());
		Criterion cr4 = Restrictions.le("dob", sqlDate3);
		cr2 = Restrictions.and(cr2, cr4);
		}
		
		
		int minRank =userSearchRequest.getMinRank();
		if(minRank!=0){
		Criterion cr6 = Restrictions.ge("rank", minRank);
		cr2 = Restrictions.and(cr2, cr6);
		}
		
		
		int maxRank =userSearchRequest.getMaxRank();
		if(maxRank!=0){
		Criterion cr7 = Restrictions.le("rank", maxRank);
		cr2 = Restrictions.and(cr2, cr7);
		}
		
		int minSeeding = userSearchRequest.getMinSeeding();
		if(minSeeding!=0){
		Criterion cr8 = Restrictions.ge("seeding", minSeeding);
		cr2 = Restrictions.and(cr2, cr8);
		}
		
		int maxSeeding = userSearchRequest.getMaxSeeding();
		if(maxSeeding!=0){
		Criterion cr9 = Restrictions.le("seeding", maxSeeding);
		cr2 = Restrictions.and(cr2, cr9);
		}
		
		
		int playerWithKit = userSearchRequest.getPlayerWithKit();
		
		Criterion cr10 = Restrictions.eq("hasKit", playerWithKit);
		cr2 = Restrictions.and(cr2, cr10);
		
		int playerWithExtraKit = userSearchRequest.getPlayerHasExtraKit();
		Criterion cr11 = Restrictions.eq("hasExtraKit", playerWithExtraKit);
		cr2 = Restrictions.and(cr2, cr11);
		
		int hasVenue = userSearchRequest.getHasVenue();
		Criterion cr12 = Restrictions.eq("hasVenue", hasVenue);
		cr2 = Restrictions.and(cr2, cr12);
		*/
		
		
		List<User> users = criteria.list();
				
		return users;
		
			
		
		
		
	}
	public List<User> getAllCoach(String sportName) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userType",UserType.COACH));
		criteria.setProjection(Projections.distinct(Projections.property("id")));
		if (sportName != null) {
		Criteria sportMappingCriteria = criteria.createCriteria("coachSportsMappings");
		Criteria sportCriteria = sportMappingCriteria.createCriteria("sport");
		sportCriteria.add(Restrictions.eq("name", sportName));
		}
		List<User> users = criteria.list();
		return users;
	}
}
