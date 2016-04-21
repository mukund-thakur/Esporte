package com.esporte.model.Request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.esporte.model.Base.MatchStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TennisMatchUpdateRequest {

	
	@JsonProperty
	private long id;
	
	@JsonProperty
	private String match_date;
	
	@JsonProperty
	private String match_time;
	
	@JsonProperty
	private String venue;
	
	@JsonProperty
	private Long challenger_partner_id;
	
	@JsonProperty
	private Long acceptor_partner_id;
	
	@JsonProperty
	private String challenger_partner_name;
	
	@JsonProperty
	private String acceptor_partner_name;
	
	@JsonProperty
	private String game_type;
	
	@JsonProperty
	private Integer number_of_sets;
	
	@JsonProperty
	private String challenger_score;
	
	@JsonProperty
	private String acceptor_score;
	
	@JsonProperty
	private Long winner_id;
	
	@JsonProperty
	@Enumerated(EnumType.STRING)
	private MatchStatus match_status;
	
	
	
	@JsonProperty
	private Double challenger_match_ranking_points;
	
	@JsonProperty
	private Double challenger_match_ranking_bonus_points;
	
	@JsonProperty
	private Double challenger_match_gain;
	
	@JsonProperty
	private Double challenger_match_bonus_gain;
	
	@JsonProperty
	private Double acceptor_match_ranking_points;
	
	@JsonProperty
	private Double acceptor_match_ranking_bonus_points;
	
	@JsonProperty
	private Double acceptor_match_gain;
	
	@JsonProperty
	private Double acceptor_match_bonus_gain;
	
	@JsonProperty
	private Double challenger_ranking_points_after_match;
	
	@JsonProperty
	private Double acceptor_ranking_points_after_match;
	
	@JsonProperty
	private Double challenger_level_points_after_match;
	
	@JsonProperty
	private Double acceptor_level_points_after_match;
	
	@JsonProperty
	private Long challenger_rank_after_match;
	
	@JsonProperty
	private Long acceptor_rank_after_match;
	
	@JsonProperty
	private String challenger_level_after_match;
	
	@JsonProperty
	private String acceptor_level_after_match;
	
	@JsonProperty
	private Double challenger_partner_match_ranking_points;
	
	@JsonProperty
	private Double challenger_partner_match_ranking_bonus_points;
	
	@JsonProperty
	private Double challenger_partner_match_gain;
	
	@JsonProperty
	private Double challenger_partner_match_bonus_gain;
	
	@JsonProperty
	private Double challenger_partner_ranking_points_before_match;
	
	@JsonProperty
	private Double challenger_partner_ranking_points_after_match;
	
	@JsonProperty
	private Double challenger_partner_level_points_before_match;
	
	@JsonProperty
	private Double challenger_partner_level_points_after_match;
	
	@JsonProperty
	private Long challenger_partner_rank_before_match;

	@JsonProperty
	private Long  challenger_partner_rank_after_match;
	
	@JsonProperty
	private String challenger_partner_level_before_match;
	
	@JsonProperty
	private String challenger_partner_level_after_match;
	
	@JsonProperty
	private Double acceptor_partner_match_ranking_points;
	
	@JsonProperty
	private Double acceptor_partner_match_ranking_bonus_points;
	
	@JsonProperty
	private Double acceptor_partner_match_gain;
	
	@JsonProperty
	private Double acceptor_partner_match_bonus_gain;

	@JsonProperty
	private Double acceptor_partner_ranking_points_before_match;
	
	@JsonProperty
	private Double acceptor_partner_ranking_points_after_match;
	
	@JsonProperty
	private Double acceptor_partner_level_points_before_match;
	
	@JsonProperty
	private Double acceptor_partner_level_points_after_match;
	
	@JsonProperty
	private Long acceptor_partner_rank_before_match;
	
	@JsonProperty
	private Long acceptor_partner_rank_after_match;
	
	@JsonProperty
	private String acceptor_partner_level_before_match;
	
	@JsonProperty
	private String acceptor_partner_level_after_match;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatch_date() {
		return match_date;
	}

	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}

	public String getMatch_time() {
		return match_time;
	}

	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Long getChallenger_partner_id() {
		return challenger_partner_id;
	}

	public void setChallenger_partner_id(Long challenger_partner_id) {
		this.challenger_partner_id = challenger_partner_id;
	}

	public Long getAcceptor_partner_id() {
		return acceptor_partner_id;
	}

	public void setAcceptor_partner_id(Long acceptor_partner_id) {
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

	public Integer getNumber_of_sets() {
		return number_of_sets;
	}

	public void setNumber_of_sets(Integer number_of_sets) {
		this.number_of_sets = number_of_sets;
	}

	public String getChallenger_score() {
		return challenger_score;
	}

	public void setChallenger_score(String challenger_score) {
		this.challenger_score = challenger_score;
	}

	public String getAcceptor_score() {
		return acceptor_score;
	}

	public void setAcceptor_score(String acceptor_score) {
		this.acceptor_score = acceptor_score;
	}

	public Long getWinner_id() {
		return winner_id;
	}

	public void setWinner_id(Long winner_id) {
		this.winner_id = winner_id;
	}

	public MatchStatus getMatch_status() {
		return match_status;
	}

	public void setMatch_status(MatchStatus match_status) {
		this.match_status = match_status;
	}

	public Double getChallenger_match_ranking_points() {
		return challenger_match_ranking_points;
	}

	public void setChallenger_match_ranking_points(Double challenger_match_ranking_points) {
		this.challenger_match_ranking_points = challenger_match_ranking_points;
	}

	public Double getChallenger_match_ranking_bonus_points() {
		return challenger_match_ranking_bonus_points;
	}

	public void setChallenger_match_ranking_bonus_points(Double challenger_match_ranking_bonus_points) {
		this.challenger_match_ranking_bonus_points = challenger_match_ranking_bonus_points;
	}

	public Double getChallenger_match_gain() {
		return challenger_match_gain;
	}

	public void setChallenger_match_gain(Double challenger_match_gain) {
		this.challenger_match_gain = challenger_match_gain;
	}

	public Double getChallenger_match_bonus_gain() {
		return challenger_match_bonus_gain;
	}

	public void setChallenger_match_bonus_gain(Double challenger_match_bonus_gain) {
		this.challenger_match_bonus_gain = challenger_match_bonus_gain;
	}

	public Double getAcceptor_match_ranking_points() {
		return acceptor_match_ranking_points;
	}

	public void setAcceptor_match_ranking_points(Double acceptor_match_ranking_points) {
		this.acceptor_match_ranking_points = acceptor_match_ranking_points;
	}

	public Double getAcceptor_match_ranking_bonus_points() {
		return acceptor_match_ranking_bonus_points;
	}

	public void setAcceptor_match_ranking_bonus_points(Double acceptor_match_ranking_bonus_points) {
		this.acceptor_match_ranking_bonus_points = acceptor_match_ranking_bonus_points;
	}

	public Double getAcceptor_match_gain() {
		return acceptor_match_gain;
	}

	public void setAcceptor_match_gain(Double acceptor_match_gain) {
		this.acceptor_match_gain = acceptor_match_gain;
	}

	public Double getAcceptor_match_bonus_gain() {
		return acceptor_match_bonus_gain;
	}

	public void setAcceptor_match_bonus_gain(Double acceptor_match_bonus_gain) {
		this.acceptor_match_bonus_gain = acceptor_match_bonus_gain;
	}

	public Double getChallenger_ranking_points_after_match() {
		return challenger_ranking_points_after_match;
	}

	public void setChallenger_ranking_points_after_match(Double challenger_ranking_points_after_match) {
		this.challenger_ranking_points_after_match = challenger_ranking_points_after_match;
	}

	public Double getAcceptor_ranking_points_after_match() {
		return acceptor_ranking_points_after_match;
	}

	public void setAcceptor_ranking_points_after_match(Double acceptor_ranking_points_after_match) {
		this.acceptor_ranking_points_after_match = acceptor_ranking_points_after_match;
	}

	public Double getChallenger_level_points_after_match() {
		return challenger_level_points_after_match;
	}

	public void setChallenger_level_points_after_match(Double challenger_level_points_after_match) {
		this.challenger_level_points_after_match = challenger_level_points_after_match;
	}

	public Double getAcceptor_level_points_after_match() {
		return acceptor_level_points_after_match;
	}

	public void setAcceptor_level_points_after_match(Double acceptor_level_points_after_match) {
		this.acceptor_level_points_after_match = acceptor_level_points_after_match;
	}

	public Long getChallenger_rank_after_match() {
		return challenger_rank_after_match;
	}

	public void setChallenger_rank_after_match(Long challenger_rank_after_match) {
		this.challenger_rank_after_match = challenger_rank_after_match;
	}

	public Long getAcceptor_rank_after_match() {
		return acceptor_rank_after_match;
	}

	public void setAcceptor_rank_after_match(Long acceptor_rank_after_match) {
		this.acceptor_rank_after_match = acceptor_rank_after_match;
	}

	public String getChallenger_level_after_match() {
		return challenger_level_after_match;
	}

	public void setChallenger_level_after_match(String challenger_level_after_match) {
		this.challenger_level_after_match = challenger_level_after_match;
	}

	public String getAcceptor_level_after_match() {
		return acceptor_level_after_match;
	}

	public void setAcceptor_level_after_match(String acceptor_level_after_match) {
		this.acceptor_level_after_match = acceptor_level_after_match;
	}

	public Double getChallenger_partner_match_ranking_points() {
		return challenger_partner_match_ranking_points;
	}

	public void setChallenger_partner_match_ranking_points(Double challenger_partner_match_ranking_points) {
		this.challenger_partner_match_ranking_points = challenger_partner_match_ranking_points;
	}

	public Double getChallenger_partner_match_ranking_bonus_points() {
		return challenger_partner_match_ranking_bonus_points;
	}

	public void setChallenger_partner_match_ranking_bonus_points(Double challenger_partner_match_ranking_bonus_points) {
		this.challenger_partner_match_ranking_bonus_points = challenger_partner_match_ranking_bonus_points;
	}

	public Double getChallenger_partner_match_gain() {
		return challenger_partner_match_gain;
	}

	public void setChallenger_partner_match_gain(Double challenger_partner_match_gain) {
		this.challenger_partner_match_gain = challenger_partner_match_gain;
	}

	public Double getChallenger_partner_match_bonus_gain() {
		return challenger_partner_match_bonus_gain;
	}

	public void setChallenger_partner_match_bonus_gain(Double challenger_partner_match_bonus_gain) {
		this.challenger_partner_match_bonus_gain = challenger_partner_match_bonus_gain;
	}

	public Double getChallenger_partner_ranking_points_before_match() {
		return challenger_partner_ranking_points_before_match;
	}

	public void setChallenger_partner_ranking_points_before_match(Double challenger_partner_ranking_points_before_match) {
		this.challenger_partner_ranking_points_before_match = challenger_partner_ranking_points_before_match;
	}

	public Double getChallenger_partner_ranking_points_after_match() {
		return challenger_partner_ranking_points_after_match;
	}

	public void setChallenger_partner_ranking_points_after_match(Double challenger_partner_ranking_points_after_match) {
		this.challenger_partner_ranking_points_after_match = challenger_partner_ranking_points_after_match;
	}

	public Double getChallenger_partner_level_points_before_match() {
		return challenger_partner_level_points_before_match;
	}

	public void setChallenger_partner_level_points_before_match(Double challenger_partner_level_points_before_match) {
		this.challenger_partner_level_points_before_match = challenger_partner_level_points_before_match;
	}

	public Double getChallenger_partner_level_points_after_match() {
		return challenger_partner_level_points_after_match;
	}

	public void setChallenger_partner_level_points_after_match(Double challenger_partner_level_points_after_match) {
		this.challenger_partner_level_points_after_match = challenger_partner_level_points_after_match;
	}

	public Long getChallenger_partner_rank_before_match() {
		return challenger_partner_rank_before_match;
	}

	public void setChallenger_partner_rank_before_match(Long challenger_partner_rank_before_match) {
		this.challenger_partner_rank_before_match = challenger_partner_rank_before_match;
	}

	public Long getChallenger_partner_rank_after_match() {
		return challenger_partner_rank_after_match;
	}

	public void setChallenger_partner_rank_after_match(Long challenger_partner_rank_after_match) {
		this.challenger_partner_rank_after_match = challenger_partner_rank_after_match;
	}

	public String getChallenger_partner_level_before_match() {
		return challenger_partner_level_before_match;
	}

	public void setChallenger_partner_level_before_match(String challenger_partner_level_before_match) {
		this.challenger_partner_level_before_match = challenger_partner_level_before_match;
	}

	public String getChallenger_partner_level_after_match() {
		return challenger_partner_level_after_match;
	}

	public void setChallenger_partner_level_after_match(String challenger_partner_level_after_match) {
		this.challenger_partner_level_after_match = challenger_partner_level_after_match;
	}

	public Double getAcceptor_partner_match_ranking_points() {
		return acceptor_partner_match_ranking_points;
	}

	public void setAcceptor_partner_match_ranking_points(Double acceptor_partner_match_ranking_points) {
		this.acceptor_partner_match_ranking_points = acceptor_partner_match_ranking_points;
	}

	public Double getAcceptor_partner_match_ranking_bonus_points() {
		return acceptor_partner_match_ranking_bonus_points;
	}

	public void setAcceptor_partner_match_ranking_bonus_points(Double acceptor_partner_match_ranking_bonus_points) {
		this.acceptor_partner_match_ranking_bonus_points = acceptor_partner_match_ranking_bonus_points;
	}

	public Double getAcceptor_partner_match_gain() {
		return acceptor_partner_match_gain;
	}

	public void setAcceptor_partner_match_gain(Double acceptor_partner_match_gain) {
		this.acceptor_partner_match_gain = acceptor_partner_match_gain;
	}

	public Double getAcceptor_partner_match_bonus_gain() {
		return acceptor_partner_match_bonus_gain;
	}

	public void setAcceptor_partner_match_bonus_gain(Double acceptor_partner_match_bonus_gain) {
		this.acceptor_partner_match_bonus_gain = acceptor_partner_match_bonus_gain;
	}

	public Double getAcceptor_partner_ranking_points_before_match() {
		return acceptor_partner_ranking_points_before_match;
	}

	public void setAcceptor_partner_ranking_points_before_match(Double acceptor_partner_ranking_points_before_match) {
		this.acceptor_partner_ranking_points_before_match = acceptor_partner_ranking_points_before_match;
	}

	public Double getAcceptor_partner_ranking_points_after_match() {
		return acceptor_partner_ranking_points_after_match;
	}

	public void setAcceptor_partner_ranking_points_after_match(Double acceptor_partner_ranking_points_after_match) {
		this.acceptor_partner_ranking_points_after_match = acceptor_partner_ranking_points_after_match;
	}

	public Double getAcceptor_partner_level_points_before_match() {
		return acceptor_partner_level_points_before_match;
	}

	public void setAcceptor_partner_level_points_before_match(Double acceptor_partner_level_points_before_match) {
		this.acceptor_partner_level_points_before_match = acceptor_partner_level_points_before_match;
	}

	public Double getAcceptor_partner_level_points_after_match() {
		return acceptor_partner_level_points_after_match;
	}

	public void setAcceptor_partner_level_points_after_match(Double acceptor_partner_level_points_after_match) {
		this.acceptor_partner_level_points_after_match = acceptor_partner_level_points_after_match;
	}

	public Long getAcceptor_partner_rank_before_match() {
		return acceptor_partner_rank_before_match;
	}

	public void setAcceptor_partner_rank_before_match(Long acceptor_partner_rank_before_match) {
		this.acceptor_partner_rank_before_match = acceptor_partner_rank_before_match;
	}

	public Long getAcceptor_partner_rank_after_match() {
		return acceptor_partner_rank_after_match;
	}

	public void setAcceptor_partner_rank_after_match(Long acceptor_partner_rank_after_match) {
		this.acceptor_partner_rank_after_match = acceptor_partner_rank_after_match;
	}

	public String getAcceptor_partner_level_before_match() {
		return acceptor_partner_level_before_match;
	}

	public void setAcceptor_partner_level_before_match(String acceptor_partner_level_before_match) {
		this.acceptor_partner_level_before_match = acceptor_partner_level_before_match;
	}

	public String getAcceptor_partner_level_after_match() {
		return acceptor_partner_level_after_match;
	}

	public void setAcceptor_partner_level_after_match(String acceptor_partner_level_after_match) {
		this.acceptor_partner_level_after_match = acceptor_partner_level_after_match;
	}

	/*public void setId(Long id) {
		this.id = id;
	}
	*/
	
	
	
	
}
