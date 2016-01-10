package com.esporte.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.user.MatchService;
import com.esporte.model.Request.CreateMatchRequest;
import com.esporte.model.user.Match;

@Controller
@RequestMapping(value = "/match")
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	@RequestMapping(value = "/create" , method=RequestMethod.POST , consumes="application/json" , produces = "application/json")
	@ResponseBody
	public Match createNewMatch(@RequestBody CreateMatchRequest createMatchRequest) {
		return matchService.createNewMatch(createMatchRequest);
	}
	
	@RequestMapping(value = "/update" , method=RequestMethod.PUT , consumes="application/json" , produces = "application/json")
	@ResponseBody
	public Match updateMatch(@RequestBody CreateMatchRequest createMatchRequest) {
		return matchService.updateMatch(createMatchRequest);
	}
}
