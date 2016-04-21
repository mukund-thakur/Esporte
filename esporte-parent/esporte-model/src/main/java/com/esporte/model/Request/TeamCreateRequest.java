package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamCreateRequest {

	@JsonProperty
	private String name;
	
	@JsonProperty
	private Integer captain_id;
	
	@JsonProperty
	private Integer sports_id;
	
	@JsonProperty
	private String starting_level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(Integer captain_id) {
		this.captain_id = captain_id;
	}

	public Integer getSports_id() {
		return sports_id;
	}

	public void setSports_id(Integer sports_id) {
		this.sports_id = sports_id;
	}

	public String getStarting_level() {
		return starting_level;
	}

	public void setStarting_level(String starting_level) {
		this.starting_level = starting_level;
	}
	
	
}
