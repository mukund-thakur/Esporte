package com.esporte.bl.user;

import org.esporte.common.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.user.MatchManager;
import com.esporte.dal.user.UserTestManager;
import com.esporte.model.Request.CreateMatchRequest;
import com.esporte.model.user.Match;

@Component
public class MatchService {
	
	@Autowired
	private MatchManager matchManager;
	
	@Autowired
	private UserTestManager userTestManager;
	
	public Match createNewMatch(CreateMatchRequest createMatchRequest) {
		Match match = new Match();
		match.setPlayer1_id(createMatchRequest.getPlayer1Id());
		match.setPlayer2_id(createMatchRequest.getPlayer2Id());
		match.setNumberOfSets(createMatchRequest.getNumberOfSets());
		match.setPlayer1Score(createMatchRequest.getPlayer1Score());
		match.setPlayer2Score(createMatchRequest.getPlayer2Score());
		match.setStatus(createMatchRequest.getStatus());
		return matchManager.createNewMatch(match);
	}

	public Match updateMatch(CreateMatchRequest createMatchRequest) {
		Match match = matchManager.getMatchById(createMatchRequest.getId());
		match.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		match.setId(createMatchRequest.getId());
		match.setPlayer1Score(createMatchRequest.getPlayer1Score());
		match.setPlayer2Score(createMatchRequest.getPlayer2Score());
		match.setStatus(createMatchRequest.getStatus());
		return matchManager.updateMatch(match);
	}
}
