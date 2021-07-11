package com.example.springTradeBot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.repository.UserRegRepository;

@Service
public class RegisterService {

	@Autowired
	private UserRegRepository userRegRepo;

	public boolean isNewUser(String mobile) {
		Optional<UserReg> userReg = userRegRepo.findByMobile(mobile);
		return !userReg.isPresent();
	}

	public void saveUser(UserReg userReg) {
		userRegRepo.save(userReg);
	}
}
