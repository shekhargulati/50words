package com.fiftywords.scheduler.tasks;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.State;

/**
 * Task which marks the challenge completed.
 * 
 * @author shekhargulati
 *
 */
public class EndChallengeTask implements Runnable{

	private final MongoTemplate mongoTemplate;
	private final String challengeId;
	private boolean invoked = false;
	
	public EndChallengeTask(MongoTemplate mongoTemplate,String challengeId) {
		this.mongoTemplate = mongoTemplate;
		this.challengeId = challengeId;
	}
	
	@Override
	public void run() {
		Query query = Query.query(Criteria.where("_id").is(challengeId));
		Update update = Update.update("state", State.COMPLETED);
		mongoTemplate.updateFirst(query, update, Challenge.class);
		invoked = true;
	}
	
	public boolean isInvoked() {
		return invoked;
	}

}
