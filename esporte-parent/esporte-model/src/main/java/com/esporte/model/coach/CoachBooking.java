package com.esporte.model.coach;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.esporte.model.Base.BaseData;
import com.esporte.model.Base.CoachBookingStatus;
import com.esporte.model.user.User;
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
@Table(name = "coach_booking")
public class CoachBooking extends BaseData{
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "player_id")
	private User player;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "coach_availability_id")
	private CoachAvailability coachAvailability;
	
	@Column(name = "is_coach_visiting")
	private Boolean isCoachVisiting;
	
	@Column(name = "group_booking")
	private Boolean isGroupBooking;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private CoachBookingStatus status;
	
	@Column(name="address")
	private String address;

}
