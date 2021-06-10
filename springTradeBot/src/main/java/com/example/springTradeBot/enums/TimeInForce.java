package com.example.springTradeBot.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TimeInForce {
  GTC,
  IOC,
  FOK
}
