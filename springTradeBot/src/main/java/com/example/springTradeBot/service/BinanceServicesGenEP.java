package com.example.springTradeBot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.springTradeBot.DAO.CandleStick;
import com.example.springTradeBot.DAO.ExchangeInfo;
import com.example.springTradeBot.constants.ApplicationContants;
import com.example.springTradeBot.enums.KlineIntervals;
import com.example.springTradeBot.utilities.RestUtilities;

@Component
public class BinanceServicesGenEP {

	public CandleStick[] getCandleSticks(String symbol, KlineIntervals interval) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("symbol", symbol);
		String strInterval = interval.getInterval();
		paramsMap.put("interval", strInterval);
		String url = RestUtilities.URLBuilder(paramsMap, false, "", ApplicationContants.KLINES_URL,
				ApplicationContants.BASE_URL_API);

		ResponseEntity<CandleStick[]> candleStickEntity = (ResponseEntity<CandleStick[]>) RestUtilities
				.processRestCall(url, CandleStick[].class, "", HttpMethod.GET, false);

		return candleStickEntity.getBody();
	}

	public  ExchangeInfo getExchangeInfo() {
		String url = ApplicationContants.BASE_URL + ApplicationContants.EXCHANGE_INFO;
		ResponseEntity<ExchangeInfo> exchangeInfoEntity = (ResponseEntity<ExchangeInfo>) RestUtilities.processRestCall(url, ExchangeInfo.class, "", HttpMethod.GET, false);
		return exchangeInfoEntity.getBody();
	}
}
