package com.yash.reservation.dao;

import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.User;

@Repository
public interface ReservationDao {
	
	public User getUserDetails(String userName,String password);

	public void userRegistration(User userEntity);
	

}
