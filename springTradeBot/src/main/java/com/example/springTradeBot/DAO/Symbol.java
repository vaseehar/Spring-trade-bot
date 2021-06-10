package com.example.springTradeBot.DAO;

import java.util.List;

import com.example.springTradeBot.enums.SymbolStatus;
import com.example.springTradeBot.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbol {
	private String symbol;
	private SymbolStatus status;
	private String baseAsset;
	private int baseAssetPrecision;
	private String quoteAsset;
	private int quotePrecision;
	private int quoteAssetPrecision;
	private int baseCommissionPrecision;
	private int quoteCommissionPrecision;
	private List<Type> orderTypes;
	private boolean icebergAllowed;
	private boolean ocoAllowed;
	private boolean quoteOrderQtyMarketAllowed;
	private boolean isSpotTradingAllowed;
	private boolean isMarginTradingAllowed;
	private List<Filter> filters;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public SymbolStatus getStatus() {
		return status;
	}

	public void setStatus(SymbolStatus status) {
		this.status = status;
	}

	public String getBaseAsset() {
		return baseAsset;
	}

	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}

	public int getBaseAssetPrecision() {
		return baseAssetPrecision;
	}

	public void setBaseAssetPrecision(int baseAssetPrecision) {
		this.baseAssetPrecision = baseAssetPrecision;
	}

	public String getQuoteAsset() {
		return quoteAsset;
	}

	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}

	public int getQuotePrecision() {
		return quotePrecision;
	}

	public void setQuotePrecision(int quotePrecision) {
		this.quotePrecision = quotePrecision;
	}

	public int getQuoteAssetPrecision() {
		return quoteAssetPrecision;
	}

	public void setQuoteAssetPrecision(int quoteAssetPrecision) {
		this.quoteAssetPrecision = quoteAssetPrecision;
	}

	public int getBaseCommissionPrecision() {
		return baseCommissionPrecision;
	}

	public void setBaseCommissionPrecision(int baseCommissionPrecision) {
		this.baseCommissionPrecision = baseCommissionPrecision;
	}

	public int getQuoteCommissionPrecision() {
		return quoteCommissionPrecision;
	}

	public void setQuoteCommissionPrecision(int quoteCommissionPrecision) {
		this.quoteCommissionPrecision = quoteCommissionPrecision;
	}

	public List<Type> getOrderTypes() {
		return orderTypes;
	}

	public void setOrderTypes(List<Type> orderTypes) {
		this.orderTypes = orderTypes;
	}

	public boolean isIcebergAllowed() {
		return icebergAllowed;
	}

	public void setIcebergAllowed(boolean icebergAllowed) {
		this.icebergAllowed = icebergAllowed;
	}

	public boolean isOcoAllowed() {
		return ocoAllowed;
	}

	public void setOcoAllowed(boolean ocoAllowed) {
		this.ocoAllowed = ocoAllowed;
	}

	public boolean isQuoteOrderQtyMarketAllowed() {
		return quoteOrderQtyMarketAllowed;
	}

	public void setQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed) {
		this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
	}

	public boolean isSpotTradingAllowed() {
		return isSpotTradingAllowed;
	}

	public void setSpotTradingAllowed(boolean isSpotTradingAllowed) {
		this.isSpotTradingAllowed = isSpotTradingAllowed;
	}

	public boolean isMarginTradingAllowed() {
		return isMarginTradingAllowed;
	}

	public void setMarginTradingAllowed(boolean isMarginTradingAllowed) {
		this.isMarginTradingAllowed = isMarginTradingAllowed;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public Filter getFilter(String filterName) {
		for (Filter filter : filters) {
			if (filter.getFilterType().toString().equals(filterName)) {
				return filter;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Symbol [symbol=" + symbol + ", status=" + status + ", baseAsset=" + baseAsset + ", baseAssetPrecision="
				+ baseAssetPrecision + ", quoteAsset=" + quoteAsset + ", quotePrecision=" + quotePrecision
				+ ", quoteAssetPrecision=" + quoteAssetPrecision + ", baseCommissionPrecision="
				+ baseCommissionPrecision + ", quoteCommissionPrecision=" + quoteCommissionPrecision + ", orderTypes="
				+ orderTypes + ", icebergAllowed=" + icebergAllowed + ", ocoAllowed=" + ocoAllowed
				+ ", quoteOrderQtyMarketAllowed=" + quoteOrderQtyMarketAllowed + ", isSpotTradingAllowed="
				+ isSpotTradingAllowed + ", isMarginTradingAllowed=" + isMarginTradingAllowed + ", filters=" + filters
				+ "]";
	}

}
