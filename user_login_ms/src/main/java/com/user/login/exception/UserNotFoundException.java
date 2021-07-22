package com.user.login.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7623384875669234851L;

	public UserNotFoundException(String message) {
		super(message);	
	}

}
