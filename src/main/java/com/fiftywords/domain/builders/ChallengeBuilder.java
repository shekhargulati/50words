package com.fiftywords.domain.builders;

import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.Duration;
import com.fiftywords.domain.State;
import java.util.Date;
/**
 * A builder for creating challenges.
 * 
 * @author shekhargulati
 *
 */
public class ChallengeBuilder extends ChallengeBuilderBase<ChallengeBuilder> {
	public static ChallengeBuilder challenge() {
		return new ChallengeBuilder();
	}

	public ChallengeBuilder() {
		super(new Challenge());
	}

	public Challenge build() {
		return getInstance();
	}
}

class ChallengeBuilderBase<GeneratorT extends ChallengeBuilderBase<GeneratorT>> {
	private Challenge instance;

	protected ChallengeBuilderBase(Challenge aInstance) {
		instance = aInstance;
	}

	protected Challenge getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withChallenge(String aValue) {
		instance.setChallenge(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withChallengeDescription(String aValue) {
		instance.setChallengeDescription(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withStartAt(Date aValue) {
		instance.setStartAt(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withCreatedBy(String aValue) {
		instance.setCreatedBy(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDuration(Duration aValue) {
		instance.setDuration(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withState(State aValue) {
		instance.setState(aValue);

		return (GeneratorT) this;
	}
}
