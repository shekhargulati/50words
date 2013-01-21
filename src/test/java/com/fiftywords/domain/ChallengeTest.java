package com.fiftywords.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.fiftywords.domain.builders.ChallengeBuilder;

public class ChallengeTest {

	@Test
	public void testToAndFromJson() {
		Challenge challenge = ChallengeBuilder.challenge()
				.withChallenge("test challenge")
				.withChallengeDescription("test challenge description")
				.withCreatedBy("test_user").withDuration(Duration.THIRTY_DAYS)
				.withStartAt(new Date()).withState(State.STARTED).build();
		
		challenge.setId("challengeId");
		challenge.setEndAt(new Date());
		challenge.setParticipants(new String[]{"test_user"});
		challenge.setStoryIds(new String[]{"storyId"});
		
		System.out.println(challenge.toJson());
		
		Challenge fromJsonChallenge = Challenge.fromJson(challenge.toJson());
		
		assertEquals(challenge, fromJsonChallenge);

	}

}
