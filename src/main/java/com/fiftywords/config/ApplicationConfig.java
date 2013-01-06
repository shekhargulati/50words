package com.fiftywords.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fiftywords.repository.ChallengeRepository;

@Configuration
@ComponentScan("com.fiftywords")
@EnableMongoRepositories(basePackageClasses = ChallengeRepository.class)
public class ApplicationConfig {

	@Inject
	MongoConfig mongoConfig;

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(
				mongoConfig.mongoDbFactory());
		return mongoTemplate;
	}
}
