package com.esporte.bl.interest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.interest.InterestManager;
import com.esporte.model.user.UserInterest;

@Component
public class InterestService {
	
	@Autowired
	private InterestManager interestManager;
	
	public List<UserInterest> getAllInterests() {
		return interestManager.getAllInterests();
	}
}
