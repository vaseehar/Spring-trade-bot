package com.example.springTradeBot.contoller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springTradeBot.entity.UserReg;
import com.example.springTradeBot.model.UserRegModel;
import com.example.springTradeBot.service.RegisterService;
import com.example.springTradeBot.utilities.CryptoUtils;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@Autowired
	CryptoUtils cryptoUtils;

	@PostMapping("/doRegister")
	public String doRegister(@ModelAttribute("userRegModel") @Valid UserRegModel userRegModel,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "register";
		}
		UserReg userReg;
		userReg = convertUserRegModelToUserReg(userRegModel);
		registerService.saveUser(userReg);
		model.addAttribute("message", "Registered Succesfully");

		return "home";
	}

	private UserReg convertUserRegModelToUserReg(UserRegModel userRegModel) {

		UserReg userReg = new UserReg();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userReg.setFirstName(userRegModel.getFirstName());
		if (userRegModel.getLastName() != null)
			userReg.setLastName(userRegModel.getLastName());
		userReg.setCountryCode(userRegModel.getCountryCode());
		userReg.setMobile(userRegModel.getMobile());
		userReg.setBinanceApiKey(userRegModel.getBinanceApiKey());
		try {
			userReg.setBinanceApiSecret(cryptoUtils.encrypt(userRegModel.getBinanceApiSecret()));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		userReg.setPassword(passwordEncoder.encode(userRegModel.getPassword()));
		return userReg;

	}
}
