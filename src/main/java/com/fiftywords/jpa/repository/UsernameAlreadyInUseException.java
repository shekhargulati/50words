package com.fiftywords.jpa.repository;

public class UsernameAlreadyInUseException extends Exception {
	
	private static final long serialVersionUID = 954582508045511977L;

	public UsernameAlreadyInUseException(String username) {
		super("The username '" + username + "' is already in use.");
	}
}
