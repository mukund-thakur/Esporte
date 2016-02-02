package com.esporte.model.Request;

import com.esporte.model.Base.MatchStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TennisMatchCreateRequest {
	@JsonProperty
	private long id;
	
	@JsonProperty
	private long challenger_id;
	@JsonProperty
    private long acceptor_id;
	@JsonProperty
	private String match_date;
	@JsonProperty
	private String match_time;
	@JsonProperty
	private String venue;
	@JsonProperty
	private long challenger_partner_id;
	@JsonProperty
	private long acceptor_partner_id;
	@JsonProperty
	private String challenger_partner_name;
	@JsonProperty
	private String acceptor_partner_name;
	@JsonProperty
	private String game_type;
	@JsonProperty
	private int number_of_sets;
	@JsonProperty
	private int challenger_score;
	@JsonProperty
	private int acceptor_score;
	@JsonProperty
	private long winner_id;
	@JsonProperty
	
	private MatchStatus match_status;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getChallenger_id() {
		return challenger_id;
	}
	public void setChallenger_id(long challenger_id) {
		this.challenger_id = challenger_id;
	}
	public long getAcceptor_id() {
		return acceptor_id;
	}
	public void setAcceptor_id(long acceptor_id) {
		this.acceptor_id = acceptor_id;
	}
	
	public String getMatch_date() {
		return match_date;
	}
	public String getMatch_time() {
		return match_time;
	}
	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}
	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}
	public void setMatch_status(MatchStatus match_status) {
		this.match_status = match_status;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public long getChallenger_partner_id() {
		return challenger_partner_id;
	}
	public void setChallenger_partner_id(long challenger_partner_id) {
		this.challenger_partner_id = challenger_partner_id;
	}
	public long getAcceptor_partner_id() {
		return acceptor_partner_id;
	}
	public void setAcceptor_partner_id(long acceptor_partner_id) {
		this.acceptor_partner_id = acceptor_partner_id;
	}
	public String getChallenger_partner_name() {
		return challenger_partner_name;
	}
	public void setChallenger_partner_name(String challenger_partner_name) {
		this.challenger_partner_name = challenger_partner_name;
	}
	public String getAcceptor_partner_name() {
		return acceptor_partner_name;
	}
	public void setAcceptor_partner_name(String acceptor_partner_name) {
		this.acceptor_partner_name = acceptor_partner_name;
	}
	public String getGame_type() {
		return game_type;
	}
	public void setGame_type(String game_type) {
		this.game_type = game_type;
	}
	public int getNumber_of_sets() {
		return number_of_sets;
	}
	public void setNumber_of_sets(int number_of_sets) {
		this.number_of_sets = number_of_sets;
	}
	public int getChallenger_score() {
		return challenger_score;
	}
	public void setChallenger_score(int challenger_score) {
		this.challenger_score = challenger_score;
	}
	public int getAcceptor_score() {
		return acceptor_score;
	}
	public void setAcceptor_score(int acceptor_score) {
		this.acceptor_score = acceptor_score;
	}
	public long getWinner_id() {
		return winner_id;
	}
	public void setWinner_id(long winner_id) {
		this.winner_id = winner_id;
	}
	public MatchStatus getMatch_status() {
		return match_status;
	}
	public void MatchStatus_status(MatchStatus match_status) {
		this.match_status = match_status;
	}
	
}