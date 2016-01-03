package com.esporte.bl.sport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.sport.SportManager;
import com.esporte.model.sport.Sport;

@Component
public class SportService {
	
	@Autowired
	private SportManager sportManager;
	
	public List<Sport> getAllSports() {
		return sportManager.getAllSports();
	}
}
