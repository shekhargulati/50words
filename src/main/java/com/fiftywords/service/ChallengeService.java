package com.fiftywords.service;

import com.fiftywords.domain.Challenge;

public interface ChallengeService {

	public Challenge create(Challenge challenge);
	
	public Challenge update(Challenge challenge);
	
	public void delete(Challenge challenge);
	
	public Challenge read(String challengeId);
	
	public void start(String challengId);
	
}
