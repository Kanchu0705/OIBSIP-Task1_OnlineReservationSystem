package com.oibsip.kanchu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainController {

	@Autowired
	TrainService trainService;

	@GetMapping("/newReservation")
	public String reservation(Model model) {
		return "reservations";
	}

	@PostMapping("/saveReservation")
    public String saveReservation(UserReservation userReservation, Model model) {
        trainService.saveReservation(userReservation);
        return "redirect:/pnrGeneration";
    }
}
