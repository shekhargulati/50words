package com.fiftywords.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fiftywords.config.ApplicationConfig;
import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.Duration;
import com.fiftywords.domain.State;
import com.fiftywords.domain.builders.ChallengeBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = ApplicationConfig.class)
public class ChallengeServiceImplTest {

	@Inject
	private ChallengeService challengeService;
	@Inject
	private MongoTemplate mongoTemplate;
	
	@After
	public void cleanup(){
		mongoTemplate.dropCollection(Challenge.class);
	}
	
	@Test
	public void shouldCreateChallengeWhenAllTheDetailsAreEntered() {
		Challenge challenge = ChallengeBuilder
				.challenge()
				.withChallenge("Should write about my morning walk every day")
				.withChallengeDescription(
						"I have started morning walk routine and would like to write down how each day went. Whether I felt motivated or demotivated etc.")
				.withCreatedBy("shekhargulati")
				.withDuration(Duration.THIRTY_DAYS).withStartAt(new Date())
				.build();
		
		Challenge persistedChallenge = challengeService.create(challenge);
		
		assertThat(persistedChallenge.getState(), is(equalTo(State.NOT_STARTED)));
		assertArrayEquals(persistedChallenge.getParticipants(), new String[]{"shekhargulati"});
		assertNotNull(persistedChallenge.getEndAt());
	}

}
