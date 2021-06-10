package com.example.springTradeBot.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springTradeBot.DAO.NewOrderResponse;
import com.example.springTradeBot.entity.TradePairs;
import com.example.springTradeBot.enums.NewOrderResponseType;
import com.example.springTradeBot.enums.Side;
import com.example.springTradeBot.enums.Type;
import com.example.springTradeBot.repository.AssetRepository;
import com.example.springTradeBot.repository.TradePairsRepository;
import com.example.springTradeBot.service.BinanceServices;
import com.example.springTradeBot.service.BinanceServicesGenEP;
import com.example.springTradeBot.utilities.OrderUtils;

public class UserOperations extends TimerTask {

	private String userId;
	private String apiKey;
	private String secret;

	public UserOperations(String userId, String apiKey, String secret) {
		super();
		this.userId = userId;
		this.apiKey = apiKey;
		this.secret = secret;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	private boolean isPairsReady = false;

	@Autowired
	TradePairsRepository tradePairsRepository;

	@Autowired
	AssetRepository assetRepository;

	List<String> symbolsList = new ArrayList<>();
	String quoteAsset;

	@Override
	public void run() {
		System.out.println("Entry::");
		while (!RSICalculator.isJobOver) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!isPairsReady) {
			Optional<TradePairs> tradePairsOptional = tradePairsRepository.findById(Integer.parseInt(userId));
			String concatenatedPairs = "";
			if (tradePairsOptional.isPresent()) {
				concatenatedPairs = tradePairsOptional.get().getTradePairs();
			}
			if (!concatenatedPairs.isBlank()) {
				String[] symbols = concatenatedPairs.split("\\|");
				symbolsList = Arrays.asList(symbols);
			}
			isPairsReady = true;
			quoteAsset = UserOpsFactory.quoteAssetMap.get(userId);
		}

		if (symbolsList.size() > 0) {
			List<String> buyList = intersectList(RSICalculator.rsiBuyList, symbolsList);
			List<String> sellList = intersectList(RSICalculator.rsiSellList, symbolsList);

			// String tradeQuantity = UserOpsFactory.tradeQtyMap.get(userId);
			BinanceServices binanceServices = new BinanceServices(apiKey, secret);

			// Buy order
			for (String symbol : buyList) {
				String quoteQtyAvailable = binanceServices.getAccountDetails().getAssetBalance(quoteAsset).getFree();
				OrderUtils orderUtils = new OrderUtils();
				if (orderUtils.isQtyGreaterThanMinNotional(quoteQtyAvailable, symbol)) {
					System.out.println("Buying for:" + quoteQtyAvailable + " " + quoteAsset);
					NewOrderResponse newOrderResponse = binanceServices.newOrder(symbol, Side.BUY, Type.MARKET, null,
							null, quoteQtyAvailable, null, null, NewOrderResponseType.RESULT);
				} else {
					System.out.println("Cant buy;Insufficient fund");
				}
			}

			Map<String, String> balanceMap = getAssetBalanceMap(sellList, binanceServices);

			// sell order
			for (String symbol : sellList) {
				OrderUtils orderUtils = new OrderUtils();
				for (String qty : orderUtils.splitOrders(balanceMap.get(symbol), symbol)) {
					NewOrderResponse newOrderResponse = binanceServices.newOrder(symbol, Side.SELL, Type.MARKET, null,
							qty, null, null, null, NewOrderResponseType.RESULT);

				}

			}
		}

	}

	private List<String> intersectList(List<String> list1, List<String> list2) {

		List<String> finalList = new ArrayList<>();

		for (String symbol : list1) {
			if (list2.contains(symbol)) {
				finalList.add(symbol);
			}
		}
		return finalList;

	}

	private Map<String, String> getAssetBalanceMap(List<String> symbolsList, BinanceServices binanceServices) {
		Map<String, String> balanceMap = new HashMap<>();
		for (String symbol : symbolsList) {
			String asset = symbol.split(quoteAsset)[0];
			balanceMap.put(symbol, binanceServices.getAccountDetails().getAssetBalance(asset).getFree());
		}
		return balanceMap;
	}

}
