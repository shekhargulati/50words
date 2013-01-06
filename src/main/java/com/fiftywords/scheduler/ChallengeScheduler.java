package com.fiftywords.scheduler;

import javax.inject.Inject;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import com.fiftywords.domain.Challenge;

@Component
public class ChallengeScheduler {

	@Inject
	private TaskScheduler taskScheduler;
	
	public void scheduleChallengeTasks(Challenge challenge,Runnable startChallengeTask,Runnable endChallengeTask){
		taskScheduler.schedule(startChallengeTask, challenge.getStartAt());
		taskScheduler.schedule(endChallengeTask, challenge.getEndAt());
	}
}
