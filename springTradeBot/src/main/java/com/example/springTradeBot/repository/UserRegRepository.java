package com.example.springTradeBot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springTradeBot.entity.UserReg;

public interface UserRegRepository extends JpaRepository<UserReg, Integer> {

	Optional<UserReg> findByMobile(String mobile);
	Optional<UserReg> findById(String id);
}
