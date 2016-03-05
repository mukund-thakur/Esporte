package com.esporte.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.groovy.reflection.handlegen;

import com.esporte.model.Base.BaseData;
import com.esporte.model.Request.CoachReviewRatingRequest;
import com.esporte.model.coach.CoachAvailability;
import com.esporte.model.coach.CoachReviewRating;
import com.esporte.model.sport.Sport;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "coach_sports_mapping",
uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","sports_id"} ))
@Getter
@Setter
public class CoachSportsMapping extends BaseData{

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sports_id")
	private Sport sport;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "fee")
	private String fee;
	
	@Column(name="group_fee")
	private String groupFee;
	
	@Column(name = "max_player_per_group")
	private Long maxPlayerPerGroup;
	
	@Column(name = "coach_can_visit")
	private boolean coachCanVisit;
	
	@Column(name = "rating")
	private double rating;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "coach_sports_club_mapping" , 
	joinColumns = {@JoinColumn(name = "coach_sports_mapping_id") } ,
	inverseJoinColumns = {@JoinColumn(name = "club_id")})
	private Set<Club> coachSportClubs = new HashSet<Club>(); 
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="coachSportsMapping")
	private Set<CoachAvailability> coachAvailabilities = new HashSet<CoachAvailability>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER , mappedBy = "coachSportsMapping")
	private Set<CoachReviewRating> coachReviewRatings = new HashSet<CoachReviewRating>();
}
