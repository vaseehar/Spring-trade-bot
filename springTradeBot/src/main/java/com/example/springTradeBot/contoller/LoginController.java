package com.example.springTradeBot.contoller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springTradeBot.service.LoginServices;

@Controller
public class LoginController {

	@Autowired
	private LoginServices loginServices;

	@PostMapping("/validate")
	public String validate(@RequestParam String mobile, @RequestParam String password , Model model ,HttpServletRequest request) {
		if (loginServices.isValidUser(mobile, password)) {
			Map<String,String> userMap;
			userMap = loginServices.getUserMap(mobile);
			request.getSession().setAttribute("userMap", userMap);
			model.addAttribute("message", "Logged in");
			return "dashboard";
		} else {
			model.addAttribute("error", "either mobile or password is wrong");
			return "login";
		}
	}
}
