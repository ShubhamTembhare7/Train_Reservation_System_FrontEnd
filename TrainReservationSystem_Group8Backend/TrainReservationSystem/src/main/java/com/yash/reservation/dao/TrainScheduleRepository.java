package com.yash.reservation.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.TrainSchedule;

@Repository
public interface TrainScheduleRepository extends CrudRepository<TrainSchedule, Long> {

	ArrayList<TrainSchedule> findByDepartCityAndArrivalCity(String fromCity, String toCity);

	ArrayList<TrainSchedule> findByDepartCityAndArrivalCityAndDepartTimeAndArrivalTime(String from, String to,
			LocalDate departDate, LocalDate returnDate);

}
