package com.esporte.model.user;

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
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="interest")
@Getter
@Setter
public class UserInterest {
	
	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public enum INTEREST_TYPE {
		SPORTING,
		NON_SPORTING
	}
	
	@Column(name="interest_type")
	@Enumerated(EnumType.STRING)
	INTEREST_TYPE interestType;
	
	@Column(name="score")
	private long score;
	
	@Column(name="priority")
	private long priority;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , fetch =FetchType.LAZY , mappedBy = "interest")
	private Set<CoachInterestMapping> coachInterestMappings = new HashSet<CoachInterestMapping>();
}
