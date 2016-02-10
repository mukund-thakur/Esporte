package com.esporte.bl.mapping;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.esporte.dal.mapping.PlayerSportsMappingManager;
import com.esporte.dal.sport.SportManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Base.BaseData;
import com.esporte.model.Request.Address;
import com.esporte.model.Request.SportDetails;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;
import com.esporte.model.user.UserAddress;

@Component
public class PlayerSportsMappingService extends BaseData{
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private PlayerSportsMappingManager playerSportsMappingManager;
	
	@Autowired
	private SportManager sportManager;
	
	
	
	public User updatePlayerDetails(UserUpdateRequest userSportMappingRequest) {
		User  userToUpdate = userManager.getUserById(userSportMappingRequest.getUserId());
		String dateString = userSportMappingRequest.getDateOfBirth();
		String [] dateArray = dateString.split("-");
		int year = Integer.parseInt(dateArray[0])-1900;
		int month = Integer.parseInt(dateArray[1])-1;
		Date date = new Date(year, month, Integer.parseInt(dateArray[2]));
		userToUpdate.setDob(date);
		//userToUpdate.setDob(userSportMappingRequest.getDateOfBirth());
		userToUpdate.setGender(userSportMappingRequest.getSex().getValue());
		userToUpdate.setUserName(userSportMappingRequest.getUserName());
		Set<PlayerSportMapping> playerSportMappings = new HashSet<PlayerSportMapping>();
		for ( SportDetails sportDetails : userSportMappingRequest.getSports() ) {
			PlayerSportMapping playerSportMapping = new PlayerSportMapping();
			Sport sport = sportManager.getSportById(sportDetails.getSportId());
			playerSportMapping.setUser(userToUpdate);
			playerSportMapping.setSport(sport);
			playerSportMapping.setHasKit(sportDetails.getHasKit());
			playerSportMapping.setHasExtraKit(sportDetails.getHasExtraKit());
			playerSportMapping.setHasVenue(sportDetails.getHasVenue());
			playerSportMappings.add(playerSportMapping);
		}
		Set<UserAddress> userAddresses = new HashSet<UserAddress>();
		for (Address address : userSportMappingRequest.getAddress()) {
			UserAddress userAddress = new UserAddress();
			userAddress.setCountry(address.getCountry());
			userAddress.setAddress(address.getAddress());
			userAddress.setAddressType(address.getAddressType());
			userAddress.setCity(address.getCity());
			userAddress.setCoordinates(address.getCoordinates());
			userAddress.setLandmark(address.getLandmark());
			userAddress.setLocality(address.getLocality());
			userAddress.setState(address.getState());
			userAddress.setPin(address.getPin());
			userAddresses.add(userAddress);
			
		}
		userToUpdate.setUserAddresses(userAddresses);
		userToUpdate.setPlayerSportMappings(playerSportMappings);
		return userManager.create(userToUpdate);
	}

}
