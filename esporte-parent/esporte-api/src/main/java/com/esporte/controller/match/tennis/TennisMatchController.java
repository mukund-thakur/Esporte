package com.esporte.controller.match.tennis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.match.tennis.TennisMatchService;
import com.esporte.common.exception.UserWithEmailAlreadyExistsException;
import com.esporte.common.exception.UserWithPhoneAlreadyExistsException;
import com.esporte.model.Request.TennisMatchCreateRequest;
import com.esporte.model.Request.TennisMatchUpdateRequest;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.match.tennis.TennisMatch;
import com.esporte.model.user.User;

@Controller
@RequestMapping( value="/match/tennis")
public class TennisMatchController {
@Autowired
private TennisMatchService tennisMatchService;


@RequestMapping(value="/create" , method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
@ResponseBody
public TennisMatch createTennisMatch(@RequestBody TennisMatchCreateRequest tennisMatchRequest) {
	
	return tennisMatchService.createMatch(tennisMatchRequest);
}

@RequestMapping(value = "/{id}" , method=RequestMethod.GET , produces="application/json")
@ResponseBody
public TennisMatch getMatchById(@PathVariable("id") long id) {
	   return tennisMatchService.getMatchById(id);
}


@RequestMapping(value = "/update" , method=RequestMethod.PUT,produces = "application/json" , consumes = "application/json")
@ResponseBody
public TennisMatch updateMatchDetails(@RequestBody TennisMatchUpdateRequest matchUpdateRequest) {
	   
	   return tennisMatchService.updateMatch(matchUpdateRequest);
}

}

