package com.yash.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "com.yash.reservation.entity")
public class TrainReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainReservationSystemApplication.class, args);
	}

}
