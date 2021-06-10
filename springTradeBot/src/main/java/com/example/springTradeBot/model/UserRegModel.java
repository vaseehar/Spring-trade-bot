package com.example.springTradeBot.model;

import javax.validation.constraints.NotBlank;

import com.example.springTradeBot.validator.MobileConstraint;
import com.example.springTradeBot.validator.ValidatePasswordMatch;

@ValidatePasswordMatch(field = "password" , fieldMatch = "confirmPassword")
public class UserRegModel {

	@NotBlank(message = "firstName cant be empty")
	private String firstName;
	private String lastName;
	@NotBlank(message = "countryCode cant be null")
	private String countryCode;
	@NotBlank(message = "mobile cant be null")
	@MobileConstraint
	private String mobile;
	@NotBlank(message = "password cant be null")
	private String password;
	private String confirmPassword;
	@NotBlank(message = "api key cant be null")
	private String binanceApiKey;
	@NotBlank(message = "api secret cant be null")
	private String binanceApiSecret;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBinanceApiKey() {
		return binanceApiKey;
	}

	public void setBinanceApiKey(String binanceApiKey) {
		this.binanceApiKey = binanceApiKey;
	}

	public String getBinanceApiSecret() {
		return binanceApiSecret;
	}

	public void setBinanceApiSecret(String binanceApiSecret) {
		this.binanceApiSecret = binanceApiSecret;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
