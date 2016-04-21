package com.esporte.model.team;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "team")
@AllArgsConstructor
@NoArgsConstructor
public class Team extends BaseData {

	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "captain_id")
	@JsonBackReference
	private User captain;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sports_id")
	@JsonBackReference
	private Sport sport;
	
	private String start_level;
	
	private String current_level;
	
	private String current_sub_level;
	
	private double level_points;
	
	private double ranking_points;
	
	private long ranking;
	
	private int number_of_players;
	

	@OneToMany(mappedBy = "team", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<PlayerTeamMapping> playerTeamMappings = new HashSet<PlayerTeamMapping>();

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCaptain() {
		return captain;
	}

	public void setCaptain(User captain) {
		this.captain = captain;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public String getStart_level() {
		return start_level;
	}

	public void setStart_level(String start_level) {
		this.start_level = start_level;
	}

	public String getCurrent_level() {
		return current_level;
	}

	public void setCurrent_level(String current_level) {
		this.current_level = current_level;
	}

	public double getLevel_points() {
		return level_points;
	}

	public void setLevel_points(double level_points) {
		this.level_points = level_points;
	}

	public double getRanking_points() {
		return ranking_points;
	}

	public void setRanking_points(double ranking_points) {
		this.ranking_points = ranking_points;
	}

	public long getRanking() {
		return ranking;
	}

	public void setRanking(long ranking) {
		this.ranking = ranking;
	}

	public int getNumber_of_players() {
		return number_of_players;
	}

	public void setNumber_of_players(int number_of_players) {
		this.number_of_players = number_of_players;
	}

	public Set<PlayerTeamMapping> getPlayerTeamMappings() {
		return playerTeamMappings;
	}

	public void setPlayerTeamMappings(Set<PlayerTeamMapping> playerTeamMappings) {
		this.playerTeamMappings = playerTeamMappings;
	}

	public String getCurrent_sub_level() {
		return current_sub_level;
	}

	public void setCurrent_sub_level(String current_sub_level) {
		this.current_sub_level = current_sub_level;
	}
	
	
	
}
