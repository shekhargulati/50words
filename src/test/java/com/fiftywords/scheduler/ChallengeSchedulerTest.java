package com.fiftywords.scheduler;

import static org.junit.Assert.*;

import java.util.Date;

import javax.inject.Inject;

import org.joda.time.DateTime;
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
import com.fiftywords.scheduler.tasks.EndChallengeTask;
import com.fiftywords.scheduler.tasks.StartChallengeTask;
import com.fiftywords.service.ChallengeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = ApplicationConfig.class)
public class ChallengeSchedulerTest {

	@Inject
	ChallengeScheduler challengeScheduler;
	
	@Inject
	MongoTemplate mongoTemplate;
	
	@Inject
	ChallengeService challengeService;
	
	@After
	public void cleanup(){
		mongoTemplate.dropCollection(Challenge.class);
	}
	
	@Test(timeout=180000)
	public void shouldChangeTheStateOfChallengeToStartedAndCompletedAtSpecifiedTime() throws Exception{
		Challenge challenge = newChallenge();
		challenge = challengeService.create(challenge);
		String challengeId = challenge.getId();
		StartChallengeTask startChallengeTask = new StartChallengeTask(mongoTemplate, challengeId);
		EndChallengeTask endChallengeTask = new EndChallengeTask(mongoTemplate, challengeId);
		challenge.setEndAt(new DateTime(challenge.getStartAt()).plusMinutes(1).toDate());
		challengeScheduler.scheduleChallengeTasks(challenge, startChallengeTask, endChallengeTask);
		
		while(startChallengeTask.isInvoked() == false){
			System.out.println("Start Task not invoked yet");
			Thread.sleep(10000);
		}
		System.out.println("Start task invoked...");
		assertTrue(startChallengeTask.isInvoked());
		
		Challenge readChallenge = challengeService.read(challengeId);
		assertEquals(State.STARTED, readChallenge.getState());
		
		while(endChallengeTask.isInvoked() == false){
			System.out.println("End Task not invoked yet");
			Thread.sleep(10000);
		}
		System.out.println("End task invoked...");
		assertTrue(endChallengeTask.isInvoked());
		
		readChallenge = challengeService.read(challengeId);
		assertEquals(State.COMPLETED, readChallenge.getState());
		
		
	}

	private Challenge newChallenge() {
		DateTime dateTime = new DateTime(new Date());
		dateTime = dateTime.plusMinutes(1);
		return ChallengeBuilder
				.challenge()
				.withChallenge("Should write about my morning walk every day")
				.withChallengeDescription(
						"I have started morning walk routine and would like to write down how each day went. Whether I felt motivated or demotivated etc.")
				.withCreatedBy("shekhargulati")
				.withDuration(Duration.SEVEN_DAYS).withStartAt(dateTime.toDate())
				.build();
	}
}
