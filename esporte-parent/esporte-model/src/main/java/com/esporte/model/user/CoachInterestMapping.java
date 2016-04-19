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

import com.esporte.model.Base.BaseData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="coach_interest_mapping")
public class CoachInterestMapping extends BaseData{
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "interest_id")
	private UserInterest interest;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name ="group_fee")
	private String groupFee;
	
	@Column(name = "fee")
	private String fee;
	
	@Column(name = "max_player_per_group")
	private long maxPlayerPerGroup;
	
	@Column(name = "coach_can_visit")
	private boolean coachCanVisit;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "coach_interest_club_mapping",
	joinColumns = {@JoinColumn(name = "coach_interest_mapping_id")},
	inverseJoinColumns = {@JoinColumn(name = "club_id")})
	private Set<Club> interestClubs = new HashSet<Club>();
	
}
