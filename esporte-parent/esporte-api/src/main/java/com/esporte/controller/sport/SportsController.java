package com.esporte.controller.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.sport.SportService;
import com.esporte.model.sport.Sport;;

@Controller
public class SportsController {
	

	@Autowired
	private SportService sportService;
	
	@RequestMapping(value = "/sports",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Sport> getAllSports() {
		return sportService.getAllSports(); 
	}
}
