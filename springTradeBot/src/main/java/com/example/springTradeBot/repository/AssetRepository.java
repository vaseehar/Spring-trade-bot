package com.example.springTradeBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springTradeBot.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer>{

}
