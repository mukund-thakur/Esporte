package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportDetails {
	
	@JsonProperty
	private long sportId;
	
	@JsonProperty
	private Integer hasVenue;
	
	@JsonProperty
	private Integer hasKit;
	
	@JsonProperty
	private Integer hasExtraKit;
	
	@JsonProperty
	private String startLevel;
	
	@JsonProperty
	private String currentLevel;
	
	@JsonProperty
	private String subLevel;
	
	@JsonProperty
	private Integer ranking;
	
	
	@JsonProperty
	private Double rankingPoints;
	
	@JsonProperty
	private Double levelPoints;
	
	 

	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}

	public Integer getHasVenue() {
		return hasVenue;
	}

	public void setHasVenue(Integer hasVenue) {
		this.hasVenue = hasVenue;
	}

	public Integer getHasKit() {
		return hasKit;
	}

	public void setHasKit(Integer hasKit) {
		this.hasKit = hasKit;
	}

	public Integer getHasExtraKit() {
		return hasExtraKit;
	}

	public void setHasExtraKit(Integer hasExtraKit) {
		this.hasExtraKit = hasExtraKit;
	}

	public String getStartLevel() {
		return startLevel;
	}

	public void setStartLevel(String startLevel) {
		this.startLevel = startLevel;
	}

	public Double getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(Double rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

	public Double getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(Double levelPoints) {
		this.levelPoints = levelPoints;
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

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	
	
}
