package com.esporte.bl.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.esporte.common.utils.DateTimeUtil;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.esporte.dal.user.UserManager;
import com.esporte.model.Request.UserRegisterRequest;
import com.esporte.model.user.Email;
import com.esporte.model.user.PhoneDetails;
import com.esporte.model.user.PhoneNumber;
import com.esporte.model.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserService {
	
	@Autowired
	private UserManager userManager;
	
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
		user.setCreatedAt(DateTimeUtil.getCurrentDateTime());
		user.setUpdatedAt(DateTimeUtil.getCurrentDateTime());
		return userManager.create(user);
	}
	

}
