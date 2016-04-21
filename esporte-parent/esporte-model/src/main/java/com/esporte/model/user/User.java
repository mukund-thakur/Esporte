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
import com.esporte.model.match.TennisMatch;
import com.esporte.model.sport.Sport;
import com.esporte.model.team.PlayerTeamMapping;
import com.esporte.model.team.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import scala.util.parsing.combinator.testing.Str;;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})

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
	@JsonManagedReference
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
	private Set<UserAddress> userAddresses = new HashSet<UserAddress>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_interest_mapping",
	joinColumns = {@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns = {@JoinColumn(name="interest_id",referencedColumnName="id")})
	private Set<UserInterest> userInterests = new HashSet<UserInterest>();
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
	private Set<PlayerSportMapping> playerSportMappings = new HashSet<PlayerSportMapping>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user",fetch=FetchType.EAGER)
	private Set<PlayerTeamMapping> playerTeamMappings = new HashSet<PlayerTeamMapping>();

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
	
	/*@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="captain",fetch=FetchType.LAZY)
	private Set<Team> teamCaptain = new HashSet<Team>();*/
	
	
	
	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	

	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public Set<Email> getEmailIds() {
		return emailIds;
	}


	public void setEmailIds(Set<Email> emailIds) {
		this.emailIds = emailIds;
	}


	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}


	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	public Set<PhoneDetails> getPhoneDetails() {
		return phoneDetails;
	}


	public void setPhoneDetails(Set<PhoneDetails> phoneDetails) {
		this.phoneDetails = phoneDetails;
	}


	public Set<UserAddress> getUserAddresses() {
		return userAddresses;
	}


	public void setUserAddresses(Set<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}


	public Set<UserInterest> getUserInterests() {
		return userInterests;
	}


	public void setUserInterests(Set<UserInterest> userInterests) {
		this.userInterests = userInterests;
	}


	public Set<PlayerSportMapping> getPlayerSportMappings() {
		return playerSportMappings;
	}


	public void setPlayerSportMappings(Set<PlayerSportMapping> playerSportMappings) {
		this.playerSportMappings = playerSportMappings;
	}


	public Set<TennisMatch> getTennisMatchChallenger() {
		return tennisMatchChallenger;
	}


	public void setTennisMatchChallenger(Set<TennisMatch> tennisMatchChallenger) {
		this.tennisMatchChallenger = tennisMatchChallenger;
	}


	public Set<TennisMatch> getTennisMatchsAcceptor() {
		return tennisMatchsAcceptor;
	}


	public void setTennisMatchsAcceptor(Set<TennisMatch> tennisMatchsAcceptor) {
		this.tennisMatchsAcceptor = tennisMatchsAcceptor;
	}


	public Set<TennisMatch> getTennisMatchAcceptorPartner() {
		return tennisMatchAcceptorPartner;
	}


	public void setTennisMatchAcceptorPartner(Set<TennisMatch> tennisMatchAcceptorPartner) {
		this.tennisMatchAcceptorPartner = tennisMatchAcceptorPartner;
	}


	public Set<TennisMatch> getTennisMatchChallengerPartner() {
		return tennisMatchChallengerPartner;
	}


	public void setTennisMatchChallengerPartner(Set<TennisMatch> tennisMatchChallengerPartner) {
		this.tennisMatchChallengerPartner = tennisMatchChallengerPartner;
	}


	public Set<TennisMatch> getTennisMatchWinner() {
		return tennisMatchWinner;
	}


	public void setTennisMatchWinner(Set<TennisMatch> tennisMatchWinner) {
		this.tennisMatchWinner = tennisMatchWinner;
	}


	public Set<PlayerTeamMapping> getPlayerTeamMappings() {
		return playerTeamMappings;
	}


	public void setPlayerTeamMappings(Set<PlayerTeamMapping> playerTeamMappings) {
		this.playerTeamMappings = playerTeamMappings;
	}


	/*public Set<Team> getTeamCaptain() {
		return teamCaptain;
	}


	public void setTeamCaptain(Set<Team> teamCaptain) {
		this.teamCaptain = teamCaptain;
	}*/
	
	
}

