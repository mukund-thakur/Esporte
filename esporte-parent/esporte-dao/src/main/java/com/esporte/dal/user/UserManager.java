package com.esporte.dal.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

}
