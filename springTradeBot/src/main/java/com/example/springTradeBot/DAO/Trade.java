package com.example.springTradeBot.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trade {

	private Long id;
	private String price;
	private String qty;
	private String quoteQty;
	private String commission;
	private String commissionAsset;
	private long time;
	private String symbol;

	@JsonProperty("isBuyer")
	private boolean buyer;

	@JsonProperty("isMaker")
	private boolean maker;

	@JsonProperty("isBestMatch")
	private boolean bestMatch;

	private String orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQuoteQty() {
		return quoteQty;
	}

	public void setQuoteQty(String quoteQty) {
		this.quoteQty = quoteQty;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getCommissionAsset() {
		return commissionAsset;
	}

	public void setCommissionAsset(String commissionAsset) {
		this.commissionAsset = commissionAsset;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public boolean isBuyer() {
		return buyer;
	}

	public void setBuyer(boolean buyer) {
		this.buyer = buyer;
	}

	public boolean isMaker() {
		return maker;
	}

	public void setMaker(boolean maker) {
		this.maker = maker;
	}

	public boolean isBestMatch() {
		return bestMatch;
	}

	public void setBestMatch(boolean bestMatch) {
		this.bestMatch = bestMatch;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", price=" + price + ", qty=" + qty + ", quoteQty=" + quoteQty + ", commission="
				+ commission + ", commissionAsset=" + commissionAsset + ", time=" + time + ", symbol=" + symbol
				+ ", buyer=" + buyer + ", maker=" + maker + ", bestMatch=" + bestMatch + ", orderId=" + orderId + "]";
	}

}
