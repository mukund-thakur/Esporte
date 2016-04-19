package com.esporte.controller.coach;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esporte.bl.coach.CoachService;
import com.esporte.model.Request.CoachAvailabilityRequest;
import com.esporte.model.Request.CoachBookingRequest;
import com.esporte.model.Request.CoachReviewRatingRequest;
import com.esporte.model.Request.CoachUpdateRequest;
import com.esporte.model.coach.CoachAvailability;
import com.esporte.model.coach.CoachBooking;
import com.esporte.model.coach.CoachReviewRating;
import com.esporte.model.user.User;

@Controller
@RequestMapping(value = "/coach")
public class EsporteCoachController {
	
	@Autowired
	private CoachService coachService;
	
	@RequestMapping(value = "/update", method=RequestMethod.PUT,consumes = "application/json",produces = "application/json")
	@ResponseBody
	public User updateCoach(@RequestBody CoachUpdateRequest coachUpdateRequest) {
		return coachService.updateCoach(coachUpdateRequest);
	}
	
	@RequestMapping(value = "/availability/create" , method=RequestMethod.POST , produces ="application/json" , consumes ="application/json")
	@ResponseBody
	public CoachAvailability addCoachAvailability(@RequestBody CoachAvailabilityRequest coachAvailibilityRequest) {
		return coachService.addCoachAvailability(coachAvailibilityRequest);
	}
	
	@RequestMapping( method=RequestMethod.GET , produces ="application/json" , consumes ="application/json")
	@ResponseBody
	public List<User> getCoaches(@RequestParam(value="sport" ,required = false)String sportName) {
		return coachService.getAllCoaches(sportName);
		
	}
	
	@RequestMapping( value = "/booking" ,method=RequestMethod.POST,produces ="application/json" , consumes ="application/json")
	@ResponseBody
	public CoachBooking addCoachBooking(@RequestBody CoachBookingRequest coachBookingRequest) {
		return coachService.addCoachBooking(coachBookingRequest);
	}
	
	@RequestMapping( value = "/booking" ,method=RequestMethod.PUT,produces ="application/json" , consumes ="application/json")
	@ResponseBody
	public CoachBooking updateCoachBooking(@RequestBody CoachBookingRequest coachBookingRequest) {
		return coachService.updateCoachBooking(coachBookingRequest);
	}
	
	@RequestMapping(value = "/review" ,method=RequestMethod.POST ,produces ="application/json" , consumes ="application/json")
	@ResponseBody
	public CoachReviewRating addCoachReviewRating(@RequestBody CoachReviewRatingRequest coachReviewRatingRequest) {
		return coachService.addReviewRating(coachReviewRatingRequest);
	}
}
