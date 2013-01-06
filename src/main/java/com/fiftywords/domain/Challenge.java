package com.fiftywords.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is the first entity user creates after logging in. A user can either
 * create a new challenge or join other challenges. Challenge along with 50word
 * essays are the heart of application. Every challenge will be persisted in
 * MongoDB challenges collection. Challenge is immutable after starting. User
 * can't change the duration or anything else. User can only win the challenge
 * if he/she write 50words through out its duration. User can delete/deactivate
 * a challenge either before starting or after ending.
 * 
 * A user who creates the challenge is always the participant.
 * 
 * @author shekhargulati
 * 
 */
@Document(collection = "challenges")
public class Challenge {

	private String id;

	// the challenge title -- what this challenge is about
	@NotNull
	@Size(max = 400)
	private String challenge;

	// describe the challenge in detail.
	@NotNull
	@Size(max = 4000)
	private String challengeDescription;

	// the time at which the challenge will start. User can choose now or sometime later
	@NotNull
	private Date startAt;

	// the time at which challenge will end. This is equal to startTime + duration
	@NotNull
	private Date endAt;

	// The username of user who created the challenge
	@NotNull
	private String createdBy;

	// The usernames of all the users who are participating in the challenge. User who created the challenge is one of them.
	@NotNull
	private String[] participants;

	// the duration for which challenge will last
	@NotNull
	private Duration duration;

	// the state of the challenge
	@NotNull
	private State state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	public String getChallengeDescription() {
		return challengeDescription;
	}

	public void setChallengeDescription(String challengeDescription) {
		this.challengeDescription = challengeDescription;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String[] getParticipants() {
		return participants;
	}

	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
