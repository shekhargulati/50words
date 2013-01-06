package com.fiftywords.config;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
@ContextConfiguration(classes = ApplicationConfig.class)
public class ApplicationConfigTest {
	
	@Inject
	private MongoTemplate mongoTemplate;
	
	@Inject
	private TaskScheduler taskScheduler;

	@Test
	public void shouldMakeSureThatMongoTemplateIsNotNull() {
		assertNotNull(mongoTemplate);
	}

	@Test
	public void taskSchedulerShouldNotBeNull(){
		assertNotNull(taskScheduler);
	}
}
