package com.esporte.model.sport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.neo4j.cypher.internal.commands.True;

import com.esporte.model.user.User.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sports")
@Getter
@Setter
public class Sport {
	
	@Id
	@Column(name="id", unique=true , nullable=false)
	@GeneratedValue
	private long id;
	
	public enum SPORTS_TYPE {
		TEAM,
		INDIVIDUAL
	}
	
	@Column(name="sports_type")
	@Enumerated(EnumType.STRING)
	SPORTS_TYPE sType;
	
	@Column(name="number_teams")
	private long numberTeams;
	
	@Column(name="num_players")
	private long numberPlayers;
	
	@Column(name="description")
	private String description;
}
