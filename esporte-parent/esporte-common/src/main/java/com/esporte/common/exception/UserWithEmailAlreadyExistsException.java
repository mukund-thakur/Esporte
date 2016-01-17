package com.esporte.common.exception;

public class UserWithEmailAlreadyExistsException extends Exception {
	
    public UserWithEmailAlreadyExistsException(String email) {
		super("User with email " +email + " already exists");
	}
}
