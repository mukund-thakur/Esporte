package com.esporte.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.user.UserService;
import com.esporte.model.user.User;


@Controller
@RequestMapping( value="/user")
public class EsporteUserController {
	
	   @Autowired
	   private UserService userService;
	   
	   
	   @RequestMapping( value = "/hello" , method = RequestMethod.GET)
	   @ResponseBody
	   public String printHello() {
	      return "hello";
	   }
	   
	   @RequestMapping(method=RequestMethod.GET , produces="application/json")
	   @ResponseBody
	   public List<User> getAllUsers() {
		   List<User> users = new ArrayList<>();
		   return userService.getAllUsers();
	   }
	  
	   
}
