package com.example.springTradeBot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springTradeBot.entity.Currency;
import com.example.springTradeBot.entity.UserReg;

public interface CurrencyRepository extends JpaRepository<Currency, Integer>{

	List<Currency> findAll();
	List<Currency> findByBaseCurrencyId(int baseCurrencyId);
}
