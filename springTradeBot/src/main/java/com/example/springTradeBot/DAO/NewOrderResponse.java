package com.example.springTradeBot.DAO;

import java.util.List;

import com.example.springTradeBot.enums.OrderStatus;
import com.example.springTradeBot.enums.Side;
import com.example.springTradeBot.enums.TimeInForce;
import com.example.springTradeBot.enums.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderResponse {

	private String symbol;
	private Long orderId;
	private String clientOrderId;
	private String price;
	private String origQty;
	private String executedQty;
	private String cummulativeQuoteQty;
	private OrderStatus status;
	private TimeInForce timeInForce;
	private Type orderType;
	private Side orderSide;
	private List<Trade> fills;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
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

	public String getCummulativeQuoteQty() {
		return cummulativeQuoteQty;
	}

	public void setCummulativeQuoteQty(String cummulativeQuoteQty) {
		this.cummulativeQuoteQty = cummulativeQuoteQty;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	public Type getOrderType() {
		return orderType;
	}

	public void setOrderType(Type orderType) {
		this.orderType = orderType;
	}

	public Side getOrderSide() {
		return orderSide;
	}

	public void setOrderSide(Side orderSide) {
		this.orderSide = orderSide;
	}

	public List<Trade> getFills() {
		return fills;
	}

	public void setFills(List<Trade> fills) {
		this.fills = fills;
	}

	@Override
	public String toString() {
		return "NewOrderResponse [symbol=" + symbol + ", orderId=" + orderId + ", clientOrderId=" + clientOrderId
				+ ", price=" + price + ", origQty=" + origQty + ", executedQty=" + executedQty
				+ ", cummulativeQuoteQty=" + cummulativeQuoteQty + ", status=" + status + ", timeInForce=" + timeInForce
				+ ", orderType=" + orderType + ", orderSide=" + orderSide + ", fills=" + fills + "]";
	}

}
