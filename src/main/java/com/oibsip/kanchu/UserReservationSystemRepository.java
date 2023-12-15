	package com.oibsip.kanchu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReservationSystemRepository extends JpaRepository<UserReservation, Integer> {

	Optional<UserReservation> findByUserIDAndUserPassword(String userID, String userPassword);

	Optional<UserReservation> findTopByOrderByPnrDesc();

	Optional<UserReservation> findByPnr(Integer pnr);	

	void deleteByPnr(UserReservation userReservation);
}