package com.esporte.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.esporte.common.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.esporte.bl.user.UserTestService;
import com.esporte.dal.user.UserTestManager;
import com.esporte.model.Request.TestUserRegisterRequest;
import com.esporte.model.user.User;
import com.esporte.model.user.TestUser;

@Controller
@RequestMapping( value ="/testuser")
public class UserTestController {
	
	@Autowired
	private UserTestService userTestService;

	@RequestMapping(value="/create" , method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody TestUserRegisterRequest testUserRegisterRequest) {
		try {
			TestUser testUser =userTestService.createUser(testUserRegisterRequest);
			return new ResponseEntity<>(testUser,HttpStatus.OK);
		} catch (UserAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} 		
	}
	@RequestMapping(value="/update" , method=RequestMethod.PUT,consumes="application/json" , produces = "application/json")
	@ResponseBody
	public TestUser updateUser(@RequestBody TestUser testUser ) {
		return userTestService.updateUser(testUser);
	}
	
	
	@RequestMapping(value="/{userEmail}/exist" ,  method=RequestMethod.GET, produces="application/json" )
	@ResponseBody
	public Map<String, Integer> checkTestUserExists(@PathVariable("userEmail") String userEmail) {
		TestUser user = userTestService.getUserByEmail(userEmail);
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
	public List<TestUser> getAllTestUsers() {
		
		return userTestService.getAllTestUsers();
	}
	
	@RequestMapping(value = "/getById/{id}" ,method = RequestMethod.GET , produces = "application/json")
	@ResponseBody
	public TestUser getTestUserById(@PathVariable("id") long id) {
		return userTestService.getTestUserById(id);
	}
	@RequestMapping(value = "/getByEmail" ,method = RequestMethod.GET , consumes="application/json",produces = "application/json")
	@ResponseBody
	public TestUser getTestUserByEmail(@RequestParam("email") String email) {
		return userTestService.getUserByEmail(email);
	}
	
}
