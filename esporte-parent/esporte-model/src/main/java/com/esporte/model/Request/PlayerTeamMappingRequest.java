package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerTeamMappingRequest {

	
	
	@JsonProperty
	private Long player_id;
	
	@JsonProperty
	private String player_name;
	
	@JsonProperty
	private Long team_id;
	
	@JsonProperty
	private String role;

	@JsonProperty
	private String request_type;
	
	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}
	
}
