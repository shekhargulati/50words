package com.fiftywords.service;

import com.fiftywords.domain.Story;

public interface StoryService {

	public abstract Story save(String challengeId, Story story);

}