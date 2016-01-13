package com.esporte.bl.user;

import java.util.List;

import org.esporte.common.exception.UserAlreadyExistsException;
import org.esporte.common.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.user.UserTestManager;
import com.esporte.model.Request.TestUserRegisterRequest;
import com.esporte.model.user.User;
import com.esporte.model.user.TestUser;

@Component
public class UserTestService {

	@Autowired
	private UserTestManager userTestManager;
	
	public TestUser createUser(TestUserRegisterRequest userRegisterRequest) throws UserAlreadyExistsException {
		if ( userTestManager.getTestUserByEmail(userRegisterRequest.getEmail()) != null) {
			throw new  UserAlreadyExistsException(userRegisterRequest.getEmail());
		}
		TestUser userTest = new TestUser();
		userTest.setEmail(userRegisterRequest.getEmail());
		userTest.setName(userRegisterRequest.getName());
		userTest.setRanking(userTestManager.getAllTestUsers().size() + 1);
		return userTestManager.createTestUser(userTest);
	}

	public TestUser getUserByEmail(String userName) {
		
		return userTestManager.getTestUserByEmail(userName);
	}

	public List<TestUser> getAllTestUsers() {
		return userTestManager.getAllTestUsers();
	}

	public TestUser getTestUserById(long id) {
		return userTestManager.getTestUserBy(id);
	}

	public TestUser updateUser(TestUser testUser) {
		TestUser user = userTestManager.getTestUserBy(testUser.getId());
		user.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		user.setLevel(testUser.getLevel());
		user.setRanking(testUser.getRanking());
		user.setSeeding(testUser.getSeeding());
		return userTestManager.createTestUser(user);
		
	}
}
