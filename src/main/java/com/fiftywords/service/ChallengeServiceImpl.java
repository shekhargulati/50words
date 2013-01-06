package com.fiftywords.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.State;
import com.fiftywords.repository.ChallengeRepository;
import com.fiftywords.utils.DateUtils;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Inject
	private ChallengeRepository challengeRepository;
	
	@Override
	public Challenge create(Challenge challenge) {
		challenge.setState(State.NOT_STARTED);
		challenge.setParticipants(new String[]{challenge.getCreatedBy()});
		challenge.setEndAt(DateUtils.addDays(challenge.getStartAt(), challenge.getDuration().getDays()));
		return challengeRepository.save(challenge);
	}

	@Override
	public Challenge update(Challenge challenge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Challenge challenge) {
		// TODO Auto-generated method stub

	}

	@Override
	public Challenge read(String challengeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(String challengId) {
		// TODO Auto-generated method stub

	}

}
