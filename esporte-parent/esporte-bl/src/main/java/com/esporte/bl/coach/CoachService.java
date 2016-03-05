package com.esporte.bl.coach;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.common.utils.DateTimeUtil;
import com.esporte.dal.club.ClubManager;
import com.esporte.dal.coach.CoachAvailabilityManager;
import com.esporte.dal.coach.CoachBookingManager;
import com.esporte.dal.coach.CoachManager;
import com.esporte.dal.coach.CoachReviewRatingManager;
import com.esporte.dal.interest.InterestManager;
import com.esporte.dal.mapping.CoachInterestMappingManager;
import com.esporte.dal.mapping.CoachSportsMappingManager;
import com.esporte.dal.sport.SportManager;
import com.esporte.dal.user.UserManager;
import com.esporte.model.Base.CoachBookingStatus;
import com.esporte.model.Request.AddressRequest;
import com.esporte.model.Request.CoachAvailabilityRequest;
import com.esporte.model.Request.CoachBookingRequest;
import com.esporte.model.Request.CoachInterestDetails;
import com.esporte.model.Request.CoachReviewRatingRequest;
import com.esporte.model.Request.CoachSportsDetails;
import com.esporte.model.Request.CoachUpdateRequest;
import com.esporte.model.Request.SportDetailsRequest;
import com.esporte.model.Request.UserUpdateRequest;
import com.esporte.model.coach.CoachAvailability;
import com.esporte.model.coach.CoachBooking;
import com.esporte.model.coach.CoachReviewRating;
import com.esporte.model.sport.Sport;
import com.esporte.model.user.Address;
import com.esporte.model.user.Club;
import com.esporte.model.user.CoachInterestMapping;
import com.esporte.model.user.CoachSportsMapping;
import com.esporte.model.user.PlayerSportMapping;
import com.esporte.model.user.User;

import scala.annotation.cloneable;

@Component
public class CoachService {
	
	@Autowired
	private CoachManager coachManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private SportManager sportManager;
	
	@Autowired
	private InterestManager interestManager;
	
	@Autowired
	private ClubManager clubManager;
	
	@Autowired
	private CoachSportsMappingManager coachSportsMappingManager;
	
	@Autowired
	private CoachInterestMappingManager coachInterestMappingManager;
	
	@Autowired
	private CoachAvailabilityManager coachAvailabilityManager;
	
	@Autowired
	private CoachBookingManager coachBookingManager;
	
	@Autowired
	private CoachReviewRatingManager coachReviewRatingManager;
	
	public User updateCoach(CoachUpdateRequest coachUpdateRequest) {
		User user= userManager.getUserById(coachUpdateRequest.getUserId()); 
		populateCoachAddressDetails(coachUpdateRequest,user);
		populateUserDetails(coachUpdateRequest,user);
		populateCoachSportsMapping(coachUpdateRequest,user);
		populateCoachInterestMapping(coachUpdateRequest,user);
		return coachManager.update(user);
	}
	private void populateCoachInterestMapping(CoachUpdateRequest coachUpdateRequest, User userToUpdate) {
		Set<CoachInterestMapping> coachInterestMappings = new HashSet<CoachInterestMapping>();
		for ( CoachInterestDetails coachInterestsDetails : coachUpdateRequest.getCoachInterestMappingDetails()) {
			CoachInterestMapping coachInterestMapping = coachInterestMappingManager.getCoachInterestMappingByUserIdAndInterestId(userToUpdate.getId(), coachInterestsDetails.getInterestId());
			if (  coachInterestMapping == null) {
				coachInterestMapping = new CoachInterestMapping();
			}
			coachInterestMapping.setUser(userToUpdate);
			coachInterestMapping.setInterest(interestManager.getInterestById(coachInterestsDetails.getInterestId()));
			coachInterestMapping.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
			coachInterestMapping.setExperience(coachInterestsDetails.getExperience());
			coachInterestMapping.setFee(coachInterestsDetails.getFee());
			coachInterestMapping.setGroupFee(coachInterestsDetails.getGroupFee());
			coachInterestMapping.setCoachCanVisit(coachInterestsDetails.isCoachCanVisit());
			coachInterestMapping.setQualification(coachInterestsDetails.getQualification());
			coachInterestMapping.setMaxPlayerPerGroup(coachInterestsDetails.getMaxPlayerPerGroup());
			Set<Club> clubs = new HashSet<Club>(); 
			for ( Integer id : coachInterestsDetails.getClubIds()) {
				clubs.add(clubManager.getClubById(id));
			}
			coachInterestMapping.setInterestClubs(clubs);
			coachInterestMappings.add(coachInterestMapping);
		}
		userToUpdate.setCoachInterestMappings(coachInterestMappings);
		
	}
	private void populateCoachAddressDetails(CoachUpdateRequest userUpdateRequest, User userToUpdate) {
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

	private void populateCoachSportsMapping(CoachUpdateRequest coachUpdateRequest,
			User userToUpdate) {
		
		Set<CoachSportsMapping> coachSportsMappings = new HashSet<CoachSportsMapping>();
		for ( CoachSportsDetails coachSportsDetails : coachUpdateRequest.getCoachSportsMappingDetails()) {
			CoachSportsMapping coachSportsMapping = coachSportsMappingManager.getCoachSportsMappingByUserIdAndSportsId(userToUpdate.getId(), coachSportsDetails.getSportId());
			if (  coachSportsMapping == null) {
				coachSportsMapping = new CoachSportsMapping();
			}
			coachSportsMapping.setUser(userToUpdate);
			coachSportsMapping.setSport(sportManager.getSportById(coachSportsDetails.getSportId()));
			coachSportsMapping.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
			coachSportsMapping.setExperience(coachSportsDetails.getExperience());
			coachSportsMapping.setFee(coachSportsDetails.getFee());
			coachSportsMapping.setGroupFee(coachSportsDetails.getGroupFee());
			coachSportsMapping.setCoachCanVisit(coachSportsDetails.isCoachCanVisit());
			coachSportsMapping.setQualification(coachSportsDetails.getQualification());
			coachSportsMapping.setMaxPlayerPerGroup(coachSportsDetails.getMaxPlayerPerGroup());
			Set<Club> clubs = new HashSet<Club>(); 
			for ( Integer id : coachSportsDetails.getClubIds()) {
				clubs.add(clubManager.getClubById(id));
			}
			coachSportsMapping.setCoachSportClubs(clubs);
			coachSportsMappings.add(coachSportsMapping);
		}
		userToUpdate.setCoachSportsMappings(coachSportsMappings);
		
	}

	private void populateUserDetails(CoachUpdateRequest userUpdateRequest, User userToUpdate) {
		userToUpdate.setDob(userUpdateRequest.getDateOfBirth());
		userToUpdate.setGender(userUpdateRequest.getSex().getValue());
		userToUpdate.setUserType(userUpdateRequest.getUserType());
		userToUpdate.setUserName(userUpdateRequest.getUserName());
	}
	public CoachAvailability addCoachAvailability(CoachAvailabilityRequest coachAvailibilityRequest) {
		CoachAvailability createdCoachAvailability = new CoachAvailability();
		createdCoachAvailability.setDate(coachAvailibilityRequest.getDate());
		createdCoachAvailability.setStartHour(coachAvailibilityRequest.getStartHour());
		createdCoachAvailability.setEndHour(coachAvailibilityRequest.getEndHour());
		CoachSportsMapping coachSportsMapping = coachSportsMappingManager.getCoachSportsMappingById(coachAvailibilityRequest.getCoachSportMappingId());
		createdCoachAvailability.setCoachSportsMapping(coachSportsMapping);
		Long maxPlayerPerGroup = coachSportsMapping.getMaxPlayerPerGroup();
		if ( coachSportsMapping.getGroupFee() != null) {
			createdCoachAvailability.setInitialAvailability(maxPlayerPerGroup);
			createdCoachAvailability.setCurrentAvailability(maxPlayerPerGroup);
		}
		else {
			createdCoachAvailability.setInitialAvailability(new Long(1));
			createdCoachAvailability.setCurrentAvailability(new Long(1));
		}
		return coachAvailabilityManager.create(createdCoachAvailability);
	}
	public List<User> getAllCoaches(String sportName) {
		return userManager.getAllCoach(sportName);
	}
	
	
	@Transactional
	public CoachBooking addCoachBooking(CoachBookingRequest coachBookingRequest) {
		CoachBooking coachBooking =  new CoachBooking();
		coachBooking.setAddress(coachBookingRequest.getAddress());
		coachBooking.setIsGroupBooking(coachBookingRequest.getIsGroupBooking());
		coachBooking.setIsCoachVisiting(coachBookingRequest.getIsCoachVisiting());
		coachBooking.setStatus(coachBookingRequest.getStatus());
		coachBooking.setPlayer(userManager.getUserById(coachBookingRequest.getPlayerId()));
		CoachAvailability coachAvailability =  coachAvailabilityManager.getById(coachBookingRequest.getCoachAvailabilityId());
		coachBooking.setCoachAvailability(coachAvailability);
		if(coachBooking.getIsGroupBooking() == true) {
			coachAvailability.setCurrentAvailability(coachAvailability.getCurrentAvailability() -1);
		} else {
			coachAvailability.setCurrentAvailability(new Long(0));
		}
		return coachBookingManager.create(coachBooking);
	}
	public CoachBooking updateCoachBooking(CoachBookingRequest coachBookingRequest) {
		CoachBooking coachBooking = coachBookingManager.getById(coachBookingRequest.getBookingId());
		if(coachBookingRequest.getStatus().equals(CoachBookingStatus.DECLINED)) {
			coachBooking.getCoachAvailability().setCurrentAvailability(coachBooking.getCoachAvailability().getCurrentAvailability() + 1);
		}
		coachBooking.setStatus(coachBookingRequest.getStatus());
		coachBooking.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		return  coachBookingManager.update(coachBooking);
	}
	public CoachReviewRating addReviewRating(CoachReviewRatingRequest coachReviewRatingRequest) {
		CoachReviewRating coachReviewRating = new CoachReviewRating();
		coachReviewRating.setCoachSportsMapping(coachSportsMappingManager.getCoachSportsMappingById(coachReviewRatingRequest.getCoachSportsMappingId()));
		coachReviewRating.setPlayer(userManager.getUserById(coachReviewRatingRequest.getPlayerId()));
		coachReviewRating.setRating(coachReviewRatingRequest.getRating());
		coachReviewRating.setReview(coachReviewRatingRequest.getReview());
		return coachReviewRatingManager.create(coachReviewRating);
		
	}
	
}