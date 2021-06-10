package com.example.springTradeBot.DAO;

import com.example.springTradeBot.enums.NewOrderResponseType;
import com.example.springTradeBot.enums.Side;
import com.example.springTradeBot.enums.TimeInForce;
import com.example.springTradeBot.enums.Type;

public class NewOrder {

	private String symbol;
	private Side side;
	private Type type;
	private TimeInForce timeInForce;
	private String quantity;
	private String quoteOrderQty;
	private String price;
	private String newClientOrderId;
	private String stopPrice;
	private String icebergQty;
	private NewOrderResponseType newOrderRespType;
	private Long recvWindow;
	private long timestamp;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuoteOrderQty() {
		return quoteOrderQty;
	}

	public void setQuoteOrderQty(String quoteOrderQty) {
		this.quoteOrderQty = quoteOrderQty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNewClientOrderId() {
		return newClientOrderId;
	}

	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
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

	public NewOrderResponseType getNewOrderRespType() {
		return newOrderRespType;
	}

	public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
		this.newOrderRespType = newOrderRespType;
	}

	public Long getRecvWindow() {
		return recvWindow;
	}

	public void setRecvWindow(Long recvWindow) {
		this.recvWindow = recvWindow;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "NewOrder [symbol=" + symbol + ", side=" + side + ", type=" + type + ", timeInForce=" + timeInForce
				+ ", quantity=" + quantity + ", quoteOrderQty=" + quoteOrderQty + ", price=" + price
				+ ", newClientOrderId=" + newClientOrderId + ", stopPrice=" + stopPrice + ", icebergQty=" + icebergQty
				+ ", newOrderRespType=" + newOrderRespType + ", recvWindow=" + recvWindow + ", timestamp=" + timestamp
				+ "]";
	}

}
