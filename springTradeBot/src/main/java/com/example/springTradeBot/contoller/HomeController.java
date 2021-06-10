package com.example.springTradeBot.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springTradeBot.model.UserRegModel;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model mode) {
		return "home";
	}

	@PostMapping("/gotoregister")
	public String showForm(Model model) {
		UserRegModel userRegModel = new UserRegModel();
		model.addAttribute("userRegModel", userRegModel);
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
