package com.fiftywords.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;

public interface MongoConfig {

	@Bean
	public abstract MongoDbFactory mongoDbFactory() throws Exception;

}