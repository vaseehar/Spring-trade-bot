package com.example.springTradeBot.DAO;

import com.example.springTradeBot.enums.Side;
import com.example.springTradeBot.enums.Status;
import com.example.springTradeBot.enums.TimeInForce;
import com.example.springTradeBot.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	private String symbol;
	private String orderId;
	private String clientOrderId;
	private String price;
	private String origQty;
	private String executedQty;
	private Status status;
	private TimeInForce timeInForce;
	private Type type;
	private Side side;
	private String stopPrice;
	private String icebergQty;
	private String time;
	private String cumulativeQuoteQty;
	private String updateTime;

	@JsonProperty("isWorking")
	private boolean working;
	private String origQuoteOrderQty;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrigQty() {
		return origQty;
	}

	public void setOrigQty(String origQty) {
		this.origQty = origQty;
	}

	public String getExecutedQty() {
		return executedQty;
	}

	public void setExecutedQty(String executedQty) {
		this.executedQty = executedQty;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public String getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(String stopPrice) {
		this.stopPrice = stopPrice;
	}

	public String getIcebergQty() {
		return icebergQty;
	}

	public void setIcebergQty(String icebergQty) {
		this.icebergQty = icebergQty;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCumulativeQuoteQty() {
		return cumulativeQuoteQty;
	}

	public void setCumulativeQuoteQty(String cumulativeQuoteQty) {
		this.cumulativeQuoteQty = cumulativeQuoteQty;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	public String getOrigQuoteOrderQty() {
		return origQuoteOrderQty;
	}

	public void setOrigQuoteOrderQty(String origQuoteOrderQty) {
		this.origQuoteOrderQty = origQuoteOrderQty;
	}

	@Override
	public String toString() {
		return "Order [symbol=" + symbol + ", orderId=" + orderId + ", clientOrderId=" + clientOrderId + ", price="
				+ price + ", origQty=" + origQty + ", executedQty=" + executedQty + ", status=" + status
				+ ", timeInForce=" + timeInForce + ", type=" + type + ", side=" + side + ", stopPrice=" + stopPrice
				+ ", icebergQty=" + icebergQty + ", time=" + time + ", cumulativeQuoteQty=" + cumulativeQuoteQty
				+ ", updateTime=" + updateTime + ", working=" + working + ", origQuoteOrderQty=" + origQuoteOrderQty
				+ "]";
	}
}
