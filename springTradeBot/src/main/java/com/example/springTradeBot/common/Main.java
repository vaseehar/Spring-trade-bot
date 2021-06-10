package com.example.springTradeBot.common;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("main")
public class Main {
	@Autowired
	private RSICalculator rsiCalculator;

	public void start() {
		Timer timer = new Timer();
		TimerTask task = rsiCalculator;
		timer.schedule(task, 0, 300000);
	}
}
