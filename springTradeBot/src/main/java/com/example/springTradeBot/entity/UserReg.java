package com.example.springTradeBot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userreg")
public class UserReg {
	@Id
	@Column(name = "id", insertable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "countrycode")
	private String countryCode;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "password")
	private String password;
	@Column(name = "binanceapikey")
	private String binanceApiKey;
	@Column(name = "binanceapisecret")
	private String binanceApiSecret;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "UserReg [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", countryCode="
				+ countryCode + ", mobile=" + mobile + ", password=" + password + ", binanceApiKey=" + binanceApiKey
				+ ", binanceApiSecret=" + binanceApiSecret + "]";
	}

	

}
