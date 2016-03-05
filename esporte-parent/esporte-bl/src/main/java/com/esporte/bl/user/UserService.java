package com.esporte.bl.user;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.esporte.common.utils.DateTimeUtil;
import com.esporte.dal.interest.InterestManager;
import com.esporte.dal.mapping.PlayerSportsMappingManager;
import com.esporte.dal.sport.SportManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.AddressRequest;
import com.esporte.model.Request.SportDetailsRequest;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.Request.UserSearchRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.Email;
import com.esporte.model.user.PhoneDetails;
import com.esporte.model.user.PhoneNumber;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;
import com.esporte.model.user.Address;
import com.esporte.model.user.UserInterest;
import com.esporte.common.exception.*;

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

	public User createUser(UserRegisterRequest userRegisterRequest) throws UserWithEmailAlreadyExistsException,UserWithPhoneAlreadyExistsException {
		if ( userManager.getUserByEmail(userRegisterRequest.getEmail()) != null) {
			throw new UserWithEmailAlreadyExistsException(userRegisterRequest.getEmail());
		}
		if ( userManager.getUserByPhone(userRegisterRequest.getPhoneNumber()) != null) {
			throw new UserWithPhoneAlreadyExistsException(userRegisterRequest.getPhoneNumber());
		}
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
		Set<Address> userAddresses = new HashSet<Address>();
		for (AddressRequest address : userUpdateRequest.getAddress()) {
			Address userAddress = new Address();
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
		for ( SportDetailsRequest sportDetails : userUpdateRequest.getSports() ) {
			
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
		
		String dateString = userUpdateRequest.getDateOfBirth();
		String [] dateArray = dateString.split("-");
		int year = Integer.parseInt(dateArray[0])-1900;
		int month = Integer.parseInt(dateArray[1])-1;
		Date date = new Date(year, month, Integer.parseInt(dateArray[2]));
		userToUpdate.setDob(date);
		
		//userToUpdate.setDob(userUpdateRequest.getDateOfBirth());
		userToUpdate.setGender(userUpdateRequest.getSex().getValue());
		userToUpdate.setUserType(userUpdateRequest.getUserType());
		userToUpdate.setUserName(userUpdateRequest.getUserName());
	}

	public User getUserById(long id) {
		return userManager.getUserById(id);
	}
	
	public List<User> searchUser(UserSearchRequest userSearchRequest) {
		return userManager.userSearch(userSearchRequest);
	}

}
