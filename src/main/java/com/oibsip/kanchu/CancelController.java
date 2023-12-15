package com.oibsip.kanchu;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CancelController {
    @Autowired
    CancelService cancelService;

    @GetMapping("/cancelReservation")
    public String Cancel(Model model) {
        return "validatePNR";
    }

    @PostMapping("/showReservationDetails")
    public String cancelPNR(@RequestParam Integer pnr, Model model) {
        Optional<UserReservation> reservationDetails = cancelService.getReservationDetailsByPnr(pnr);
        if (reservationDetails.isPresent()) {
            model.addAttribute("reservationDetails", reservationDetails.get());
            return "cancel";
        } else {
            model.addAttribute("invalidPnr", true);
            return "validatePNR";
        }
    }

    @PostMapping("/cancel")
    public String cancelReservation(@RequestParam Integer pnr, @RequestParam String confirmCancellation, Model model) {
        try {
            if ("yes".equals(confirmCancellation)) {
                Optional<UserReservation> reservationDetails = cancelService.getReservationDetailsByPnr(pnr);

                if (reservationDetails.isPresent()) {
                    cancelService.delete(reservationDetails.get());
                    model.addAttribute("cancellationSuccessful", true);
                    return "cancellationSuccessful";
                }
            } else if ("no".equals(confirmCancellation)) {
                model.addAttribute("cancellationSuccessful", false);
                return "cancellationUnsuccessful";
            }
        } catch (NumberFormatException e) {
            model.addAttribute("cancellationSuccessful", false);
            return "cancellationUnsuccessful";
        }
        return "cancellationUnsuccessful";
    }

}