package com.esporte.model.Request;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamUpdateRequest {

	@JsonProperty
	private long id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private Long captain_id;
	
	@JsonProperty
	private String current_level;
	
	@JsonProperty
	private String current_sub_level;
	
	@JsonProperty
	private Integer number_of_players;
	
	@JsonProperty
	private Set<PlayerTeamMappingRequest> teamPlayers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(Long captain_id) {
		this.captain_id = captain_id;
	}

	public String getCurrent_level() {
		return current_level;
	}

	public void setCurrent_level(String current_level) {
		this.current_level = current_level;
	}

	public String getCurrent_sub_level() {
		return current_sub_level;
	}

	public void setCurrent_sub_level(String current_sub_level) {
		this.current_sub_level = current_sub_level;
	}

	public Integer getNumber_of_players() {
		return number_of_players;
	}

	public void setNumber_of_players(Integer number_of_players) {
		this.number_of_players = number_of_players;
	}

	public Set<PlayerTeamMappingRequest> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(Set<PlayerTeamMappingRequest> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	
	
}
