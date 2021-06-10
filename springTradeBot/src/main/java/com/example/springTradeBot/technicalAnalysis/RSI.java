package com.example.springTradeBot.technicalAnalysis;


import java.util.List;

import com.example.springTradeBot.DAO.CandleStick;


public class RSI {

	public static double calculate(List<CandleStick> data) throws Exception {
		int periodLength = 14;
		int lastBar = data.size() - 1;
		int firstBar = lastBar - periodLength + 1;
		if (firstBar < 0) {
			String msg = "Quote history length " + data.size() + " is insufficient to calculate the indicator.";
			throw new Exception(msg);
		}

		double aveGain = 0, aveLoss = 0;
		for (int bar = firstBar + 1; bar <= lastBar; bar++) {
			double change = Double.parseDouble(data.get(bar).getClose())
					- Double.parseDouble(data.get(bar - 1).getClose());
			if (change >= 0) {
				aveGain += change;
			} else {
				aveLoss += change;
			}
		}

		double rs = aveGain / Math.abs(aveLoss);
		double rsi = 100 - 100 / (1 + rs);

		return rsi;
	}
}
