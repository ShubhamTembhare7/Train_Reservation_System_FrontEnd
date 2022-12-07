package com.yash.reservation.serviceImpl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.reservation.dao.TicketRepository;
import com.yash.reservation.dao.TrainRepository;
import com.yash.reservation.dao.TrainScheduleRepository;
import com.yash.reservation.dao.TrainStatusRepository;
import com.yash.reservation.entity.Ticket;
import com.yash.reservation.entity.TrainSchedule;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.TrainDetailsModel;
import com.yash.reservation.service.TrainDetailsService;
import com.yash.reservation.utility.StatusCodes;

@Service
public class TrainDetailsServiceImpl implements TrainDetailsService {

	private static final Logger log = LoggerFactory.getLogger(TrainDetailsServiceImpl.class);

	@Autowired
	TrainRepository trainRepository;

	@Autowired
	TrainScheduleRepository trainScheduleRepository;

	@Autowired
	TrainStatusRepository trainStatusRepository;

	@Autowired
	ResponseModel responseModel;
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public ResponseModel getTrainDetails(TicketReservationModel ticketReservationModel) {

		log.info("In method:getTrainDetails in class: TrainDetailsServiceImpl");
		try {

			ArrayList<TrainSchedule> trainScheduleList = (ArrayList<TrainSchedule>) trainScheduleRepository
					.findByDepartCityAndArrivalCityAndDepartTimeAndArrivalTime(ticketReservationModel.getFrom(),
							ticketReservationModel.getTo(), ticketReservationModel.getDepartDate(),
							ticketReservationModel.getReturnDate());

			if (trainScheduleList!=null&&trainScheduleList.isEmpty()) {
				log.info("trainScheduleList is Empty");
				responseModel.setResponseCode(StatusCodes.ERROR);
				responseModel.setResponseMessage(StatusCodes.NO_REQ_TRAINS);
			} else {
				responseModel.setResponseCode(StatusCodes.SUCCESS);
				responseModel.setResponseMessage(StatusCodes.TRAIN_SEARCH_SUCCESS);
				responseModel.setResponseObj(trainScheduleList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseModel.setResponseCode(StatusCodes.ERROR);
			responseModel.setResponseMessage(StatusCodes.EXCP_TRAIN_DETAILS);
		}
		return responseModel;
	}

	

	
	@Override
	public ResponseModel ticketBooking(TrainDetailsModel model) {
		log.info("In method:ticketBooking in class: TrainDetailsServiceImpl");
		Ticket ticket= getTicketEntity(model);
		ticketRepository.save(ticket);
		return responseModel;
	}

	private Ticket getTicketEntity(TrainDetailsModel model) {
		Ticket ticket= new Ticket();
		ticket.setArrivalStation(model.getArrivalCity());
		ticket.setCancelled(false);
		ticket.setDepartDate(model.getDepartTime());
		ticket.setDepartStation(model.getDepartCity());
		ticket.setNumOfSeats(model.getNoOfSeats());
		ticket.setPassenger(model.getPassenger());
		ticket.setPrice(model.getPrice());
		//ticket.setReturnDate(mode);
		return null;
	}




	@Override
	public  ArrayList<TicketReservationModel> getTrainSearchDetails() {
		log.info("Inside method: getTrainSearchDetails in class: TrainDetailsServiceImpl");
		ArrayList<TrainSchedule> list= (ArrayList<TrainSchedule>) trainScheduleRepository.findAll();
		//ArrayList<TrainSchedule> list= (ArrayList<TrainSchedule>) trainScheduleRepository.findByDepartCityAndArrivalCity(fromCity,toCity);
		ArrayList<TicketReservationModel> resultList= new ArrayList<>();
		if(!list.isEmpty()) {
			list.forEach(e->{
				TicketReservationModel model = new TicketReservationModel();
				model.setDepartDate(e.getDepartTime());
				model.setReturnDate(e.getArrivalTime());
				model.setFrom(e.getDepartCity());
				model.setTo(e.getArrivalCity());
				model.setTravelClass(e.getTrain().getType());
				//model.setJourneyType(e.getTrain().getType());
				model.setScheduleId(e.getScheduleId());
				model.setTrainName(e.getTrain().getTrainName());
				resultList.add(model);
			});
		}
		
		return resultList;
	}


}
