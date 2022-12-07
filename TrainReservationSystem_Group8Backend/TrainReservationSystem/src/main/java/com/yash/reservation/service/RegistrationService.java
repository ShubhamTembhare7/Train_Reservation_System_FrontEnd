package com.yash.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.reservation.entity.User;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.TicketReservationModel;
import com.yash.reservation.model.UserModel;

@Service
public interface RegistrationService {
	
	public ResponseModel userRegistration(UserModel user);
	public User loginCheck(User user);
	public List<UserModel> getAllData();
	public void deleteUserDetails(long userId);
	public ResponseModel updateUser(UserModel u, long id);

	
//	public ResponseModel getUserDetails(String username, String password);

	

	
	

	

	

	


}
