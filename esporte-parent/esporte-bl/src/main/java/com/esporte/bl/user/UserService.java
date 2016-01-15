package com.esporte.bl.user;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.esporte.common.utils.DateTimeUtil;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.esporte.dal.interest.InterestManager;
import com.esporte.dal.mapping.PlayerSportsMappingManager;
import com.esporte.dal.sport.SportManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.Address;
import com.esporte.model.Request.SportDetails;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.Email;
import com.esporte.model.user.PhoneDetails;
import com.esporte.model.user.PhoneNumber;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;
import com.esporte.model.user.UserAddress;
import com.esporte.model.user.UserInterest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserService {
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private SportManager sportManager;
	
	@Autowired
	private InterestManager interestManager;
	
	@Autowired
	private PlayerSportsMappingManager playerSportsMappingManager;
	
	public List<User> getAllUsers() {
		return userManager.getAllUsers();
	}

	public User createUser(UserRegisterRequest userRegisterRequest) {
		User user = new User();
		user.setName(userRegisterRequest.getName());
		user.setPassword(userRegisterRequest.getPassWord());
		user.setStatus(1);
		Email email = new Email();
		email.setEmail(userRegisterRequest.getEmail());
		Set<Email> allEmails = new HashSet<Email>();
		allEmails.add(email);
		user.setEmailIds(allEmails);
		Set<PhoneNumber> phoneNumbers=new HashSet<PhoneNumber>();
		PhoneNumber phoneNumber =new PhoneNumber();
		phoneNumber.setNumber(userRegisterRequest.getPhoneNumber());
		phoneNumbers.add(phoneNumber);
		user.setPhoneNumbers(phoneNumbers);
		PhoneDetails phoneDetails = new PhoneDetails();
		phoneDetails.setGcmId(userRegisterRequest.getGcmId());
		phoneDetails.setImeiCode(userRegisterRequest.getGcmId());
		Set<PhoneDetails> allPhoneDetails = new HashSet<PhoneDetails>();
		allPhoneDetails.add(phoneDetails);
		user.setPhoneDetails(allPhoneDetails);
		return userManager.create(user);
	}

	public User getUserByName(String userName) {
		return userManager.getUserByName(userName);
	}

	public User updatePlayerDetails(UserUpdateRequest userUpdateRequest) {
		User currentUser =  userManager.getUserById(userUpdateRequest.getUserId());
		User  userToUpdate = currentUser;
		userToUpdate.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		populateUserDetails(userUpdateRequest, userToUpdate);
		populatePlayerSportsMapping(userUpdateRequest,userToUpdate);
		populatePlayerAddressDetails(userUpdateRequest, userToUpdate);
		populatePlayerInterestDetails(userUpdateRequest,userToUpdate);
		return userManager.update(userToUpdate);
	}

	private void populatePlayerInterestDetails(UserUpdateRequest userUpdateRequest, User userToUpdate) {
		Set<UserInterest> userInterests = new HashSet<UserInterest>();
		for(long interestId :  userUpdateRequest.getInterestIds()) {
			userInterests.add(interestManager.getInterestById(interestId));
		}
		userToUpdate.setUserInterests(userInterests);
	}

	private void populatePlayerAddressDetails(UserUpdateRequest userUpdateRequest, User userToUpdate) {
		Set<UserAddress> userAddresses = new HashSet<UserAddress>();
		for (Address address : userUpdateRequest.getAddress()) {
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
	}

	private void populatePlayerSportsMapping(UserUpdateRequest userUpdateRequest,
			User userToUpdate) {
		Set<PlayerSportMapping> playerSportMappings = new HashSet<PlayerSportMapping>();
		for ( SportDetails sportDetails : userUpdateRequest.getSports() ) {
			
			PlayerSportMapping playerSportMapping = playerSportsMappingManager.getPlayerSportMappingByUserAndSportId(userToUpdate.getId(),sportDetails.getSportId());
			if ( playerSportMapping == null) {
				playerSportMapping =  new PlayerSportMapping();
			}
			Sport sport = sportManager.getSportById(sportDetails.getSportId());
			playerSportMapping.setUser(userToUpdate);
			playerSportMapping.setSport(sport);
			playerSportMapping.setHasKit(sportDetails.getHasKit());
			playerSportMapping.setHasExtraKit(sportDetails.getHasExtraKit());
			playerSportMapping.setHasVenue(sportDetails.getHasVenue());
			playerSportMappings.add(playerSportMapping);
		}
		userToUpdate.setPlayerSportMappings(playerSportMappings);
	}

	private void populateUserDetails(UserUpdateRequest userUpdateRequest, User userToUpdate) {
		userToUpdate.setDob(userUpdateRequest.getDateOfBirth());
		userToUpdate.setGender(userUpdateRequest.getSex().getValue());
		userToUpdate.setUserType(userUpdateRequest.getUserType());
		userToUpdate.setUserName(userUpdateRequest.getUserName());
	}

	public User getUserById(long id) {
		return userManager.getUserById(id);
	}

}
