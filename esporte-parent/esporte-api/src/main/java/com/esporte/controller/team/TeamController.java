package com.esporte.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.match.TennisMatchService;
import com.esporte.bl.team.TeamService;
import com.esporte.model.Request.TeamCreateRequest;
import com.esporte.model.Request.TeamUpdateRequest;
import com.esporte.model.Request.TennisMatchCreateRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.match.TennisMatch;
import com.esporte.model.team.Team;
import com.esporte.model.user.User;

@Controller
@RequestMapping( value="/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/create" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Team createTeam(@RequestBody TeamCreateRequest teamCreateRequest) {
		return teamService.createTeam(teamCreateRequest);
	}
	
	@RequestMapping(value = "/update" , method=RequestMethod.PUT,produces = "application/json" , consumes = "application/json")
	   @ResponseBody
	   public Team updateTeamDetails(@RequestBody TeamUpdateRequest teamUpdateRequest) {
		   
		   return teamService.updateTeamDetails(teamUpdateRequest);
	   }
	   
}
