package com.yash.reservation.dao;

import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.LoginDetails;
import com.yash.reservation.entity.User;

@Repository
public interface LoginDao {

	public void addLoginDetails(User userEntity, String logStatus);
	
	public LoginDetails getUserLoginDetails(String userName, String userPassword);

}
