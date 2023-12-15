package com.oibsip.kanchu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.oibsip.kanchu")


public class OnlineReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineReservationSystemApplication.class, args);
	}
	

}
