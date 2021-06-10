package com.example.springTradeBot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitType {
	REQUEST_WEIGHT, ORDERS
}
