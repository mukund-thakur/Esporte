package com.esporte.dal.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.Base.UserType;
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
		List<User> users = entityManager.createNamedQuery("User.findAll",User.class).getResultList();
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
		if(users.size() > 0 )
			return users.get(0);
		else
			return null;
	}

	public User getUserById(long userId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"),userId));
		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
		if(users.size() > 0 )
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
		if(users.size() > 0 )
			return users.get(0);
		else
			return null;
	}
	public User getUserByEmail(String email) {
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
//		Root<User> root = criteriaQuery.from(User.class);
//		criteriaQuery.select(root);
//		criteriaQuery.where(builder.equal(root.get("emailIds").get("email"), email));
//		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
//		if(users.size() > 0 )
//			return users.get(0);
//		else
//			return null;
//		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		Criteria emailCriteria = criteria.createCriteria("emailIds");
		emailCriteria.add(Restrictions.eq("email", email));
		List<User> list = criteria.list();
		if ( list.isEmpty())
			return null;
		else 
			return list.get(0);
		
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
