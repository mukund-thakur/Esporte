package com.esporte.model.coach;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;
import com.esporte.model.user.CoachSportsMapping;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coach_availability")
@Getter
@Setter
public class CoachAvailability extends BaseData{
	
	@Column(name="date")
	private String date;
	
	@Column(name = "start_hour")
	private long startHour;
	
	@Column(name = "end_hour")
	private long endHour;
	
	@Column(name = "initial_availability")
	private Long initialAvailability;
	
	@Column(name="current_availability")
	private Long currentAvailability;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coach_sports_mapping_id")
	private CoachSportsMapping coachSportsMapping;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL , mappedBy="coachAvailability")
	private Set<CoachBooking> coachBookings = new HashSet<CoachBooking>();
}
