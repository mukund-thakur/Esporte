package com.esporte.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMatchRequest {
	
	@JsonProperty
	private long id;
	
	
	@JsonProperty
	private long player1Id;
	
	@JsonProperty
	private long player2Id;
	
	@JsonProperty
	private long numberOfSets;
	
	@JsonProperty
	private String player1Score;
	
	@JsonProperty
	private String player2Score;
	
	@JsonProperty
	private String status;
	
}
