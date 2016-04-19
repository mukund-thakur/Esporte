package com.esporte.model.user;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import com.esporte.model.Base.BaseData;
import com.esporte.model.Base.UserType;
import com.esporte.model.coach.CoachBooking;
import com.esporte.model.match.TennisMatch;
import com.esporte.model.sport.Sport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
@Getter
@Setter
public class User extends BaseData{
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private int status = 1;
	
	
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_email_mapping", joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="email_id",referencedColumnName="id")})
	private Set<Email> emailIds = new HashSet<Email>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_phone_number_mapping",
	joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="phone_number_id",referencedColumnName="id")})
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_phone_details_mapping",
	joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="phone_details_id",referencedColumnName="id")})
	private Set<PhoneDetails> phoneDetails = new HashSet<PhoneDetails>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER )
	@JoinTable(name="user_address_mapping",
	joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="address_id", referencedColumnName = "id")})
	private Set<Address> userAddresses = new HashSet<Address>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_interest_mapping",
	joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="interest_id",referencedColumnName="id")})
	private Set<UserInterest> userInterests = new HashSet<UserInterest>();
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
	private Set<PlayerSportMapping> playerSportMappings = new HashSet<PlayerSportMapping>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="challenger_id",fetch=FetchType.LAZY)
	private Set<TennisMatch> tennisMatchChallenger = new HashSet<TennisMatch>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="acceptor_id",fetch=FetchType.LAZY)
	private Set<TennisMatch> tennisMatchsAcceptor = new HashSet<TennisMatch>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="acceptor_partner_id",fetch=FetchType.LAZY)
	private Set<TennisMatch> tennisMatchAcceptorPartner = new HashSet<TennisMatch>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="challenger_partner_id",fetch=FetchType.LAZY)
	private Set<TennisMatch> tennisMatchChallengerPartner = new HashSet<TennisMatch>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="winner_id",fetch=FetchType.LAZY)
	private Set<TennisMatch> tennisMatchWinner = new HashSet<TennisMatch>();	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user", fetch = FetchType.EAGER)
	private Set<CoachSportsMapping> coachSportsMappings = new HashSet<CoachSportsMapping>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "user")
	private Set<CoachInterestMapping> coachInterestMappings  = new HashSet<CoachInterestMapping>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="player")
	private Set<CoachBooking> coachBookings =  new HashSet<CoachBooking>();
}

