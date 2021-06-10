package com.example.springTradeBot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.BeanDefinition;

@Configuration
public class UserOperationsConfiguration {

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public UserOperations createUserOperations(String userId, String apiKey, String secret) {
		return new UserOperations(userId, apiKey, secret);

	}
}
