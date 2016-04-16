package com.esporte.common.exception;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String userName) {
		super("UserName " + userName + " not Found");
	}
}
