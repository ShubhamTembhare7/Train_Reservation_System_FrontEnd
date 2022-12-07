package com.yash.reservation.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.TrainDetailsModel;


@Service
public interface TrainDetailsService {

	ResponseModel getTrainDetails(TicketReservationModel ticketReservationModel);
	


	ResponseModel ticketBooking(TrainDetailsModel model);



	ArrayList<TicketReservationModel> getTrainSearchDetails();
	

}
