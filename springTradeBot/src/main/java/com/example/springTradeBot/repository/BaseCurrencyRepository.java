package com.example.springTradeBot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springTradeBot.entity.BaseCurrency;

public interface BaseCurrencyRepository extends JpaRepository<BaseCurrency, Integer> {

	List<BaseCurrency> findAll();
	Optional<BaseCurrency> findBySymbol(String symbol);
}
