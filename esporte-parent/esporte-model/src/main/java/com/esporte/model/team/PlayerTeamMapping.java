package com.esporte.model.team;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.esporte.model.Base.BaseData;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "player_team_mapping")
public class PlayerTeamMapping extends BaseData {

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="player_id")
	
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="team_id")
	@JsonIgnore
	private Team team;
	
	private String player_name;
	
	private String role;
	
	
	private String status;

	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
