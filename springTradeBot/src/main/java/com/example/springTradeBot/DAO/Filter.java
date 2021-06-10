package com.example.springTradeBot.DAO;

import com.example.springTradeBot.enums.FilterType;

public class Filter {

	private FilterType filterType;
	private String minPrice;
	private String maxPrice;
	private String tickSize;
	private String multiplierUp;
	private String multiplierDown;
	private String avgPriceMins;
	private String minNotional;
	private boolean applyToMarket;
	private String limit;
	private String minQty;
	private String maxQty;
	private String stepSize;
	private String maxNumOrders;
	private String maxNumAlgoOrders;

	public FilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getTickSize() {
		return tickSize;
	}

	public void setTickSize(String tickSize) {
		this.tickSize = tickSize;
	}

	public String getMultiplierUp() {
		return multiplierUp;
	}

	public void setMultiplierUp(String multiplierUp) {
		this.multiplierUp = multiplierUp;
	}

	public String getMultiplierDown() {
		return multiplierDown;
	}

	public void setMultiplierDown(String multiplierDown) {
		this.multiplierDown = multiplierDown;
	}

	public String getAvgPriceMins() {
		return avgPriceMins;
	}

	public void setAvgPriceMins(String avgPriceMins) {
		this.avgPriceMins = avgPriceMins;
	}

	public String getMinNotional() {
		return minNotional;
	}

	public void setMinNotional(String minNotional) {
		this.minNotional = minNotional;
	}

	public boolean isApplyToMarket() {
		return applyToMarket;
	}

	public void setApplyToMarket(boolean applyToMarket) {
		this.applyToMarket = applyToMarket;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getMinQty() {
		return minQty;
	}

	public void setMinQty(String minQty) {
		this.minQty = minQty;
	}

	public String getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(String maxQty) {
		this.maxQty = maxQty;
	}

	public String getStepSize() {
		return stepSize;
	}

	public void setStepSize(String stepSize) {
		this.stepSize = stepSize;
	}

	public String getMaxNumOrders() {
		return maxNumOrders;
	}

	public void setMaxNumOrders(String maxNumOrders) {
		this.maxNumOrders = maxNumOrders;
	}

	public String getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}

	public void setMaxNumAlgoOrders(String maxNumAlgoOrders) {
		this.maxNumAlgoOrders = maxNumAlgoOrders;
	}

	@Override
	public String toString() {
		return "Filter [filterType=" + filterType + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", tickSize="
				+ tickSize + ", multiplierUp=" + multiplierUp + ", multiplierDown=" + multiplierDown + ", avgPriceMins="
				+ avgPriceMins + ", minNotional=" + minNotional + ", applyToMarket=" + applyToMarket + ", limit="
				+ limit + ", minQty=" + minQty + ", maxQty=" + maxQty + ", stepSize=" + stepSize + ", maxNumOrders="
				+ maxNumOrders + ", maxNumAlgoOrders=" + maxNumAlgoOrders + "]";
	}

}
