package com.example.springTradeBot.DAO;

import com.example.springTradeBot.enums.RateLimitInterval;
import com.example.springTradeBot.enums.RateLimitType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {

	private RateLimitType rateLimitType;
	private RateLimitInterval interval;
	private int intervalNum;
	private int limit;

	public RateLimitType getRateLimitType() {
		return rateLimitType;
	}

	public void setRateLimitType(RateLimitType rateLimitType) {
		this.rateLimitType = rateLimitType;
	}

	public RateLimitInterval getInterval() {
		return interval;
	}

	public void setInterval(RateLimitInterval interval) {
		this.interval = interval;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "RateLimit [rateLimitType=" + rateLimitType + ", interval=" + interval + ", intervalNum=" + intervalNum
				+ ", limit=" + limit + "]";
	}

}
