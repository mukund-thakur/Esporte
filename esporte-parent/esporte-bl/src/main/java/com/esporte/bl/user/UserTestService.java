package com.esporte.bl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.user.UserTestManager;
import com.esporte.model.Request.TestUserRegisterRequest;
import com.esporte.model.user.User;
import com.esporte.model.user.UserTest;

@Component
public class UserTestService {

	@Autowired
	private UserTestManager userTestManager;
	
	public UserTest createUser(TestUserRegisterRequest userRegisterRequest) {
		UserTest userTest = new UserTest();
		userTest.setEmail(userRegisterRequest.getEmail());
		userTest.setName(userRegisterRequest.getName());
		return userTestManager.createTestUser(userTest);
	}

	public UserTest getUserByEmail(String userName) {
		
		return userTestManager.getTestUserByEmail(userName);
	}

	public List<UserTest> getAllTestUsers() {
		return userTestManager.getAllTestUsers();
	}

	public UserTest getTestUserById(long id) {
		return userTestManager.getTestUserBy(id);
	}
}
