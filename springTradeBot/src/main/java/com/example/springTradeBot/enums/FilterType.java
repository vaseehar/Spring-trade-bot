package com.example.springTradeBot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum FilterType {
	  PRICE_FILTER,
	  LOT_SIZE,
	  MIN_NOTIONAL,
	  MAX_NUM_ORDERS,
	  MAX_ALGO_ORDERS,
	  MAX_NUM_ALGO_ORDERS,
	  ICEBERG_PARTS,
	  PERCENT_PRICE,
	  MARKET_LOT_SIZE,
	  MAX_NUM_ICEBERG_ORDERS,
	  MAX_POSITION,
	  EXCHANGE_MAX_NUM_ORDERS,
	  EXCHANGE_MAX_ALGO_ORDERS
}
