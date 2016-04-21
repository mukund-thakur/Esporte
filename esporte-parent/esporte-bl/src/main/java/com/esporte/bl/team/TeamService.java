package com.esporte.bl.team;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.common.utils.DateTimeUtil;
import com.esporte.dal.mapping.PlayerTeamMappingManager;
import com.esporte.dal.sport.SportManager;
import com.esporte.dal.team.TeamManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.PlayerTeamMappingRequest;
import com.esporte.model.Request.SportDetails;
import com.esporte.model.Request.TeamCreateRequest;
import com.esporte.model.Request.TeamUpdateRequest;
import com.esporte.model.Request.TennisMatchCreateRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.match.TennisMatch;
import com.esporte.model.sport.Sport;
import com.esporte.model.team.PlayerTeamMapping;
import com.esporte.model.team.Team;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class TeamService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private SportManager sportManager;

	@Autowired
	private TeamManager teamManager;

	@Autowired
	private PlayerTeamMappingManager playerTeamMappingManager;
	
	public Team createTeam(TeamCreateRequest teamCreate) {

		Team team = new Team();

		team.setName(teamCreate.getName());

		team.setCaptain(userManager.getUserById(teamCreate.getCaptain_id()));

		team.setSport(sportManager.getSportById(teamCreate.getSports_id()));

		team.setStart_level(teamCreate.getStarting_level());

		return teamManager.create(team);

	}

	public Team updateTeamDetails(TeamUpdateRequest teamUpdateRequest) {
		Team currentTeam = teamManager.getTeamById(teamUpdateRequest.getId());
		Team teamToUpdate = currentTeam;
		teamToUpdate.setUpdatedAt(DateTimeUtil.getCurrentDateTime());

		if (teamUpdateRequest.getName() != null && !teamUpdateRequest.getName().isEmpty())
			teamToUpdate.setName(teamUpdateRequest.getName());

		if (teamUpdateRequest.getCaptain_id() != null)
			teamToUpdate.setCaptain(userManager.getUserById(teamUpdateRequest.getCaptain_id()));

		if (teamUpdateRequest.getCurrent_level() != null && !teamUpdateRequest.getCurrent_level().isEmpty())
			teamToUpdate.setCurrent_level(teamUpdateRequest.getCurrent_level());

		if (teamUpdateRequest.getCurrent_sub_level() != null && !teamUpdateRequest.getCurrent_sub_level().isEmpty())
			teamToUpdate.setCurrent_sub_level(teamUpdateRequest.getCurrent_sub_level());

		if (teamUpdateRequest.getNumber_of_players() != null)
			teamToUpdate.setNumber_of_players(teamUpdateRequest.getNumber_of_players());

		if (teamUpdateRequest.getTeamPlayers() != null)
			populateTeamPlayerMapping(teamUpdateRequest, teamToUpdate);

		return teamManager.update(teamToUpdate);
	}

	/*
	 * private void populateTeamPlayerMapping(TeamUpdateRequest
	 * teamUpdateRequest, Team teamToUpdate) {
	 * if(teamUpdateRequest.getTeamPlayers() != null){ Set<PlayerTeamMapping>
	 * existingTeam = teamToUpdate.getPlayerTeamMappings(); if(existingTeam ==
	 * null) existingTeam = new HashSet<PlayerTeamMapping>(); if(existingTeam ==
	 * null || existingTeam.isEmpty()){ Set<PlayerTeamMapping>
	 * playerTeamMappings = new HashSet<PlayerTeamMapping>(); for (
	 * PlayerTeamMappingRequest teamPlayers : teamUpdateRequest.getTeamPlayers()
	 * ) { PlayerTeamMapping playerTeamMapping = new PlayerTeamMapping(); //Team
	 * team = teamManager.getTeamById(teamUpdateRequest.getId());
	 * if(teamPlayers.getPlayer_id()!=null)
	 * playerTeamMapping.setPlayer(userManager.getUserById(teamPlayers.
	 * getPlayer_id()));
	 * 
	 * if(teamPlayers.getTeam_id()!= null)
	 * playerTeamMapping.setTeam(teamManager.getTeamById(teamPlayers.getTeam_id(
	 * )));
	 * 
	 * if(teamPlayers.getPlayer_name()!= null &&
	 * !teamPlayers.getPlayer_name().isEmpty())
	 * playerTeamMapping.setPlayer_name(teamPlayers.getPlayer_name());
	 * 
	 * if(teamPlayers.getRole()!= null && !teamPlayers.getRole().isEmpty())
	 * playerTeamMapping.setRole(teamPlayers.getRole());
	 * 
	 * playerTeamMapping.setStatus("active");
	 * 
	 * playerTeamMappings.add(playerTeamMapping);
	 * 
	 * } teamToUpdate.setPlayerTeamMappings(playerTeamMappings); } else { for (
	 * PlayerTeamMappingRequest teamPlayer : teamUpdateRequest.getTeamPlayers()
	 * ) { if(teamPlayer.getRequest_type().equals("add")){ PlayerTeamMapping
	 * playerTeamMapping = new PlayerTeamMapping();
	 * 
	 * if(teamPlayer.getPlayer_id()!=null)
	 * playerTeamMapping.setPlayer(userManager.getUserById(teamPlayer.
	 * getPlayer_id()));
	 * 
	 * if(teamPlayer.getTeam_id()!= null)
	 * playerTeamMapping.setTeam(teamManager.getTeamById(teamPlayer.getTeam_id()
	 * ));
	 * 
	 * if(teamPlayer.getPlayer_name()!= null &&
	 * !teamPlayer.getPlayer_name().isEmpty())
	 * playerTeamMapping.setPlayer_name(teamPlayer.getPlayer_name());
	 * 
	 * if(teamPlayer.getRole()!= null && !teamPlayer.getRole().isEmpty())
	 * playerTeamMapping.setRole(teamPlayer.getRole());
	 * 
	 * playerTeamMapping.setStatus("active");
	 * 
	 * 
	 * 
	 * existingTeam.add(playerTeamMapping); } else
	 * if(teamPlayer.getRequest_type().equals("remove")){ for(PlayerTeamMapping
	 * map : existingTeam){ if(teamPlayer.getPlayer_id() == map.getId()){
	 * map.setStatus("inactive"); } } } else
	 * if(teamPlayer.getRequest_type().equals("rolechange")){
	 * for(PlayerTeamMapping map : existingTeam){ if(teamPlayer.getPlayer_id()
	 * == map.getId()){ map.setRole(teamPlayer.getRole());
	 * map.setStatus("rolechange"); } } } }
	 * teamToUpdate.setPlayerTeamMappings(existingTeam); //}
	 * 
	 * 
	 * }
	 */

	// }

	private void populateTeamPlayerMapping(TeamUpdateRequest teamUpdateRequest, Team teamToUpdate) {
		if (teamUpdateRequest.getTeamPlayers() != null) {
			Set<PlayerTeamMapping> playerTeamMappings = new HashSet<PlayerTeamMapping>();
			/*//Set<PlayerTeamMapping> existingTeam = teamToUpdate.getPlayerTeamMappings();
			if (existingTeam == null)
				existingTeam = new HashSet<PlayerTeamMapping>();*/
			for (PlayerTeamMappingRequest teamPlayer : teamUpdateRequest.getTeamPlayers()) {
				
				PlayerTeamMapping playerTeamMapping = playerTeamMappingManager.getPlayerTeamMappingByUserAndTeamId(teamPlayer.getPlayer_id(),teamPlayer.getTeam_id());
				
				if ( playerTeamMapping == null) {
					playerTeamMapping =  new PlayerTeamMapping();
				}
				
				if (teamPlayer.getRequest_type().equals("add")) {


					if (teamPlayer.getPlayer_id() != null)
						playerTeamMapping.setUser(userManager.getUserById(teamPlayer.getPlayer_id()));

					if (teamPlayer.getTeam_id() != null)
						playerTeamMapping.setTeam(teamManager.getTeamById(teamPlayer.getTeam_id()));

					if (teamPlayer.getPlayer_name() != null && !teamPlayer.getPlayer_name().isEmpty())
						playerTeamMapping.setPlayer_name(teamPlayer.getPlayer_name());

					if (teamPlayer.getRole() != null && !teamPlayer.getRole().isEmpty())
						playerTeamMapping.setRole(teamPlayer.getRole());

					playerTeamMapping.setStatus("active");

					playerTeamMappings.add(playerTeamMapping);
				}

				else if (teamPlayer.getRequest_type().equals("remove")) {
									
					
					/*for (PlayerTeamMapping map : existingTeam) {
						if (teamPlayer.getPlayer_id() == map.getId()) {
							map.setStatus("inactive");
						}
					}*/
					playerTeamMapping.setStatus("inactive");
					
					playerTeamMappings.add(playerTeamMapping);
				}

				else if (teamPlayer.getRequest_type().equals("rolechange")) {
					/*for (PlayerTeamMapping map : existingTeam) {
						if (teamPlayer.getPlayer_id() == map.getId()) {
							map.setRole(teamPlayer.getRole());
							map.setStatus("rolechange");*/
						//}
					playerTeamMapping.setRole(teamPlayer.getRole());
					playerTeamMappings.add(playerTeamMapping);
					}

				}
				
			teamToUpdate.setPlayerTeamMappings(playerTeamMappings);
			}
			
		}
	}

