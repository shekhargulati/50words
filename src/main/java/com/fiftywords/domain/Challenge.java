package com.fiftywords.domain;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * This is the first entity user creates after logging in. A user can either
 * create a new challenge or join other challenges. Challenge along with 50word
 * essays are the heart of application. Every challenge will be persisted in
 * MongoDB challenges collection. Challenge is immutable after starting. User
 * can't change the duration or anything else. User can only win the challenge
 * if he/she write 50 words through out its duration. User can delete/deactivate
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
//	@Size(max = 400)
	private String challenge;

	// describe the challenge in detail.
//	@NotNull
//	@Size(max = 4000)
	private String challengeDescription;

	// the time at which the challenge will start. User can choose now or sometime later
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private Date startAt;

	// the time at which challenge will end. This is equal to startTime + duration
//	@NotNull
	private Date endAt;

	// The username of user who created the challenge
//	@NotNull
	private String createdBy;

	// The usernames of all the users who are participating in the challenge. User who created the challenge is one of them.
//	@NotNull
	private String[] participants;

	// the duration for which challenge will last
//	@NotNull
	private Duration duration;

	// the state of the challenge
//	@NotNull
	private State state;
	
	private String[] storyIds;

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

	public void setStoryIds(String[] storyIds) {
		this.storyIds = storyIds;
	}
	
	public String[] getStoryIds() {
		return storyIds;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((challenge == null) ? 0 : challenge.hashCode());
		result = prime
				* result
				+ ((challengeDescription == null) ? 0 : challengeDescription
						.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((endAt == null) ? 0 : endAt.hashCode());
		result = prime * result + Arrays.hashCode(participants);
		result = prime * result + ((startAt == null) ? 0 : startAt.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Challenge other = (Challenge) obj;
		if (challenge == null) {
			if (other.challenge != null)
				return false;
		} else if (!challenge.equals(other.challenge))
			return false;
		if (challengeDescription == null) {
			if (other.challengeDescription != null)
				return false;
		} else if (!challengeDescription.equals(other.challengeDescription))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (duration != other.duration)
			return false;
		if (endAt == null) {
			if (other.endAt != null)
				return false;
		} else if (!endAt.equals(other.endAt))
			return false;
		if (!Arrays.equals(participants, other.participants))
			return false;
		if (startAt == null) {
			if (other.startAt != null)
				return false;
		} else if (!startAt.equals(other.startAt))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

//	public String toJson() {
//		return new JSONSerializer().include("participants").include("stories").exclude("*.class")
//				.serialize(this);
//	}
//
//	public static Challenge fromJson(String json) {
//		return new JSONDeserializer<Challenge>().use(null, Challenge.class)
//				.deserialize(json);
//	}
//
//	public static String toJsonArray(Collection<Challenge> collection) {
//		return new JSONSerializer().include("participants").include("stories").exclude("*.class")
//				.serialize(collection);
//	}
//
//	public static Collection<Challenge> fromJsonArray(String json) {
//		return new JSONDeserializer<List<Challenge>>()
//				.use(null, ArrayList.class).use("participants", Challenge.class)
//				.deserialize(json);
//	}
}
