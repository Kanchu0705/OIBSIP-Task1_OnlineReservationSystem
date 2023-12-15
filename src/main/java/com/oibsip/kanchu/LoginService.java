package com.oibsip.kanchu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
	@Autowired
	UserReservationSystemRepository userReservationSystemRepository;

	@Transactional
	public boolean checkLogin(String userID, String userPassword) {
		Optional<UserReservation> user = userReservationSystemRepository.findByUserIDAndUserPassword(userID, userPassword);
	    return user.isPresent();
	}

}
