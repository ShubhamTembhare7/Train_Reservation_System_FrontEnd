package com.yash.reservation.daoImpl;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.reservation.dao.LoginDao;
import com.yash.reservation.entity.LoginDetails;
import com.yash.reservation.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	
	private static final Logger log = LoggerFactory.getLogger(LoginDaoImpl.class);

	
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional
	public void addLoginDetails(User userEntity,String logStatus) {
		log.info("In method:addLoginDetails in class :LoginDaoImpl");
		try {
		LocalDateTime loginDate= LocalDateTime.now();
		LoginDetails loginDetails= new LoginDetails();
		loginDetails.setLoginDate(loginDate);
		loginDetails.setUser(userEntity);
		loginDetails.setLogStatus(logStatus);
		entityManager.persist(loginDetails);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public LoginDetails getUserLoginDetails(String userName, String userPassword) {
		log.info("In method:addLoginDetails in class :LoginDaoImpl");
		try {
			entityManager.createQuery("select from LoginDetails where ");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	

}
