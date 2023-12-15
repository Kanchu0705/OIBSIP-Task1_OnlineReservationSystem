package com.oibsip.kanchu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	int loginAttempts = 0;

	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}

	@PostMapping("/saveLogin")
	public String login(@RequestParam String userID, @RequestParam String userPassword, Model model) {
		if (loginService.checkLogin(userID, userPassword)) {
			return "redirect:/bookCancel";
		} else {
			loginAttempts++;
			if (loginAttempts >= 3) {
				model.addAttribute("message", "Too many login attempts try after sometime or later!!😤");
			} else {
				model.addAttribute("message", "Invalid User-ID/Password 😑");
			}
		}
		return "login";
	}

}
