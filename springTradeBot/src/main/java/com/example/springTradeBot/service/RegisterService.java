package com.example.springTradeBot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.repository.UserRegRepository;

@Service
public class RegisterService {

	@Autowired
	private UserRegRepository userRegRepo;
	public boolean isNewUser(String mobile) {
		boolean isNewUser = true;
		List<UserReg> userRegList = userRegRepo.findAll();
		for(UserReg user : userRegList) {
			if(mobile.equalsIgnoreCase(user.getMobile())) {
				isNewUser = false;
			}
}
		return isNewUser;
	}
	
	public void saveUser(UserReg userReg) {
		userRegRepo.save(userReg);
	}
}
