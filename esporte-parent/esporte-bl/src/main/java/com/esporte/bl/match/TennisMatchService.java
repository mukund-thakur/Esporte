package com.esporte.bl.match;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.common.utils.DateTimeUtil;
import com.esporte.dal.match.TennisMatchManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.TennisMatchCreateRequest;
import com.esporte.model.Request.TennisMatchUpdateRequest;
import com.esporte.model.match.TennisMatch;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class TennisMatchService {

	@Autowired
	private TennisMatchManager tennisMatchManager;
	
	@Autowired
	private UserManager userManager;
	
	
	
	public TennisMatch createMatch(TennisMatchCreateRequest tennisMatchCreate){
		
		TennisMatch tennisMatch = new TennisMatch();
		tennisMatch.setChallenger_id(userManager.getUserById(tennisMatchCreate.getChallenger_id()));
		tennisMatch.setAcceptor_id(userManager.getUserById(tennisMatchCreate.getAcceptor_id()));
		String dateString = tennisMatchCreate.getMatch_date();
		String [] dateArray = dateString.split("-");
		int year = Integer.parseInt(dateArray[0])-1900;
		int month = Integer.parseInt(dateArray[1])-1;
		Date date = new Date(year, month, Integer.parseInt(dateArray[2]));
		tennisMatch.setMatch_date(date);
		
		String timeString = tennisMatchCreate.getMatch_time();
		String [] timeArray= timeString.split(":");
		Time time = new Time(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]), Integer.parseInt( timeArray[2]));
		tennisMatch.setMatch_time(time);
		tennisMatch.setVenue(tennisMatchCreate.getVenue());
		tennisMatch.setChallenger_partner_id(userManager.getUserById(tennisMatchCreate.getChallenger_partner_id()));
		tennisMatch.setAcceptor_partner_id(userManager.getUserById(tennisMatchCreate.getAcceptor_partner_id()));
		tennisMatch.setChallenger_partner_name(tennisMatchCreate.getChallenger_partner_name());
		tennisMatch.setAcceptor_partner_name(tennisMatchCreate.getAcceptor_partner_name());
		tennisMatch.setGame_type(tennisMatchCreate.getGame_type());
		tennisMatch.setNumber_of_sets(tennisMatchCreate.getNumber_of_sets());
		//tennisMatch.setChallenger_score(tennisMatchCreate.getChallenger_score());
		//tennisMatch.setAcceptor_score(tennisMatchCreate.getAcceptor_score());
		//tennisMatch.setWinner_id(userManager.getUserById(tennisMatchCreate.getWinner_id()));
		tennisMatch.setMatch_status(tennisMatchCreate.getMatch_status());
		
		return tennisMatchManager.create(tennisMatch);
		
	}
	
	public TennisMatch updateMatch(TennisMatchUpdateRequest tennisMatchUpdateRequest){
		TennisMatch currentMatch =  tennisMatchManager.getMatchById(tennisMatchUpdateRequest.getId());
		TennisMatch matchToUpdate = currentMatch;
		matchToUpdate.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		
		String dateString = tennisMatchUpdateRequest.getMatch_date();
		String [] dateArray = dateString.split("-");
		int year = Integer.parseInt(dateArray[0])-1900;
		int month = Integer.parseInt(dateArray[1])-1;
		Date date = new Date(year, month, Integer.parseInt(dateArray[2]));
		matchToUpdate.setMatch_date(date);
		
		String timeString = tennisMatchUpdateRequest.getMatch_time();
		String [] timeArray= timeString.split(":");
		Time time = new Time(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]), Integer.parseInt( timeArray[2]));
		matchToUpdate.setMatch_time(time);
		
		matchToUpdate.setVenue(tennisMatchUpdateRequest.getVenue());
		
		matchToUpdate.setChallenger_partner_id(userManager.getUserById(tennisMatchUpdateRequest.getChallenger_partner_id()));
		matchToUpdate.setAcceptor_partner_id(userManager.getUserById(tennisMatchUpdateRequest.getAcceptor_partner_id()));
		matchToUpdate.setChallenger_partner_name(tennisMatchUpdateRequest.getChallenger_partner_name());
		matchToUpdate.setAcceptor_partner_name(tennisMatchUpdateRequest.getAcceptor_partner_name());
		matchToUpdate.setGame_type(tennisMatchUpdateRequest.getGame_type());
		matchToUpdate.setNumber_of_sets(tennisMatchUpdateRequest.getNumber_of_sets());
		matchToUpdate.setMatch_status(tennisMatchUpdateRequest.getMatch_status());
		matchToUpdate.setChallenger_score(tennisMatchUpdateRequest.getChallenger_score());
		matchToUpdate.setAcceptor_score(tennisMatchUpdateRequest.getAcceptor_score());
		matchToUpdate.setWinner_id(userManager.getUserById(tennisMatchUpdateRequest.getWinner_id()));		
		
		return tennisMatchManager.update(matchToUpdate);

		
	}
	
	public TennisMatch getMatchById(long id) {
		return tennisMatchManager.getMatchById(id);
	}
	
}
