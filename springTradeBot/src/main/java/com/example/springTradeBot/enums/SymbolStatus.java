package com.example.springTradeBot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum SymbolStatus {

	PRE_TRADING,
	  TRADING,
	  POST_TRADING,
	  END_OF_DAY,
	  HALT,
	  AUCTION_MATCH,
	  BREAK;
}
