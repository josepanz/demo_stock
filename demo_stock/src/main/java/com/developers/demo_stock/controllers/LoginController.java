package com.developers.demo_stock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
@GetMapping("/login")
public String login() {
	return "login/login";
}

@GetMapping("/index")
public String index(Model model) {
	model.addAttribute("template","ola");
	return "layout/index";
}
}
