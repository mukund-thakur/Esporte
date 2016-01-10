package org.esporte.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistsException(String email) {
		super("Email " + email + " already exists");
	}
}
