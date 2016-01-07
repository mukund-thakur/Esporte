package com.esporte.dal.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.User;
import com.esporte.model.user.UserTest;

@Repository("userTestManager")
@Transactional(propagation = Propagation.REQUIRED)
public class UserTestManager {

	@PersistenceContext
	EntityManager entityManager;

	
	public UserTest createTestUser(UserTest user) {
		return entityManager.merge(user);
	}


	public UserTest getTestUserByEmail(String userEmail) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserTest> criteriaQuery = builder.createQuery(UserTest.class);
		Root<UserTest> root = criteriaQuery.from(UserTest.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("email"), userEmail));
		List<UserTest> users = entityManager.createQuery(criteriaQuery).getResultList();
		if(users.size() > 0 )
			return users.get(0);
		else
			return null;
	}


	public List<UserTest> getAllTestUsers() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserTest> criteriaQuery = builder.createQuery(UserTest.class);
		Root<UserTest> root = criteriaQuery.from(UserTest.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}


	public UserTest getTestUserBy(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserTest> criteriaQuery = builder.createQuery(UserTest.class);
		Root<UserTest> root = criteriaQuery.from(UserTest.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"), id));
		return entityManager.createQuery(criteriaQuery).getResultList().get(0);
	}
}
