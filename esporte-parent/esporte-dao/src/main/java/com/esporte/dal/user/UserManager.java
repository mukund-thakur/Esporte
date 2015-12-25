package com.esporte.dal.user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
