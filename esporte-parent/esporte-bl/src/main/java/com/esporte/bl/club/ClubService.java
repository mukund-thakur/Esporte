package com.esporte.bl.club;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esporte.dal.club.ClubManager;
import com.esporte.model.Request.AddressRequest;
import com.esporte.model.Request.ClubCreateRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.user.Address;
import com.esporte.model.user.Club;
import com.esporte.model.user.User;

@Component
public class ClubService {
	
	@Autowired
	private ClubManager clubManager;

	public Club createClub(ClubCreateRequest clubCreateRequest) {
		Club club =  new Club();
		club.setName(clubCreateRequest.getName());
		club.setDescription(clubCreateRequest.getDescription());
		populateClubAddressDetails(clubCreateRequest, club);
		return clubManager.createClub(club);
	}
	
	private void populateClubAddressDetails(ClubCreateRequest clubCreateRequest, Club club) {
			Address clubAddress = new Address();
			clubAddress.setCountry(clubCreateRequest.getClubAddress().getCountry());
			clubAddress.setAddress(clubCreateRequest.getClubAddress().getAddress());
			clubAddress.setAddressType(clubCreateRequest.getClubAddress().getAddressType());
			clubAddress.setCity(clubCreateRequest.getClubAddress().getCity());
			clubAddress.setCoordinates(clubCreateRequest.getClubAddress().getCoordinates());
			clubAddress.setLandmark(clubCreateRequest.getClubAddress().getLandmark());
			clubAddress.setLocality(clubCreateRequest.getClubAddress().getLocality());
			clubAddress.setState(clubCreateRequest.getClubAddress().getState());
			clubAddress.setPin(clubCreateRequest.getClubAddress().getPin());
			club.setClubAddress(clubAddress);
	}
	
}
