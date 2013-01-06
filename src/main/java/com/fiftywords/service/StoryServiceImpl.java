package com.fiftywords.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fiftywords.domain.Story;
import com.fiftywords.repository.StoryRepository;

@Service
public class StoryServiceImpl implements StoryService {

	@Inject
	private StoryRepository storyRepository;
	
	/* (non-Javadoc)
	 * @see com.fiftywords.service.StoryService#save(java.lang.String, com.fiftywords.domain.Story)
	 */
	@Override
	public Story save(String challengeId, Story story){
		story.setChallengeId(challengeId);
		story.setCreatedOn(new Date());
		return storyRepository.save(story); 
	}
}
