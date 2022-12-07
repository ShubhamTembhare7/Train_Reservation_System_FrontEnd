package com.yash.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.reservation.entity.TrainSchedule;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.TrainDetailsModel;
import com.yash.reservation.service.TrainDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class TrainDetailsController {

	private static final Logger log = LoggerFactory.getLogger(TrainDetailsController.class);

	@Autowired
	TrainDetailsService trainDetailsService;

	@PostMapping("/checkTrainDetails")
	public ResponseModel checkTrainsAvailability(@RequestBody TicketReservationModel ticketReservationModel) {
		log.info("Inside method : getTrainDetails class: RegistrationController");
		log.info("ticketReservationModel: To" + ticketReservationModel.getTo());
		return trainDetailsService.getTrainDetails(ticketReservationModel);
	}

	@GetMapping("/checkTrainDetails")
	public ArrayList<TicketReservationModel> checkTrainsAvailability() {
		log.info("Inside method : getTrainDetails class: RegistrationController");
		return trainDetailsService.getTrainSearchDetails();
	}

//	@GetMapping("/checkSingleTrainDetails/{}/{}")
//	public ArrayList<TicketReservationModel> checkTrains() {
//		log.info("Inside method : getTrainDetails class: RegistrationController");
//		return trainDetailsService.getTrainSearchDetails();
//	}

//	  @PostMapping("/getTrainDetails") public ResponseModel
//	  getTrainDetails(@RequestBody TicketReservationModel ticketReservationModel) {
//	  log.info("Inside method : getTrainDetails class: RegistrationController");
//	  log.info("ticketReservationModel: To"+ticketReservationModel.getTo()); return
//	  trainDetailsService.getTrainDetails(ticketReservationModel); }

	@PostMapping("/ticketBooking")
	public ResponseModel ticketBooking(@RequestBody TrainDetailsModel model) {
		log.info("Inside method : ticketBooking class: RegistrationController");
		return trainDetailsService.ticketBooking(model);
	}

}
