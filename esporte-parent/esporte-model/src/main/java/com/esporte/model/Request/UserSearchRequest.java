package com.esporte.model.Request;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserSearchRequest {
	@JsonProperty
	private List<Long> sportsIds;
	
	@JsonProperty
	private List<String> location;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private double distance;
	
	@JsonProperty
	private String coordinates;
	
	@JsonProperty
	private int minAge;
	
	@JsonProperty
	private int maxAge;
	
	
	@JsonProperty
	private int minRank;
	
	@JsonProperty
	private int maxRank;
	
	@JsonProperty
	private int minSeeding;
	
	@JsonProperty
	private int maxSeeding;
	
	@JsonProperty
	private int playerWithKit;
	
	@JsonProperty
	private int playerHasExtraKit;
	
	@JsonProperty
	private int hasVenue;

	
	public List<Long> getSportsIds() {
		return sportsIds;
	}

	public void setSportsIds(List<Long> sportsIds) {
		this.sportsIds = sportsIds;
	}

	public List<String> getLocation() {
		return location;
	}

	public void setLocation(List<String> location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMinRank() {
		return minRank;
	}

	public void setMinRank(int minRank) {
		this.minRank = minRank;
	}

	public int getMaxRank() {
		return maxRank;
	}

	public void setMaxRank(int maxRank) {
		this.maxRank = maxRank;
	}

	public int getMinSeeding() {
		return minSeeding;
	}

	public void setMinSeeding(int minSeeding) {
		this.minSeeding = minSeeding;
	}

	public int getMaxSeeding() {
		return maxSeeding;
	}

	public void setMaxSeeding(int maxSeeding) {
		this.maxSeeding = maxSeeding;
	}

	public int getPlayerWithKit() {
		return playerWithKit;
	}

	public void setPlayerWithKit(int playerWithKit) {
		this.playerWithKit = playerWithKit;
	}

	public int getPlayerHasExtraKit() {
		return playerHasExtraKit;
	}

	public void setPlayerHasExtraKit(int playerHasExtraKit) {
		this.playerHasExtraKit = playerHasExtraKit;
	}

	public int getHasVenue() {
		return hasVenue;
	}

	public void setHasVenue(int hasVenue) {
		this.hasVenue = hasVenue;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
	
}
