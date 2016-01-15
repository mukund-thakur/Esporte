package com.esporte.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;

import com.esporte.model.Base.BaseData;
import com.esporte.model.sport.Sport;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_sports_mapping" , 
uniqueConstraints = @UniqueConstraint(columnNames= {"user_id","sports_id"}))
@Getter
@Setter
public class PlayerSportMapping extends BaseData{
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sports_id")
	private Sport sport;
	
	@Column(name = "has_venue")
	private int hasVenue;
	
	@Column(name = "has_kit")
	private int hasKit;
	
	@Column(name = "has_extra_kit")
	private int hasExtraKit;
	
	@Column(name = "start_level")
	private int startLevel;
	
	@Column(name = "current_level")
	private int currentLevel;
	
	@Column(name = "ranking")
	private String ranking;
	
	@Column(name = "total_credit")
	private long totalCredit;
	
	@Column(name = "credit_remaining")
	private long creditRemaining;
	
	@Column(name="credit_used")
	private long creditUsed;
	
	@Column(name = "seeding")
	private long seeding;

	
}
