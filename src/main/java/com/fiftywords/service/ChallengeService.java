package com.fiftywords.service;

import com.fiftywords.domain.Challenge;

public interface ChallengeService {

	public Challenge create(Challenge challenge);
	
	public Challenge update(Challenge challenge);
	
	public void delete(Challenge challenge);
	
	public Challenge read(String challengeId);
	
	void addParticipantsToChallenge(String challengeId, String[] participants);

	void addStoryToChallenge(String challengeId,String storyId);
	
	void scheduleTasks(Challenge challenge);
}
