package com.oibsip.kanchu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelService {

	@Autowired
	UserReservationSystemRepository userReservationSystemRepository;

	@Transactional
	public void save(UserReservation userReservation) {
		userReservationSystemRepository.save(userReservation);
	}

	@Transactional
	public Optional<UserReservation> getReservationDetailsByPnr(Integer pnr) {
		return userReservationSystemRepository.findByPnr(pnr);
	}

	@Transactional
	public void delete(UserReservation userReservation) {
        userReservationSystemRepository.delete(userReservation);
	}

}
