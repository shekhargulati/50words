package com.fiftywords.domain;

import java.util.Date;

/**
 * A builder to create {@link Story}
 * 
 * @author shekhargulati
 *
 */
public class StoryBuilder extends StoryBuilderBase<StoryBuilder> {
	public static StoryBuilder story() {
		return new StoryBuilder();
	}

	public StoryBuilder() {
		super(new Story());
	}

	public Story build() {
		return getInstance();
	}
}

class StoryBuilderBase<GeneratorT extends StoryBuilderBase<GeneratorT>> {
	private Story instance;

	protected StoryBuilderBase(Story aInstance) {
		instance = aInstance;
	}

	protected Story getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withTitle(String aValue) {
		instance.setTitle(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withText(String aValue) {
		instance.setText(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withCreatedOn(Date aValue) {
		instance.setCreatedOn(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withAuthor(String aValue) {
		instance.setAuthor(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withTags(String[] aValue) {
		instance.setTags(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withChallengeId(String aValue) {
		instance.setChallengeId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withLocation(double[] aValue) {
		instance.setLocation(aValue);

		return (GeneratorT) this;
	}
}
