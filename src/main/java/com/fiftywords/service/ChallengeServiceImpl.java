package com.fiftywords.service;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.State;
import com.fiftywords.repository.ChallengeRepository;
import com.fiftywords.utils.DateUtils;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Inject
	private ChallengeRepository challengeRepository;
	
	@Inject
	private MongoTemplate mongoTemplate;
	
	@Override
	public Challenge create(Challenge challenge) {
		challenge.setState(State.NOT_STARTED);
		challenge.setParticipants(new String[] { challenge.getCreatedBy() });
		if (challenge.getStartAt() != null && challenge.getDuration() != null) {
			
			challenge.setEndAt(DateUtils.addDays(challenge.getStartAt(),
					challenge.getDuration().getDays()));
		
		}
		return challengeRepository.save(challenge);
	}

	@Override
	public void addParticipantsToChallenge(String challengeId,
			String[] participants) {
		Query query = Query.query(Criteria.where("_id").is(challengeId));
		Update update = new Update();
		update.pushAll("participants", participants);
		mongoTemplate.updateFirst(query, update, Challenge.class);
	}

	@Override
	public Challenge update(Challenge challenge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Challenge challenge) {
		challengeRepository.delete(challenge);
	}

	@Override
	public Challenge read(String challengeId) {
		return challengeRepository.findOne(challengeId);
	}

	@Override
	public void addStoryToChallenge(String challengeId, String storyId) {
		Query query = Query.query(Criteria.where("_id").is(challengeId));
		Update update = new Update();
		update.push("stories", storyId);
		mongoTemplate.updateFirst(query, update, Challenge.class);
	}

}
