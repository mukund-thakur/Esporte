package com.esporte.model.Request;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachSportsDetails {

	private long sportId;
	
	private String qualification;
	
	private String experience;
	
	private String fee;
	
	private String groupFee;
	
	private long maxPlayerPerGroup;
	
	private boolean coachCanVisit;
	
	private boolean sponsered;
	
	private List<Integer> clubIds;
}
