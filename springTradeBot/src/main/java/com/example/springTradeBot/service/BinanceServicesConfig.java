package com.example.springTradeBot.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BinanceServicesConfig {

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public BinanceServices createBinanceServices(String apiKey, String secret) {
		return new BinanceServices(apiKey, secret);

	}
}
