package com.esporte.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;

@Entity
@Table(name="interest")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public INTEREST_TYPE getInterestType() {
		return interestType;
	}

	public void setInterestType(INTEREST_TYPE interestType) {
		this.interestType = interestType;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
