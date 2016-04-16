package com.esporte.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.mapping.PlayerSportsMappingService;
import com.esporte.bl.user.UserService;
import com.esporte.model.Request.UserSearchRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;



@Controller
@RequestMapping( value="/user")
public class EsporteUserController {
	
	   @Autowired
	   private UserService userService;
	   
	   @Autowired
	   private PlayerSportsMappingService playerSportsMappingService;
	   
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
	  
	   @RequestMapping(value = "/{id}" , method=RequestMethod.GET , produces="application/json")
	   @ResponseBody
	   public User getUserById(@PathVariable("id") long id) {
		   return userService.getUserById(id);
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
	   

	   @RequestMapping(value = "/update" , method=RequestMethod.PUT,produces = "application/json" , consumes = "application/json")
	   @ResponseBody
	   public User updateUserDetails(@RequestBody UserUpdateRequest userUpdateRequest) {
		   
		   return userService.updatePlayerDetails(userUpdateRequest);
	   }
	   
	   @RequestMapping(value= "/search", method=RequestMethod.POST,produces = "application/json" , consumes = "application/json")
	   @ResponseBody
	   public List<User> searchUser(@RequestBody UserSearchRequest userSearchRequest){
		   return userService.searchUser(userSearchRequest);
	   }
}
