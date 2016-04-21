package com.esporte.model.match;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esporte.model.Base.BaseData;
import com.esporte.model.Base.MatchStatus;
import com.esporte.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name= "tennis_match")
@AllArgsConstructor
@NoArgsConstructor
public class TennisMatch extends BaseData {
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "challenger_id")
	private User challenger_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acceptor_id")
	private User acceptor_id;
	
	private Date match_date;
	private Time match_time;
	private String venue;
	
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "challenger_partner_id")
	private User challenger_partner_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acceptor_partner_id")
	private User acceptor_partner_id;
	
	private String challenger_partner_name;
	private String acceptor_partner_name;
	private String game_type;
	private int number_of_sets;
	private String challenger_score;
	private String acceptor_score;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "winner_id")
	private User winner_id;
	
	@Enumerated(EnumType.STRING)
	private MatchStatus match_status;
	
	private double challenger_match_ranking_points;
	
	private double challenger_match_ranking_bonus_points;
	
	private double challenger_match_gain;
	
	private double challenger_match_bonus_gain;
	
	private double acceptor_match_ranking_points;
	
	private double acceptor_match_ranking_bonus_points;
	
	private double acceptor_match_gain;
	
	private double acceptor_match_bonus_gain;
	
	private double challenger_ranking_points_before_match;
	
	private double challenger_ranking_points_after_match;
	
	private double acceptor_ranking_points_before_match;
	
	private double acceptor_ranking_points_after_match;
	
	private double challenger_level_points_before_match;
	
	private double challenger_level_points_after_match;
	
	private double acceptor_level_points_before_match;
	
	private double acceptor_level_points_after_match;
	
	private long challenger_rank_before_match;
	
	private long challenger_rank_after_match;
	
	private long acceptor_rank_before_match;
	
	private long acceptor_rank_after_match;
	
	private String challenger_level_before_match;
	
	private String challenger_level_after_match;
	
	private String acceptor_level_before_match;
	
	private String acceptor_level_after_match;
	
	private double challenger_partner_match_ranking_points;
	
	private double challenger_partner_match_ranking_bonus_points;
	
	private double challenger_partner_match_gain;
	
	private double challenger_partner_match_bonus_gain;
	
	private double challenger_partner_ranking_points_before_match;
	
	private double challenger_partner_ranking_points_after_match;
	
	private double challenger_partner_level_points_before_match;
	
	private double challenger_partner_level_points_after_match;
	
	private long challenger_partner_rank_before_match;
	
	private long  challenger_partner_rank_after_match;
	
	private String challenger_partner_level_before_match;
	
	private String challenger_partner_level_after_match;
	
	private double acceptor_partner_match_ranking_points;
	
	private double acceptor_partner_match_ranking_bonus_points;
	
	private double acceptor_partner_match_gain;
	
	private double acceptor_partner_match_bonus_gain;

	private double acceptor_partner_ranking_points_before_match;
	
	private double acceptor_partner_ranking_points_after_match;
	
	private double acceptor_partner_level_points_before_match;
	
	private double acceptor_partner_level_points_after_match;
	
	private long acceptor_partner_rank_before_match;
	
	private long acceptor_partner_rank_after_match;
	
	private String acceptor_partner_level_before_match;
	
	private String acceptor_partner_level_after_match;
	
	
	
	
	
	
	
	
	
	
	
	public User getChallenger_id() {
		return challenger_id;
	}
	public void setChallenger_id(User challenger_id) {
		this.challenger_id = challenger_id;
	}
	public User getAcceptor_id() {
		return acceptor_id;
	}
	public void setAcceptor_id(User acceptor_id) {
		this.acceptor_id = acceptor_id;
	}
	public User getChallenger_partner_id() {
		return challenger_partner_id;
	}
	public void setChallenger_partner_id(User challenger_partner_id) {
		this.challenger_partner_id = challenger_partner_id;
	}
	public User getAcceptor_partner_id() {
		return acceptor_partner_id;
	}
	public void setAcceptor_partner_id(User acceptor_partner_id) {
		this.acceptor_partner_id = acceptor_partner_id;
	}
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
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
	public Date getMatch_date() {
		return match_date;
	}
	public void setMatch_date(Date match_date) {
		this.match_date = match_date;
	}
	public Time getMatch_time() {
		return match_time;
	}
	public void setMatch_time(Time match_time) {
		this.match_time = match_time;
	}
	public User getWinner_id() {
		return winner_id;
	}
	public void setWinner_id(User winner_id) {
		this.winner_id = winner_id;
	}
	public MatchStatus getMatch_status() {
		return match_status;
	}
	public void setMatch_status(MatchStatus match_status) {
		this.match_status = match_status;
	}
	public double getChallenger_match_ranking_points() {
		return challenger_match_ranking_points;
	}
	public void setChallenger_match_ranking_points(double challenger_match_ranking_points) {
		this.challenger_match_ranking_points = challenger_match_ranking_points;
	}
	public double getChallenger_match_ranking_bonus_points() {
		return challenger_match_ranking_bonus_points;
	}
	public void setChallenger_match_ranking_bonus_points(double challenger_match_ranking_bonus_points) {
		this.challenger_match_ranking_bonus_points = challenger_match_ranking_bonus_points;
	}
	public double getChallenger_match_gain() {
		return challenger_match_gain;
	}
	public void setChallenger_match_gain(double challenger_match_gain) {
		this.challenger_match_gain = challenger_match_gain;
	}
	public double getChallenger_match_bonus_gain() {
		return challenger_match_bonus_gain;
	}
	public void setChallenger_match_bonus_gain(double challenger_match_bonus_gain) {
		this.challenger_match_bonus_gain = challenger_match_bonus_gain;
	}
	public double getAcceptor_match_ranking_points() {
		return acceptor_match_ranking_points;
	}
	public void setAcceptor_match_ranking_points(double acceptor_match_ranking_points) {
		this.acceptor_match_ranking_points = acceptor_match_ranking_points;
	}
	public double getAcceptor_match_ranking_bonus_points() {
		return acceptor_match_ranking_bonus_points;
	}
	public void setAcceptor_match_ranking_bonus_points(double acceptor_match_ranking_bonus_points) {
		this.acceptor_match_ranking_bonus_points = acceptor_match_ranking_bonus_points;
	}
	public double getAcceptor_match_gain() {
		return acceptor_match_gain;
	}
	public void setAcceptor_match_gain(double acceptor_match_gain) {
		this.acceptor_match_gain = acceptor_match_gain;
	}
	public double getAcceptor_match_bonus_gain() {
		return acceptor_match_bonus_gain;
	}
	public void setAcceptor_match_bonus_gain(double acceptor_match_bonus_gain) {
		this.acceptor_match_bonus_gain = acceptor_match_bonus_gain;
	}
	public double getChallenger_ranking_points_before_match() {
		return challenger_ranking_points_before_match;
	}
	public void setChallenger_ranking_points_before_match(double challenger_ranking_points_before_match) {
		this.challenger_ranking_points_before_match = challenger_ranking_points_before_match;
	}
	public double getChallenger_ranking_points_after_match() {
		return challenger_ranking_points_after_match;
	}
	public void setChallenger_ranking_points_after_match(double challenger_ranking_points_after_match) {
		this.challenger_ranking_points_after_match = challenger_ranking_points_after_match;
	}
	public double getAcceptor_ranking_points_before_match() {
		return acceptor_ranking_points_before_match;
	}
	public void setAcceptor_ranking_points_before_match(double acceptor_ranking_points_before_match) {
		this.acceptor_ranking_points_before_match = acceptor_ranking_points_before_match;
	}
	public double getAcceptor_ranking_points_after_match() {
		return acceptor_ranking_points_after_match;
	}
	public void setAcceptor_ranking_points_after_match(double acceptor_ranking_points_after_match) {
		this.acceptor_ranking_points_after_match = acceptor_ranking_points_after_match;
	}
	public double getChallenger_level_points_before_match() {
		return challenger_level_points_before_match;
	}
	public void setChallenger_level_points_before_match(double challenger_level_points_before_match) {
		this.challenger_level_points_before_match = challenger_level_points_before_match;
	}
	public double getChallenger_level_points_after_match() {
		return challenger_level_points_after_match;
	}
	public void setChallenger_level_points_after_match(double challenger_level_points_after_match) {
		this.challenger_level_points_after_match = challenger_level_points_after_match;
	}
	public double getAcceptor_level_points_before_match() {
		return acceptor_level_points_before_match;
	}
	public void setAcceptor_level_points_before_match(double acceptor_level_points_before_match) {
		this.acceptor_level_points_before_match = acceptor_level_points_before_match;
	}
	public double getAcceptor_level_points_after_match() {
		return acceptor_level_points_after_match;
	}
	public void setAcceptor_level_points_after_match(double acceptor_level_points_after_match) {
		this.acceptor_level_points_after_match = acceptor_level_points_after_match;
	}
	public long getChallenger_rank_before_match() {
		return challenger_rank_before_match;
	}
	public void setChallenger_rank_before_match(long challenger_rank_before_match) {
		this.challenger_rank_before_match = challenger_rank_before_match;
	}
	public long getChallenger_rank_after_match() {
		return challenger_rank_after_match;
	}
	public void setChallenger_rank_after_match(long challenger_rank_after_match) {
		this.challenger_rank_after_match = challenger_rank_after_match;
	}
	public long getAcceptor_rank_before_match() {
		return acceptor_rank_before_match;
	}
	public void setAcceptor_rank_before_match(long acceptor_rank_before_match) {
		this.acceptor_rank_before_match = acceptor_rank_before_match;
	}
	public long getAcceptor_rank_after_match() {
		return acceptor_rank_after_match;
	}
	public void setAcceptor_rank_after_match(long acceptor_rank_after_match) {
		this.acceptor_rank_after_match = acceptor_rank_after_match;
	}
	public String getChallenger_level_before_match() {
		return challenger_level_before_match;
	}
	public void setChallenger_level_before_match(String challenger_level_before_match) {
		this.challenger_level_before_match = challenger_level_before_match;
	}
	public String getChallenger_level_after_match() {
		return challenger_level_after_match;
	}
	public void setChallenger_level_after_match(String challenger_level_after_match) {
		this.challenger_level_after_match = challenger_level_after_match;
	}
	public String getAcceptor_level_before_match() {
		return acceptor_level_before_match;
	}
	public void setAcceptor_level_before_match(String acceptor_level_before_match) {
		this.acceptor_level_before_match = acceptor_level_before_match;
	}
	public String getAcceptor_level_after_match() {
		return acceptor_level_after_match;
	}
	public void setAcceptor_level_after_match(String acceptor_level_after_match) {
		this.acceptor_level_after_match = acceptor_level_after_match;
	}
	public double getChallenger_partner_match_ranking_points() {
		return challenger_partner_match_ranking_points;
	}
	public void setChallenger_partner_match_ranking_points(double challenger_partner_match_ranking_points) {
		this.challenger_partner_match_ranking_points = challenger_partner_match_ranking_points;
	}
	public double getChallenger_partner_match_ranking_bonus_points() {
		return challenger_partner_match_ranking_bonus_points;
	}
	public void setChallenger_partner_match_ranking_bonus_points(double challenger_partner_match_ranking_bonus_points) {
		this.challenger_partner_match_ranking_bonus_points = challenger_partner_match_ranking_bonus_points;
	}
	public double getChallenger_partner_match_gain() {
		return challenger_partner_match_gain;
	}
	public void setChallenger_partner_match_gain(double challenger_partner_match_gain) {
		this.challenger_partner_match_gain = challenger_partner_match_gain;
	}
	public double getChallenger_partner_match_bonus_gain() {
		return challenger_partner_match_bonus_gain;
	}
	public void setChallenger_partner_match_bonus_gain(double challenger_partner_match_bonus_gain) {
		this.challenger_partner_match_bonus_gain = challenger_partner_match_bonus_gain;
	}
	public double getChallenger_partner_ranking_points_before_match() {
		return challenger_partner_ranking_points_before_match;
	}
	public void setChallenger_partner_ranking_points_before_match(double challenger_partner_ranking_points_before_match) {
		this.challenger_partner_ranking_points_before_match = challenger_partner_ranking_points_before_match;
	}
	public double getChallenger_partner_ranking_points_after_match() {
		return challenger_partner_ranking_points_after_match;
	}
	public void setChallenger_partner_ranking_points_after_match(double challenger_partner_ranking_points_after_match) {
		this.challenger_partner_ranking_points_after_match = challenger_partner_ranking_points_after_match;
	}
	public double getChallenger_partner_level_points_before_match() {
		return challenger_partner_level_points_before_match;
	}
	public void setChallenger_partner_level_points_before_match(double challenger_partner_level_points_before_match) {
		this.challenger_partner_level_points_before_match = challenger_partner_level_points_before_match;
	}
	public double getChallenger_partner_level_points_after_match() {
		return challenger_partner_level_points_after_match;
	}
	public void setChallenger_partner_level_points_after_match(double challenger_partner_level_points_after_match) {
		this.challenger_partner_level_points_after_match = challenger_partner_level_points_after_match;
	}
	public long getChallenger_partner_rank_before_match() {
		return challenger_partner_rank_before_match;
	}
	public void setChallenger_partner_rank_before_match(long challenger_partner_rank_before_match) {
		this.challenger_partner_rank_before_match = challenger_partner_rank_before_match;
	}
	public long getChallenger_partner_rank_after_match() {
		return challenger_partner_rank_after_match;
	}
	public void setChallenger_partner_rank_after_match(long challenger_partner_rank_after_match) {
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
	public double getAcceptor_partner_match_ranking_points() {
		return acceptor_partner_match_ranking_points;
	}
	public void setAcceptor_partner_match_ranking_points(double acceptor_partner_match_ranking_points) {
		this.acceptor_partner_match_ranking_points = acceptor_partner_match_ranking_points;
	}
	public double getAcceptor_partner_match_ranking_bonus_points() {
		return acceptor_partner_match_ranking_bonus_points;
	}
	public void setAcceptor_partner_match_ranking_bonus_points(double acceptor_partner_match_ranking_bonus_points) {
		this.acceptor_partner_match_ranking_bonus_points = acceptor_partner_match_ranking_bonus_points;
	}
	public double getAcceptor_partner_match_gain() {
		return acceptor_partner_match_gain;
	}
	public void setAcceptor_partner_match_gain(double acceptor_partner_match_gain) {
		this.acceptor_partner_match_gain = acceptor_partner_match_gain;
	}
	public double getAcceptor_partner_match_bonus_gain() {
		return acceptor_partner_match_bonus_gain;
	}
	public void setAcceptor_partner_match_bonus_gain(double acceptor_partner_match_bonus_gain) {
		this.acceptor_partner_match_bonus_gain = acceptor_partner_match_bonus_gain;
	}
	public double getAcceptor_partner_ranking_points_before_match() {
		return acceptor_partner_ranking_points_before_match;
	}
	public void setAcceptor_partner_ranking_points_before_match(double acceptor_partner_ranking_points_before_match) {
		this.acceptor_partner_ranking_points_before_match = acceptor_partner_ranking_points_before_match;
	}
	public double getAcceptor_partner_ranking_points_after_match() {
		return acceptor_partner_ranking_points_after_match;
	}
	public void setAcceptor_partner_ranking_points_after_match(double acceptor_partner_ranking_points_after_match) {
		this.acceptor_partner_ranking_points_after_match = acceptor_partner_ranking_points_after_match;
	}
	public double getAcceptor_partner_level_points_before_match() {
		return acceptor_partner_level_points_before_match;
	}
	public void setAcceptor_partner_level_points_before_match(double acceptor_partner_level_points_before_match) {
		this.acceptor_partner_level_points_before_match = acceptor_partner_level_points_before_match;
	}
	public double getAcceptor_partner_level_points_after_match() {
		return acceptor_partner_level_points_after_match;
	}
	public void setAcceptor_partner_level_points_after_match(double acceptor_partner_level_points_after_match) {
		this.acceptor_partner_level_points_after_match = acceptor_partner_level_points_after_match;
	}
	public long getAcceptor_partner_rank_before_match() {
		return acceptor_partner_rank_before_match;
	}
	public void setAcceptor_partner_rank_before_match(long acceptor_partner_rank_before_match) {
		this.acceptor_partner_rank_before_match = acceptor_partner_rank_before_match;
	}
	public long getAcceptor_partner_rank_after_match() {
		return acceptor_partner_rank_after_match;
	}
	public void setAcceptor_partner_rank_after_match(long acceptor_partner_rank_after_match) {
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
	
	
	
}
