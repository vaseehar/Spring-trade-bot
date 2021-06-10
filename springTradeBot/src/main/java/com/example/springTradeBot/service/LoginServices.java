package com.example.springTradeBot.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.repository.UserRegRepository;
import com.example.springTradeBot.utilities.CryptoUtils;

@Service
public class LoginServices {

	@Autowired
	UserRegRepository userRegRepo;
	
	@Autowired
	CryptoUtils cryptoUtils;

	public boolean isValidUser(String mobile, String password) {
		Optional<UserReg> optional = userRegRepo.findByMobile(mobile);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (optional.isPresent()) {
			System.out.println("api secret::" + cryptoUtils.decrypt(optional.get().getBinanceApiSecret()));
			if (passwordEncoder.matches(password, optional.get().getPassword()))
				return true;
			else
				return false;
		} else
			return false;
	}

	public Map<String, String> getUserMap(String mobile) {
		Optional<UserReg> optional = userRegRepo.findByMobile(mobile);
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userId", String.valueOf(optional.get().getId()));
		userMap.put("name", optional.get().getFirstName() + " " + optional.get().getLastName());
		userMap.put("binanceApiKey", optional.get().getBinanceApiKey());
		userMap.put("binanceSecret", cryptoUtils.decrypt(optional.get().getBinanceApiSecret()));
		return userMap;
	}
}
