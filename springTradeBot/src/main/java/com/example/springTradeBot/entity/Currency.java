package com.example.springTradeBot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@Column(name = "id", insertable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "name")
	private String name;

	@Column(name = "baseCurrencyId")
	private int baseCurrencyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseCurrencyId() {
		return baseCurrencyId;
	}

	public void setBaseCurrencyId(int baseCurrencyId) {
		this.baseCurrencyId = baseCurrencyId;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", symbol=" + symbol + ", name=" + name + ", baseCurrencyId=" + baseCurrencyId
				+ "]";
	}

}
