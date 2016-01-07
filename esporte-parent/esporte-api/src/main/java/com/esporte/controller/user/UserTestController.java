package com.esporte.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.user.UserTestService;
import com.esporte.dal.user.UserTestManager;
import com.esporte.model.Request.TestUserRegisterRequest;
import com.esporte.model.user.User;
import com.esporte.model.user.UserTest;

@Controller
@RequestMapping( value ="/testuser")
public class UserTestController {
	
	@Autowired
	private UserTestService userTestService;

	@RequestMapping(value="/create" , method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public UserTest createUser(@RequestBody TestUserRegisterRequest testUserRegisterRequest) {
		 return userTestService.createUser(testUserRegisterRequest);
		
	}
	
	@RequestMapping(value="/{userEmail}/exist" ,  method=RequestMethod.GET, produces="application/json" )
	@ResponseBody
	public Map<String, Integer> checkTestUserExists(@PathVariable("userEmail") String userEmail) {
		UserTest user = userTestService.getUserByEmail(userEmail);
		Map<String, Integer> responseMap = new HashMap<>();
		if (user!=null) {
			responseMap.put("Exist", 1);
		}else {
			responseMap.put("Exist", 0);
		}
		return responseMap;
	}
	
	@RequestMapping(method = RequestMethod.GET , produces = "application/json")
	@ResponseBody
	public List<UserTest> getAllTestUsers() {
		
		return userTestService.getAllTestUsers();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET , produces = "application/json")
	@ResponseBody
	public UserTest getTestUserById(@PathVariable("id") long id) {
		return userTestService.getTestUserById(id);
	}
}
