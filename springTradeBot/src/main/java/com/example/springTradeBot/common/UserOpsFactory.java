package com.example.springTradeBot.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springTradeBot.entity.Asset;
import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.repository.AssetRepository;
import com.example.springTradeBot.repository.UserRegRepository;
import com.example.springTradeBot.utilities.CryptoUtils;

@Component("userOpsFactory")
public class UserOpsFactory {

	@Autowired
	UserRegRepository userRegRepository;

	@Autowired
	CryptoUtils cryptoUtils;
	
	@Autowired
	AssetRepository assetRepository;
	
	private final ObjectProvider<UserOperations> userOperationsProvider;

	public UserOpsFactory(ObjectProvider<UserOperations> userOperationsProvider) {
		this.userOperationsProvider = userOperationsProvider;
	}

	public static Map<String , String> tradeQtyMap = new HashMap<>();
	public static Map<String,String> quoteAssetMap = new HashMap<>();

	public void createUserOperations() {
		List<UserReg> userRegList = userRegRepository.findAll();
		Timer timer = new Timer();
		for (UserReg userReg : userRegList) {

			UserOperations userOps = userOperationsProvider.getObject(String.valueOf(userReg.getId()),
					userReg.getBinanceApiKey(), cryptoUtils.decrypt(userReg.getBinanceApiSecret()));
			TimerTask task = userOps;
			timer.schedule(task, 0, 300000);
		}
		
		List<Asset> assetList = assetRepository.findAll();
		for(Asset asset : assetList) {
			tradeQtyMap.put(String.valueOf(asset.getAssetId().getUserId()), asset.getVolumePerTrade());
			quoteAssetMap.put(String.valueOf(asset.getAssetId().getUserId()), asset.getAssetId().getAssetName());
		}
	}
}
