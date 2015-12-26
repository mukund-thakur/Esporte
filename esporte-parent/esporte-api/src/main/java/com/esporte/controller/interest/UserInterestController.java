package com.esporte.controller.interest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.interest.InterestService;
import com.esporte.model.user.UserInterest;

@Controller
public class UserInterestController {
	
	@Autowired
	private InterestService interestService;
	
	@RequestMapping(value="/interest" ,produces="application/json")
	@ResponseBody
	public List<UserInterest> getAllInterests() {
		return interestService.getAllInterests();
	}
}
