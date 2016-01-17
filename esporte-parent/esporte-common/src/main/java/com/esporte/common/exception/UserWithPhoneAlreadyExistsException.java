package com.esporte.common.exception;

public class UserWithPhoneAlreadyExistsException extends Exception{ 
	
	public UserWithPhoneAlreadyExistsException(String phone) {
		super("User with phone " + phone +" already exists");
	}

}
