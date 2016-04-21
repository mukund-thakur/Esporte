package com.esporte.bl.match;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.bl.user.UserService;
import com.esporte.common.utils.DateTimeUtil;
import com.esporte.dal.mapping.PlayerSportsMappingManager;
import com.esporte.dal.match.TennisMatchManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.SportDetails;
import com.esporte.model.Request.TennisMatchCreateRequest;
import com.esporte.model.Request.TennisMatchUpdateRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.match.TennisMatch;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;

import antlr.collections.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class TennisMatchService {
	
	@Autowired
	private UserService userService;

	@Autowired
	private TennisMatchManager tennisMatchManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private PlayerSportsMappingManager playerSportsMappingManager;
	
	
	
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
		
		if(tennisMatch.getChallenger_partner_id()!= null)
		tennisMatch.setChallenger_partner_id(userManager.getUserById(tennisMatchCreate.getChallenger_partner_id()));
		
		if(tennisMatch.getAcceptor_partner_id()!= null)
		tennisMatch.setAcceptor_partner_id(userManager.getUserById(tennisMatchCreate.getAcceptor_partner_id()));
		
		tennisMatch.setChallenger_partner_name(tennisMatchCreate.getChallenger_partner_name());
		
		tennisMatch.setAcceptor_partner_name(tennisMatchCreate.getAcceptor_partner_name());
		
		tennisMatch.setGame_type(tennisMatchCreate.getGame_type());
		
		tennisMatch.setNumber_of_sets(tennisMatchCreate.getNumber_of_sets());


		tennisMatch.setMatch_status(tennisMatchCreate.getMatch_status());
		
		PlayerSportMapping challengerMapping = playerSportsMappingManager.getPlayerSportMappingByUserAndSportId(tennisMatchCreate.getChallenger_id(), 3);
		
		PlayerSportMapping acceptorMapping = playerSportsMappingManager.getPlayerSportMappingByUserAndSportId(tennisMatchCreate.getAcceptor_id(), 3);
		
		tennisMatch.setChallenger_ranking_points_before_match(challengerMapping.getRankingPoints());
		
		tennisMatch.setAcceptor_ranking_points_before_match(acceptorMapping.getRankingPoints());
		
		tennisMatch.setChallenger_level_points_before_match(challengerMapping.getLevelPoints());
		
		
		tennisMatch.setAcceptor_level_points_before_match(acceptorMapping.getLevelPoints());
		
		tennisMatch.setChallenger_level_before_match(challengerMapping.getCurrentLevel());
		
		tennisMatch.setAcceptor_level_before_match(acceptorMapping.getCurrentLevel());
		
		if(tennisMatchCreate.getChallenger_partner_id()!= null){
			PlayerSportMapping challengerPartnerMapping = playerSportsMappingManager.getPlayerSportMappingByUserAndSportId(tennisMatchCreate.getChallenger_partner_id(), 3);
				
			tennisMatch.setChallenger_partner_ranking_points_before_match(challengerPartnerMapping.getRankingPoints());
			
			tennisMatch.setChallenger_partner_level_points_before_match(challengerPartnerMapping.getLevelPoints());
			
			tennisMatch.setChallenger_partner_level_before_match(challengerPartnerMapping.getCurrentLevel());
			
			}
		
		if(tennisMatchCreate.getAcceptor_partner_id()!= null){
			
			PlayerSportMapping acceptorPartnerMapping = playerSportsMappingManager.getPlayerSportMappingByUserAndSportId(tennisMatchCreate.getAcceptor_partner_id(), 3);
			
			tennisMatch.setAcceptor_partner_ranking_points_before_match(acceptorPartnerMapping.getRankingPoints());
			
			tennisMatch.setAcceptor_partner_level_points_before_match(acceptorPartnerMapping.getLevelPoints());
			
			tennisMatch.setAcceptor_partner_level_before_match(acceptorPartnerMapping.getCurrentLevel());
			
			
		}
		
		return tennisMatchManager.create(tennisMatch);
		
	}
	
	public TennisMatch updateMatch(TennisMatchUpdateRequest tennisMatchUpdateRequest){
		TennisMatch currentMatch =  tennisMatchManager.getMatchById(tennisMatchUpdateRequest.getId());
		TennisMatch matchToUpdate = currentMatch;
		matchToUpdate.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		
		UserUpdateRequest challengerUpdate = new UserUpdateRequest();
		UserUpdateRequest acceptorUpdate = new UserUpdateRequest();
		UserUpdateRequest acceptorPartnerUpdate = new UserUpdateRequest();
		UserUpdateRequest challengerPartnerUpdate = new UserUpdateRequest();		
		challengerUpdate.setUserId(matchToUpdate.getChallenger_id().getId());
		
		acceptorUpdate.setUserId(matchToUpdate.getAcceptor_id().getId());
		//userUpdateRequest.setUserId(0);
		java.util.List<SportDetails> challengerSport = new ArrayList<SportDetails>();
		java.util.List<SportDetails> acceptorSport = new ArrayList<SportDetails>();
		SportDetails Csport = new SportDetails();
		SportDetails Asport = new SportDetails();
		Csport.setSportId(3);
		Asport.setSportId(3);
		
		if(matchToUpdate.getChallenger_partner_id()!= null){
			
			
			
			challengerPartnerUpdate.setUserId(matchToUpdate.getChallenger_partner_id().getId());
			
		
		}
		java.util.List<SportDetails> challengerPartnerSport = new ArrayList<SportDetails>();
		SportDetails CPsport = new SportDetails();
		CPsport.setSportId(3);
		
		if(matchToUpdate.getAcceptor_partner_id()!= null){
		
			
			
			acceptorPartnerUpdate.setUserId(matchToUpdate.getAcceptor_partner_id().getId());
			
		
		}
		
		java.util.List<SportDetails> acceptorPartnerSport = new ArrayList<SportDetails>();
		
		SportDetails APsport = new SportDetails();
		APsport.setSportId(3);

		
		//sport.setLevelPoints(tennisMatchUpdateRequest.getChallenger_level_points_after_match());
		//sports.add(sport);
		//userUpdateRequest.setSports(sports);
		
		//userService.updatePlayerDetails(userUpdateRequest);

		
		if(tennisMatchUpdateRequest.getMatch_date()!= null && !tennisMatchUpdateRequest.getMatch_date().isEmpty()){
			String dateString = tennisMatchUpdateRequest.getMatch_date();
			String [] dateArray = dateString.split("-");
			int year = Integer.parseInt(dateArray[0])-1900;
			int month = Integer.parseInt(dateArray[1])-1;
			Date date = new Date(year, month, Integer.parseInt(dateArray[2]));
			matchToUpdate.setMatch_date(date);
		
		}
		if(tennisMatchUpdateRequest.getMatch_time()!= null && !tennisMatchUpdateRequest.getMatch_time().isEmpty()){
			String timeString = tennisMatchUpdateRequest.getMatch_time();
			String [] timeArray= timeString.split(":");
			Time time = new Time(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]), Integer.parseInt( timeArray[2]));
			matchToUpdate.setMatch_time(time);
		}
		
		if(tennisMatchUpdateRequest.getVenue()!= null && !tennisMatchUpdateRequest.getVenue().isEmpty())
			matchToUpdate.setVenue(tennisMatchUpdateRequest.getVenue());
	
		if(tennisMatchUpdateRequest.getChallenger_partner_id()!= null)
			matchToUpdate.setChallenger_partner_id(userManager.getUserById(tennisMatchUpdateRequest.getChallenger_partner_id()));
		
		if(tennisMatchUpdateRequest.getAcceptor_partner_id()!= null )
			matchToUpdate.setAcceptor_partner_id(userManager.getUserById(tennisMatchUpdateRequest.getAcceptor_partner_id()));
		
		if(tennisMatchUpdateRequest.getChallenger_partner_name()!= null && !tennisMatchUpdateRequest.getChallenger_partner_name().isEmpty())
			matchToUpdate.setChallenger_partner_name(tennisMatchUpdateRequest.getChallenger_partner_name());
		
		if(tennisMatchUpdateRequest.getAcceptor_partner_name()!= null && !tennisMatchUpdateRequest.getAcceptor_partner_name().isEmpty())
			matchToUpdate.setAcceptor_partner_name(tennisMatchUpdateRequest.getAcceptor_partner_name());
		
		if(tennisMatchUpdateRequest.getGame_type()!= null && !tennisMatchUpdateRequest.getGame_type().isEmpty())
			matchToUpdate.setGame_type(tennisMatchUpdateRequest.getGame_type());
		
		if(tennisMatchUpdateRequest.getNumber_of_sets()!= null)
			matchToUpdate.setNumber_of_sets(tennisMatchUpdateRequest.getNumber_of_sets());
		
		
		if(tennisMatchUpdateRequest.getMatch_status()!=null)
			matchToUpdate.setMatch_status(tennisMatchUpdateRequest.getMatch_status());
		
		if(tennisMatchUpdateRequest.getChallenger_score()!= null && !tennisMatchUpdateRequest.getChallenger_score().isEmpty())
			matchToUpdate.setChallenger_score(tennisMatchUpdateRequest.getChallenger_score());
		
		if(tennisMatchUpdateRequest.getAcceptor_score()!= null && !tennisMatchUpdateRequest.getAcceptor_score().isEmpty())
			matchToUpdate.setAcceptor_score(tennisMatchUpdateRequest.getAcceptor_score());
		
		if(tennisMatchUpdateRequest.getWinner_id()!=null)
			matchToUpdate.setWinner_id(userManager.getUserById(tennisMatchUpdateRequest.getWinner_id()));	
		
		if(tennisMatchUpdateRequest.getChallenger_match_ranking_points()!=null)
			matchToUpdate.setChallenger_match_ranking_points(tennisMatchUpdateRequest.getChallenger_match_ranking_points());
		
		if(tennisMatchUpdateRequest.getChallenger_partner_match_ranking_points()!= null){
			
			matchToUpdate.setChallenger_partner_match_ranking_points(tennisMatchUpdateRequest.getChallenger_partner_match_ranking_points());
		}
		if(tennisMatchUpdateRequest.getChallenger_match_ranking_bonus_points()!= null)
			matchToUpdate.setChallenger_match_ranking_bonus_points(tennisMatchUpdateRequest.getChallenger_match_ranking_bonus_points());
		
		if( tennisMatchUpdateRequest.getChallenger_partner_match_ranking_bonus_points()!= null)
			matchToUpdate.setChallenger_partner_match_ranking_bonus_points(tennisMatchUpdateRequest.getChallenger_partner_match_ranking_bonus_points());
		
		if(tennisMatchUpdateRequest.getChallenger_match_gain()!= null)
			matchToUpdate.setChallenger_match_gain(tennisMatchUpdateRequest.getChallenger_match_gain());
		
		if(tennisMatchUpdateRequest.getChallenger_partner_match_gain()!= null)
			matchToUpdate.setChallenger_partner_match_gain(tennisMatchUpdateRequest.getChallenger_partner_match_gain());
		
		if(tennisMatchUpdateRequest.getChallenger_match_bonus_gain()!= null)
			matchToUpdate.setChallenger_match_bonus_gain(tennisMatchUpdateRequest.getChallenger_match_bonus_gain());
		
		if( tennisMatchUpdateRequest.getChallenger_partner_match_bonus_gain()!= null)
			matchToUpdate.setChallenger_partner_match_bonus_gain(tennisMatchUpdateRequest.getChallenger_partner_match_bonus_gain());
	

		
		if(tennisMatchUpdateRequest.getAcceptor_match_ranking_points()!= null)
			matchToUpdate.setAcceptor_match_ranking_points(tennisMatchUpdateRequest.getAcceptor_match_ranking_points());
		
		if( tennisMatchUpdateRequest.getAcceptor_partner_match_ranking_points()!= null)
			matchToUpdate.setAcceptor_partner_match_ranking_points(tennisMatchUpdateRequest.getAcceptor_partner_match_ranking_points());
			
		if(tennisMatchUpdateRequest.getAcceptor_match_ranking_bonus_points()!= null)
			matchToUpdate.setAcceptor_match_ranking_bonus_points(tennisMatchUpdateRequest.getAcceptor_match_ranking_bonus_points());
		
		if( tennisMatchUpdateRequest.getAcceptor_partner_match_ranking_bonus_points()!= null)
			matchToUpdate.setAcceptor_partner_match_ranking_bonus_points(tennisMatchUpdateRequest.getAcceptor_match_ranking_bonus_points());
			
			
		if(tennisMatchUpdateRequest.getAcceptor_match_gain()!= null)
			matchToUpdate.setAcceptor_match_gain(tennisMatchUpdateRequest.getAcceptor_match_gain());

		if( tennisMatchUpdateRequest.getAcceptor_partner_match_gain()!= null)
			matchToUpdate.setAcceptor_partner_match_gain(tennisMatchUpdateRequest.getAcceptor_partner_match_gain());
		
		
		if(tennisMatchUpdateRequest.getAcceptor_match_bonus_gain()!= null)
			matchToUpdate.setAcceptor_match_bonus_gain(tennisMatchUpdateRequest.getAcceptor_match_bonus_gain());
		
		if( tennisMatchUpdateRequest.getAcceptor_partner_match_bonus_gain()!= null)
			matchToUpdate.setAcceptor_partner_match_bonus_gain(tennisMatchUpdateRequest.getAcceptor_partner_match_bonus_gain());
		
		
		if(tennisMatchUpdateRequest.getChallenger_ranking_points_after_match()!= null){
			matchToUpdate.setChallenger_ranking_points_after_match(tennisMatchUpdateRequest.getChallenger_ranking_points_after_match());
			Csport.setRankingPoints(tennisMatchUpdateRequest.getChallenger_ranking_points_after_match());
		}
		
		if(matchToUpdate.getChallenger_partner_id()!= null && tennisMatchUpdateRequest.getChallenger_partner_ranking_points_after_match()!= null){
			matchToUpdate.setChallenger_partner_ranking_points_after_match(tennisMatchUpdateRequest.getChallenger_partner_ranking_points_after_match());
			CPsport.setRankingPoints(tennisMatchUpdateRequest.getChallenger_partner_ranking_points_after_match());
		}
		
		if(tennisMatchUpdateRequest.getAcceptor_ranking_points_after_match()!= null){
			matchToUpdate.setAcceptor_ranking_points_after_match(tennisMatchUpdateRequest.getAcceptor_ranking_points_after_match());
			Asport.setRankingPoints(tennisMatchUpdateRequest.getAcceptor_ranking_points_after_match());
		}
		
		if(matchToUpdate.getAcceptor_partner_id()!= null && tennisMatchUpdateRequest.getAcceptor_partner_ranking_points_after_match()!= null){
			
			matchToUpdate.setAcceptor_partner_ranking_points_after_match(tennisMatchUpdateRequest.getAcceptor_partner_ranking_points_after_match());
			APsport.setRankingPoints(tennisMatchUpdateRequest.getAcceptor_partner_ranking_points_after_match());
		}
		
			
		if(tennisMatchUpdateRequest.getChallenger_level_points_after_match()!= null){
			matchToUpdate.setChallenger_level_points_after_match(tennisMatchUpdateRequest.getChallenger_level_points_after_match());
			Csport.setLevelPoints(tennisMatchUpdateRequest.getChallenger_level_points_after_match());
			
		}
		
		if(matchToUpdate.getChallenger_partner_id()!= null && tennisMatchUpdateRequest.getChallenger_partner_level_points_after_match()!= null){
				
			matchToUpdate.setChallenger_partner_level_points_after_match(tennisMatchUpdateRequest.getChallenger_partner_level_points_after_match());
			CPsport.setLevelPoints(tennisMatchUpdateRequest.getChallenger_partner_level_points_after_match());
		}
		
		if(tennisMatchUpdateRequest.getAcceptor_level_points_after_match()!= null){
			matchToUpdate.setAcceptor_level_points_after_match(tennisMatchUpdateRequest.getAcceptor_level_points_after_match());
			Asport.setLevelPoints(tennisMatchUpdateRequest.getAcceptor_level_points_after_match());
		}
		
		if(matchToUpdate.getAcceptor_partner_id()!= null && tennisMatchUpdateRequest.getAcceptor_partner_level_points_after_match()!= null){
		
			matchToUpdate.setAcceptor_partner_level_points_after_match(tennisMatchUpdateRequest.getAcceptor_partner_level_points_after_match());
			APsport.setLevelPoints(tennisMatchUpdateRequest.getAcceptor_partner_level_points_after_match());
		}
		
		if(tennisMatchUpdateRequest.getChallenger_rank_after_match()!= null)
			matchToUpdate.setChallenger_rank_after_match(tennisMatchUpdateRequest.getChallenger_rank_after_match());
		
	if(matchToUpdate.getChallenger_partner_id()!= null && tennisMatchUpdateRequest.getChallenger_partner_rank_after_match()!= null)
			matchToUpdate.setChallenger_partner_rank_after_match(tennisMatchUpdateRequest.getChallenger_partner_rank_after_match());
			
		if(tennisMatchUpdateRequest.getAcceptor_rank_after_match()!= null)
			matchToUpdate.setAcceptor_rank_after_match(tennisMatchUpdateRequest.getAcceptor_rank_after_match());
		
		if(matchToUpdate.getAcceptor_partner_id()!= null && tennisMatchUpdateRequest.getAcceptor_partner_rank_after_match()!= null)
			matchToUpdate.setAcceptor_partner_rank_after_match(tennisMatchUpdateRequest.getAcceptor_partner_rank_after_match());
		

		if(tennisMatchUpdateRequest.getChallenger_level_after_match()!= null && !tennisMatchUpdateRequest.getChallenger_level_after_match().isEmpty())
			matchToUpdate.setChallenger_level_after_match(tennisMatchUpdateRequest.getChallenger_level_after_match());
		
		if(matchToUpdate.getChallenger_partner_id()!= null && tennisMatchUpdateRequest.getChallenger_partner_level_after_match()!= null && !tennisMatchUpdateRequest.getChallenger_partner_level_after_match().isEmpty())
			matchToUpdate.setChallenger_partner_level_after_match(tennisMatchUpdateRequest.getChallenger_partner_level_after_match());
		
		if(tennisMatchUpdateRequest.getAcceptor_level_after_match()!= null && !tennisMatchUpdateRequest.getAcceptor_level_after_match().isEmpty())
			matchToUpdate.setAcceptor_level_after_match(tennisMatchUpdateRequest.getAcceptor_level_after_match());
		
	if(matchToUpdate.getAcceptor_partner_id()!= null && tennisMatchUpdateRequest.getAcceptor_partner_level_after_match()!= null && !tennisMatchUpdateRequest.getAcceptor_partner_level_after_match().isEmpty())
			matchToUpdate.setAcceptor_partner_level_after_match(tennisMatchUpdateRequest.getAcceptor_partner_level_after_match());
		
	
		//write code
	
		TennisMatch updatedMatch = tennisMatchManager.update(matchToUpdate);
		
		if(tennisMatchUpdateRequest.getChallenger_ranking_points_after_match()!= null || tennisMatchUpdateRequest.getChallenger_level_points_after_match()!= null)
		{
		challengerSport.add(Csport);
		
		challengerUpdate.setSports(challengerSport);
		
		userService.updatePlayerDetails(challengerUpdate);
		
		}
		
		if(matchToUpdate.getChallenger_partner_id()!= null){
			if(tennisMatchUpdateRequest.getChallenger_partner_ranking_points_after_match()!= null || tennisMatchUpdateRequest.getChallenger_partner_level_points_after_match()!= null){
				challengerPartnerSport.add(CPsport);
				
				challengerPartnerUpdate.setSports(challengerPartnerSport);
				
				userService.updatePlayerDetails(challengerPartnerUpdate);
			}
		}
		
		if(tennisMatchUpdateRequest.getAcceptor_ranking_points_after_match()!= null || tennisMatchUpdateRequest.getAcceptor_level_points_after_match()!= null)

			{acceptorSport.add(Asport);
		
		
			acceptorUpdate.setSports(acceptorSport);
		
		
			userService.updatePlayerDetails(acceptorUpdate);
		
			}

		if(matchToUpdate.getAcceptor_partner_id()!= null){
			
			if(tennisMatchUpdateRequest.getAcceptor_partner_ranking_points_after_match()!= null || tennisMatchUpdateRequest.getAcceptor_partner_level_points_after_match()!= null){
				
				acceptorPartnerSport.add(APsport);
				
				acceptorPartnerUpdate.setSports(acceptorPartnerSport);
				
				userService.updatePlayerDetails(acceptorPartnerUpdate);
			}
		}
		
		return updatedMatch;
	}
	
	public TennisMatch getMatchById(long id) {
		return tennisMatchManager.getMatchById(id);
	}
	
}
