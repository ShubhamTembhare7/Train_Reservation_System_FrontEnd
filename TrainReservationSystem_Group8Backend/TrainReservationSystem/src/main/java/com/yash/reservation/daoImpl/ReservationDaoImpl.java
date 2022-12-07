package com.yash.reservation.daoImpl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.reservation.dao.ReservationDao;
import com.yash.reservation.entity.User;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	private static final Logger log = LoggerFactory.getLogger(ReservationDaoImpl.class);

	
	@Autowired
	EntityManager em;
	
	

	@Override
	
	public User getUserDetails(String userName, String password) {
		log.info("Inside method: getUserDetails in Class: ReservationDaoImpl");
		User user=(User) em.createQuery("select ur from User ur where ur.userName =:userName and ur.password =:password").setParameter("userName", userName).setParameter("password", password).getSingleResult();
		return user;
	}



	@Override
	@Transactional
	public void userRegistration(User userEntity) {
		log.info("Inside method: userRegistration in Class: ReservationDaoImpl");
		em.persist(userEntity);
		
	}
	
	
	

}
