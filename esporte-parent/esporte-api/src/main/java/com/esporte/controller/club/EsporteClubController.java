package com.esporte.controller.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.club.ClubService;
import com.esporte.model.Request.ClubCreateRequest;
import com.esporte.model.user.Club;

@Controller
@RequestMapping(value="/club")
public class EsporteClubController {

	@Autowired
	private ClubService clubService;
	
	@RequestMapping(value="/create",method = RequestMethod.POST,produces="application/json",consumes = "application/json")
	@ResponseBody
	public Club createClub(@RequestBody ClubCreateRequest clubCreateRequest) {
		return clubService.createClub(clubCreateRequest);
	}
}
