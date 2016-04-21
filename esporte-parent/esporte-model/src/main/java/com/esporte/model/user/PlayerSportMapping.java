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
	private String startLevel;
	
	@Column(name = "current_level")
	private String currentLevel;
	
	@Column(name = "sub_level")
	private String subLevel;
	
	@Column(name = "ranking")
	private int ranking;
	
	@Column(name = "total_credit")
	private long totalCredit;
	
	@Column(name = "credit_remaining")
	private long creditRemaining;
	
	@Column(name="credit_used")
	private long creditUsed;
	
	@Column(name= "ranking_points")
	private double rankingPoints;
	
	@Column(name="level_points")
	private double levelPoints;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public int getHasVenue() {
		return hasVenue;
	}

	public void setHasVenue(int hasVenue) {
		this.hasVenue = hasVenue;
	}

	public int getHasKit() {
		return hasKit;
	}

	public void setHasKit(int hasKit) {
		this.hasKit = hasKit;
	}

	public int getHasExtraKit() {
		return hasExtraKit;
	}

	public void setHasExtraKit(int hasExtraKit) {
		this.hasExtraKit = hasExtraKit;
	}

	public String getStartLevel() {
		return startLevel;
	}

	public void setStartLevel(String startLevel) {
		this.startLevel = startLevel;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getSubLevel() {
		return subLevel;
	}

	public void setSubLevel(String subLevel) {
		this.subLevel = subLevel;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public long getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(long totalCredit) {
		this.totalCredit = totalCredit;
	}

	public long getCreditRemaining() {
		return creditRemaining;
	
	}

	public void setCreditRemaining(long creditRemaining) {
		this.creditRemaining = creditRemaining;
	}

	public long getCreditUsed() {
		return creditUsed;
	}

	public void setCreditUsed(long creditUsed) {
		this.creditUsed = creditUsed;
	}

	public double getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(double rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

	public double getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(double levelPoints) {
		this.levelPoints = levelPoints;
	}

	
}
