package com.esporte.controller.signon;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.user.UserService;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.Response.UserRegisterResponse;
import com.esporte.model.user.User;

@Controller
@RequestMapping("/signon")
public class EsporteSignOnController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody User createUser(@RequestBody UserRegisterRequest userRegisterRequest) {
		User createdUser = userService.createUser(userRegisterRequest);
		return createdUser;
		
	}
}
