package com.example.springTradeBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springTradeBot.entity.TradePairs;

public interface TradePairsRepository extends JpaRepository<TradePairs, Integer>{

}
