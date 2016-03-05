package com.esporte.model.sport;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.neo4j.cypher.internal.commands.True;

import com.esporte.model.user.CoachSportsMapping;
import com.esporte.model.user.PlayerSportMapping;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
		SINGLE,
		DOUBLE,
		TEAM
	}
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="sports_type")
	@Enumerated(EnumType.STRING)
	SPORTS_TYPE sType;
	
	@Column(name="number_teams")
	private long numberTeams;
	
	@Column(name="num_players")
	private long numberPlayers;
	
	@Column(name="description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sport", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<PlayerSportMapping> playerSportMappings = new HashSet<PlayerSportMapping>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "sport", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<CoachSportsMapping> coachSportsMappings = new HashSet<CoachSportsMapping>();
}
