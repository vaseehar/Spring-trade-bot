package com.example.springTradeBot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springTradeBot.DAO.Account;
import com.example.springTradeBot.DAO.AssetBalance;
import com.example.springTradeBot.entity.Asset;
import com.example.springTradeBot.entity.AssetId;
import com.example.springTradeBot.entity.TradePairs;
import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.repository.AssetRepository;
import com.example.springTradeBot.repository.TradePairsRepository;
import com.example.springTradeBot.repository.UserRegRepository;
import com.example.springTradeBot.utilities.CryptoUtils;

@Service
public class DashBoardServices {

	@Autowired
	TradePairsRepository tradePairsRepository;

	@Autowired
	UserRegRepository userRegRepository;

	@Autowired
	CryptoUtils cryptoUtils;

	@Autowired
	AssetRepository assetRepository;

	public void saveTradePairs(List<String> pairs, int userId) {
		TradePairs tradePairs = new TradePairs();
		String pairString = "";
		for (String pair : pairs) {
			pairString = pairString.concat(pair).concat("|");
		}
		pairString = pairString.substring(0, pairString.lastIndexOf("|"));
		tradePairs.setTradePairs(pairString);
		tradePairs.setUserId(userId);
		tradePairs.setTotalPairs(pairs.size());
		tradePairsRepository.save(tradePairs);
	}

	public void saveBaseAssetAmount(int userId, String assetName) {
		Optional<UserReg> userRegOpt = userRegRepository.findById(userId);
		UserReg userReg = userRegOpt.get();
		String apiKey = userReg.getBinanceApiKey();
		String secret = cryptoUtils.decrypt(userReg.getBinanceApiSecret());
		BinanceServices binanceServices = new BinanceServices(apiKey, secret);
		Account account = binanceServices.getAccountDetails();
		AssetBalance assetBalance = account.getAssetBalance(assetName);
		int totalPairs = tradePairsRepository.findById(userId).get().getTotalPairs();
		double volumePerTrade = Double.parseDouble(assetBalance.getFree()) / totalPairs;
		Asset asset = new Asset();
		asset.setAssetId(new AssetId(userId, assetName));
		asset.setInitialAsset(assetBalance.getFree());
		asset.setVolumePerTrade(String.valueOf(volumePerTrade));
		assetRepository.save(asset);
	}
}
