package com.example.springTradeBot.DAO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {

	private String timezone;
	private Long serverTime;
	private List<RateLimit> rateLimits;
	private List<Symbol> symbols;

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Long getServerTime() {
		return serverTime;
	}

	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}

	public List<RateLimit> getRateLimits() {
		return rateLimits;
	}

	public void setRateLimits(List<RateLimit> rateLimits) {
		this.rateLimits = rateLimits;
	}

	public List<Symbol> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	public Symbol getSymbol(String symbol) {
		for (Symbol symbolObj : symbols) {
			if (symbolObj.getSymbol().equals(symbol)) {
				return symbolObj;
			}
		}
		return null;

	}

	@Override
	public String toString() {
		return "ExchangeInfo [timezone=" + timezone + ", serverTime=" + serverTime + ", rateLimits=" + rateLimits
				+ ", symbols=" + symbols + "]";
	}
}
