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
import com.esporte.model.user.TestUser;

@Repository("userTestManager")
@Transactional(propagation = Propagation.REQUIRED)
public class UserTestManager {

	@PersistenceContext
	EntityManager entityManager;

	
	public TestUser createTestUser(TestUser user) {
		return entityManager.merge(user);
	}


	public TestUser getTestUserByEmail(String userEmail) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestUser> criteriaQuery = builder.createQuery(TestUser.class);
		Root<TestUser> root = criteriaQuery.from(TestUser.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("email"), userEmail));
		List<TestUser> users = entityManager.createQuery(criteriaQuery).getResultList();
	    if(users.size() > 0 )
			return users.get(0);
		else
			return null;
	}


	public List<TestUser> getAllTestUsers() {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestUser> criteriaQuery = builder.createQuery(TestUser.class);
		Root<TestUser> root = criteriaQuery.from(TestUser.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}


	public TestUser getTestUserBy(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestUser> criteriaQuery = builder.createQuery(TestUser.class);
		Root<TestUser> root = criteriaQuery.from(TestUser.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("id"), id));
		return entityManager.createQuery(criteriaQuery).getResultList().get(0);
	}
}
