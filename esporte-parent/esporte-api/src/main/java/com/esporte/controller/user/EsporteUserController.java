package com.esporte.controller.user;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.model.user.User;


@Controller
public class EsporteUserController {
	
	   @RequestMapping( value = "/hello" , method = RequestMethod.GET)
	   @ResponseBody
	   public String printHello() {
	      return "hello";
	   }

	   
}
