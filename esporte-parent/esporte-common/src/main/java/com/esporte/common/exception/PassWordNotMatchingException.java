package com.esporte.common.exception;

import org.hibernate.metamodel.domain.Superclass;

public class PassWordNotMatchingException extends Exception{
	public PassWordNotMatchingException(String userName) {
		super("Password for userName " + userName + " Not Matching");
	}
}
