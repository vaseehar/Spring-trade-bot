package com.example.springTradeBot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Status {
	 NEW,
	  PARTIALLY_FILLED,
	  FILLED,
	  CANCELED,
	  PENDING_CANCEL,
	  REJECTED,
	  EXPIRED
}
