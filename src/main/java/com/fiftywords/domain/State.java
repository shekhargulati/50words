package com.fiftywords.domain;

/**
 * The state of challenge.
 * 
 * Challenge is NOT_STARTED when the challenge startAt time has not reached.
 * 
 * Challenge is STARTED when the challenge startAt time has reached but challenge is not completed
 * 
 * Challenge is COMPLETED when either of two conditions are met -- the endAt time has reached or all the participants have lost
 * @author shekhargulati
 *
 */
public enum State {

	NOT_STARTED("Challenge has not yet started"), STARTED("Challenge has started"), COMPLETED("Challege has completed");

	private String message;

	State(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
