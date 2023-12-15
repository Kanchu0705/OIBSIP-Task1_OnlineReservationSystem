package com.oibsip.kanchu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
public class UserReservationController {

	@Autowired
	UserReservationService userReservationService;

	@GetMapping("/home")
	public String homePage(Model model) {
		return "index";
	}

	@GetMapping("/newRegistration")
	public String registration() {
		return "registration";
	}

	@PostMapping("/saveRegistration")
	public String saveRegistration(UserReservation userReservation) {
		userReservationService.save(userReservation);
		return "redirect:/credentials";
	}

	@GetMapping("/credentials")
	public String credential(Model model) {
		return "login-credentials";
	}

	@PostMapping("/saveCredentials")
	public String saveCredentials(UserReservation userReservation) {
		userReservationService.save(userReservation);
		return "redirect:/home";
	}
	
	@GetMapping("/bookCancel")
    public String BookCancel(Model model) {
        return "bookCancel";
    }
	
	@GetMapping("/pnrGeneration")
	public String pnrGeneration(Model model) {
		Optional<UserReservation> pnrNumber = userReservationService.getLatestPNR();
		model.addAttribute("pnr", pnrNumber.orElse(null));
		return "pnr";
	}

	@GetMapping("/end")
	public String exitPage() {
		return "exit";
	}
}
