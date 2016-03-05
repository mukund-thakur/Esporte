package com.esporte.model.coach;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;
import com.esporte.model.user.CoachSportsMapping;
import com.esporte.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coach_review_rating")
public class CoachReviewRating extends BaseData {
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="player_id")
	private User player;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "coach_sports_mapping_id")
	private CoachSportsMapping coachSportsMapping;
	
	@Column(name ="review")
	private String review;
	
	@Column(name ="rating")
	private Double rating;
	
}
