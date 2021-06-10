package com.example.springTradeBot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade_pairs")
public class TradePairs {
	@Id
	private int userId;

	@Column(length = 500)
	private String tradePairs;

	@Column
	private int totalPairs;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTradePairs() {
		return tradePairs;
	}

	public void setTradePairs(String tradePairs) {
		this.tradePairs = tradePairs;
	}

	public int getTotalPairs() {
		return totalPairs;
	}

	public void setTotalPairs(int totalPairs) {
		this.totalPairs = totalPairs;
	}

	@Override
	public String toString() {
		return "TradePairs [userId=" + userId + ", tradePairs=" + tradePairs + ", totalPairs=" + totalPairs + "]";
	}

}
