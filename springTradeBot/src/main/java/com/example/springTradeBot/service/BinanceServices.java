package com.example.springTradeBot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.example.springTradeBot.DAO.Account;
import com.example.springTradeBot.DAO.CandleStick;
import com.example.springTradeBot.DAO.NewOrderResponse;
import com.example.springTradeBot.DAO.Order;
import com.example.springTradeBot.constants.ApplicationContants;
import com.example.springTradeBot.enums.KlineIntervals;
import com.example.springTradeBot.enums.NewOrderResponseType;
import com.example.springTradeBot.enums.Side;
import com.example.springTradeBot.enums.TimeInForce;
import com.example.springTradeBot.enums.Type;
import com.example.springTradeBot.utilities.RestUtilities;

public class BinanceServices {

	private String apiKey;
	private String secret;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public BinanceServices(String apiKey, String secret) {
		super();
		this.apiKey = apiKey;
		this.secret = secret;
		System.out.println("secret::"+secret);
	}

	@SuppressWarnings("unchecked")
	public Order getOrderStatus(String symbol, String orderId, String origClientOrderId, String newClientOrderId) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("symbol", symbol);
		if (null != orderId)
			paramsMap.put("orderId", orderId);
		if (null != origClientOrderId)
			paramsMap.put("origClientOrderId", origClientOrderId);
		if (null != newClientOrderId)
			paramsMap.put("newClientOrderId", newClientOrderId);
		paramsMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
		String url = RestUtilities.URLBuilder(paramsMap, true, secret, ApplicationContants.ORDERSTATUS_URL,
				ApplicationContants.BASE_URL);
		ResponseEntity<Order> order = (ResponseEntity<Order>) RestUtilities.processRestCall(url, Order.class, apiKey,
				HttpMethod.GET, true);
		return order.getBody();
	}

	public Account getAccountDetails() {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
		String url = RestUtilities.URLBuilder(paramsMap, true, secret, ApplicationContants.ACCOUNT_URL,
				ApplicationContants.BASE_URL);
		ResponseEntity<Account> account = (ResponseEntity<Account>) RestUtilities.processRestCall(url, Account.class,
				apiKey, HttpMethod.GET, true);
		return account.getBody();
	}

	public NewOrderResponse newOrder(String symbol, Side side, Type type, TimeInForce timeInForce, String quantity,
			String quoteOrderQty, String price, String stopPrice, NewOrderResponseType newOrderRespType) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("symbol", symbol);
		paramsMap.put("side", side.name());
		paramsMap.put("type", type.name());
		paramsMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
		if (null != quantity)
			paramsMap.put("quantity", quantity);
		paramsMap.put("newOrderRespType", newOrderRespType.name());
		if (null != timeInForce)
			paramsMap.put("timeInForce", timeInForce.name());

		if (null != quoteOrderQty)
			paramsMap.put("quoteOrderQty", quoteOrderQty);

		if (null != price)
			paramsMap.put("price", price);

		if (null != stopPrice)
			paramsMap.put("stopPrice", stopPrice);

		String url = RestUtilities.URLBuilder(paramsMap, true, secret, ApplicationContants.TRADE_URL,
				ApplicationContants.BASE_URL);

		ResponseEntity<NewOrderResponse> newOrderResponseEntity = (ResponseEntity<NewOrderResponse>) RestUtilities
				.processRestCall(url, NewOrderResponse.class, apiKey, HttpMethod.POST, true);
		return newOrderResponseEntity.getBody();
	}

}
