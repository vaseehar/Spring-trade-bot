package com.example.springTradeBot.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springTradeBot.entity.BaseCurrency;
import com.example.springTradeBot.entity.Currency;
import com.example.springTradeBot.repository.BaseCurrencyRepository;
import com.example.springTradeBot.repository.CurrencyRepository;
import com.example.springTradeBot.service.DashBoardServices;

@Controller
public class DashboardController {

	@Autowired
	BaseCurrencyRepository baseCurrencyRepository;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	DashBoardServices dashBoardServices;

	@PostMapping("/fetchCurrencies")
	public ResponseEntity<?> fetchCurrencies(@RequestBody String currency, Model model) {
		Optional<BaseCurrency> baseCurrency = baseCurrencyRepository.findBySymbol(currency);
		int baseCurrencyId = baseCurrency.get().getId();
		List<Currency> currencyList = currencyRepository.findByBaseCurrencyId(baseCurrencyId);

		List<String> currencySymbolList = new ArrayList<>();
		for (Currency currency1 : currencyList) {
			currencySymbolList.add(currency1.getName());
		}
		return ResponseEntity.ok(currencySymbolList);
	}

	@PostMapping("/startTrade")
	public String startTrade(@RequestParam String currency, @RequestParam List<String> pairs,
			HttpServletRequest request) throws Exception {
		Map<String, String> userMap = (Map<String, String>) request.getSession().getAttribute("userMap");
		int userId = Integer.parseInt(userMap.get("userId"));
		dashBoardServices.saveTradePairs(pairs, userId);
		dashBoardServices.saveBaseAssetAmount(userId, currency);
		return null;

	}
}
