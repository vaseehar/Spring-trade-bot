package com.example.springTradeBot.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CandleStickList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CandleStick> candleSticks;

	public CandleStickList() {
		candleSticks = new ArrayList<CandleStick>();
	}

	public List<CandleStick> getCandleSticks() {
		return candleSticks;
	}

	public void setCandleSticks(List<CandleStick> candleSticks) {
		this.candleSticks = candleSticks;
	}

}
