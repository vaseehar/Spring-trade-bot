package com.example.springTradeBot.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.example.springTradeBot.DAO.ExchangeInfo;
import com.example.springTradeBot.DAO.Filter;
import com.example.springTradeBot.DAO.Symbol;
import com.example.springTradeBot.enums.FilterType;

public class OrderUtils {

	public static ExchangeInfo exchangeInfo;

	public List<String> splitOrders(String qty, String symbol) {
		String maxQty = getMaxBaseAssetQty(symbol);
		double qtyDouble = Double.parseDouble(qty);
		double maxQtyDouble = Double.parseDouble(maxQty);
		List<String> qtysList = new ArrayList<>();
		Double remaining = qtyDouble;
		while (remaining > maxQtyDouble) {
			remaining = remaining - maxQtyDouble;
			qtysList.add(maxQty);
		}
		if (remaining > 0) {
			qtysList.add(roundDownToPrecision(String.valueOf(remaining), getQuoteAssetPrecision(symbol)));
		}
		return qtysList;

	}

	public String getMaxBaseAssetQty(String symbol) {
		Symbol symbolObj = exchangeInfo.getSymbol(symbol);
		Filter mlsFilter = symbolObj.getFilter(FilterType.MARKET_LOT_SIZE.toString());
		return mlsFilter.getMaxQty();
	}

	public int getQuoteAssetPrecision(String symbol) {
		Symbol symbolObj = exchangeInfo.getSymbol(symbol);
		return symbolObj.getBaseAssetPrecision();
	}

	private String roundDownToPrecision(String value, int precision) {

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(precision, RoundingMode.DOWN);
		return String.valueOf(bd.doubleValue());

	}

	public boolean isQtyGreaterThanMinNotional(String qty, String symbol) {
		return (Double.parseDouble(exchangeInfo.getSymbol(symbol).getFilter(FilterType.MIN_NOTIONAL.toString()).getMinNotional()) < Double.parseDouble(qty));

	}

}
