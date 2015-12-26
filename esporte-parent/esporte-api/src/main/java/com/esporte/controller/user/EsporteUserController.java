package com.esporte.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	  
	   
	   @RequestMapping(value = "/{username}/exist",method=RequestMethod.GET, produces="application/json")
	   @ResponseBody
	   public Map<String, Integer> checkUserExists(@PathVariable("username") String userName){
		User user = userService.getUserByName(userName);
		Map<String, Integer> responseMap = new HashMap<>();
		if (user!=null) {
			responseMap.put("Exist", 1);
		}else {
			responseMap.put("Exist", 0);
		}
		return responseMap;
		   
	   }
	   
}
