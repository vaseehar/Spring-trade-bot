package com.example.springTradeBot.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springTradeBot.DAO.CandleStick;
import com.example.springTradeBot.DAO.ExchangeInfo;
import com.example.springTradeBot.entity.BaseCurrency;
import com.example.springTradeBot.entity.Currency;
import com.example.springTradeBot.enums.KlineIntervals;
import com.example.springTradeBot.repository.BaseCurrencyRepository;
import com.example.springTradeBot.repository.CurrencyRepository;
import com.example.springTradeBot.service.BinanceServicesGenEP;
import com.example.springTradeBot.technicalAnalysis.RSI;
import com.example.springTradeBot.utilities.OrderUtils;

@Component("rsiCalculator")
public class RSICalculator extends TimerTask {

	@Autowired
	BaseCurrencyRepository baseCurrencyRepository;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	BinanceServicesGenEP binanceServicesGenEP;

	static List<String> currenciesList = new ArrayList<>();
	static Map<String, Double> rsiMap = new HashMap<String, Double>();
	static List<String> rsiSellList = new ArrayList<>();
	static List<String> rsiBuyList = new ArrayList<>();
	public static ExchangeInfo exchangeInfo;

	static boolean isJobOver = false;

	@Override
	public void run() {
		if (null == exchangeInfo) {
			exchangeInfo = binanceServicesGenEP.getExchangeInfo();
			OrderUtils.exchangeInfo = RSICalculator.exchangeInfo;
		}
		isJobOver = false;
		List<BaseCurrency> baseCurrencyList = baseCurrencyRepository.findAll();
		for (BaseCurrency baseCurrency : baseCurrencyList) {
			List<Currency> currencyList = currencyRepository.findByBaseCurrencyId(baseCurrency.getId());
			currenciesList.add(listToString(currencyList, baseCurrency.getSymbol()));
		}
		for (String currencyString : currenciesList) {
			String[] symbols = currencyString.split("\\|");
			ExecutorService executorService = Executors.newFixedThreadPool(10);
			List<Callable<String>> callableList = new ArrayList<Callable<String>>();
			for (String symbol : symbols) {
				if (!symbol.isBlank()) {

					Callable<String> callable = () -> {
						CandleStick[] candleSticks = binanceServicesGenEP.getCandleSticks(symbol, KlineIntervals.HOURLY);
						try {
							double rsi = RSI.calculate(Arrays.asList(candleSticks));
							rsiMap.put(symbol, rsi);
						} catch (Exception e) {
							e.printStackTrace();
						}
						return "done";};
							
					
					callableList.add(callable);
				}
			}
			try {
				executorService.invokeAll(callableList);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		generateRsiBuyAndSellMap();
		isJobOver = true;
	}

	private static String listToString(List<Currency> currencyList, String baseCurrencyName) {
		String currencyString = "";
		for (Currency currency : currencyList) {
			currencyString = currencyString.concat(currency.getName()).concat(baseCurrencyName).concat("|");
		}
		if (!currencyString.isBlank())
			currencyString = currencyString.substring(0, currencyString.lastIndexOf("|"));
		return currencyString;

	}

	private static void generateRsiBuyAndSellMap() {

		for (Map.Entry<String, Double> entry : rsiMap.entrySet()) {
			if (entry.getValue() > 100) {
				rsiSellList.add(entry.getKey());
			} else if (entry.getValue() < 100) {
				rsiBuyList.add(entry.getKey());
			}
		}

	}

}
