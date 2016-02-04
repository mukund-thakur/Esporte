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
	
	private Date date;
	private Time time;
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
	private int challenger_score;
	private int acceptor_score;
	
	
	private long winner_id;
	
	@Enumerated(EnumType.STRING)
	private MatchStatus match_status;
	
	
	
	
	
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
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
	public void setWinner_id(long l) {
		this.winner_id = l;
	}
	public MatchStatus getMatch_status() {
		return match_status;
	}
	public void setMatch_status(MatchStatus match_status) {
		this.match_status = match_status;
	}
	
	
	
}
