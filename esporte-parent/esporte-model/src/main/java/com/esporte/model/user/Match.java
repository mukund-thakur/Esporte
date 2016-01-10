package com.esporte.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scala.util.parsing.combinator.testing.Str;

@Entity
@Table(name = "match_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match extends BaseData{
		

	@Column(name="player1_id")
	private long player1_id;
	
	@Column(name="player2_id")
	private long player2_id;
	
	@Column(name="number_of_sets")
	private long numberOfSets;
	
	@Column(name="player1_score")
	private String player1Score;
	
	@Column(name="player2_score")
	private String player2Score;
	
	@Column(name="status")
	private String status;
}
