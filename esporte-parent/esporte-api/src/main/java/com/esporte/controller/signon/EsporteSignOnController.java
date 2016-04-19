package com.esporte.controller.signon;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.user.UserService;
import com.esporte.common.exception.PassWordNotMatchingException;
import com.esporte.common.exception.UserNotFoundException;
import com.esporte.common.exception.UserWithEmailAlreadyExistsException;
import com.esporte.common.exception.UserWithPhoneAlreadyExistsException;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.Request.UserSinginRequest;
import com.esporte.model.Response.UserRegisterResponse;
import com.esporte.model.user.User;

@Controller
@RequestMapping("/signon")
public class EsporteSignOnController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody UserRegisterRequest userRegisterRequest) {
		try {
			User createdUser = userService.createUser(userRegisterRequest);
			return new ResponseEntity<>(createdUser,org.springframework.http.HttpStatus.OK);
		} catch (UserWithEmailAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
		} catch (UserWithPhoneAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(),org.springframework.http.HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping(value="/user/signin" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> signinUser(@RequestBody UserSinginRequest userRegisterRequest) {
		try {
			User createdUser = userService.signin(userRegisterRequest);
			return new ResponseEntity<>(createdUser,org.springframework.http.HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
		} catch (PassWordNotMatchingException e) {
			return new ResponseEntity<>(e.getMessage(),org.springframework.http.HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
