package com.example.springTradeBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.example.springTradeBot.common.Main;
import com.example.springTradeBot.common.UserOpsFactory;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class ,ErrorMvcAutoConfiguration.class})

public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Main main = (Main) ctx.getBean("main");
		main.start();
		
		UserOpsFactory userOpsFactory = (UserOpsFactory) ctx.getBean("userOpsFactory");
		userOpsFactory.createUserOperations();
	}

}
