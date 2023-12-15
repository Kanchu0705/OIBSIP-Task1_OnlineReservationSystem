package com.oibsip.kanchu;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserReservationService {
	@Autowired
	UserReservationSystemRepository userReservationSystemRepository;

	@Transactional
	public Optional<UserReservation> getLatestPNR() {
		return userReservationSystemRepository.findTopByOrderByPnrDesc();
	}

	@Transactional
	public void save(UserReservation userReservation) {
		try {
			userReservationSystemRepository.save(userReservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void saveRegistration(UserReservation userReservation) {
		try {
			userReservationSystemRepository.save(userReservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
