package com.oibsip.kanchu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainService {

	@Autowired
	UserReservationSystemRepository userReservationSystemRepository;
	
	@Transactional
    public void saveReservation(UserReservation userReservation) {
        userReservationSystemRepository.save(userReservation);
    }
}
