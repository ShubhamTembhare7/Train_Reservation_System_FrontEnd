package com.yash.reservation.serviceImpl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.reservation.dao.ReservationDao;
import com.yash.reservation.dao.UserRepository;
import com.yash.reservation.entity.User;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.UserModel;
import com.yash.reservation.service.RegistrationService;
import com.yash.reservation.utility.StatusCodes;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	ReservationDao reservationDao;

	@Autowired
	UserRepository ur;

	@Autowired
	ResponseModel responseModel;
	
	
	@Override
	public ResponseModel userRegistration(UserModel user) {
		log.info("Inside Method: userRegistration in Class: RegistrationServiceImpl");
		try {
			User userEntity = getUserEntity(user);
			log.info(userEntity.toString());
			reservationDao.userRegistration(userEntity);
			responseModel.setResponseCode(StatusCodes.SUCCESS);
			responseModel.setResponseMessage(StatusCodes.REGSUCCESS);
		} catch (Exception e) {
			log.debug("Exception in method : userRegistration in Class:RegistrationServiceImpl");
			log.info(e.getMessage());
		}
		return responseModel;
	}

	private User getUserEntity(UserModel user) {
		User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setDateOfBirth(user.getDateOfBirth());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setGender(user.getGender());
		userEntity.setLastName(user.getLastName());
		userEntity.setMobileNumber(user.getMobileNumber());
		//userEntity.setPassword(user.getPassword());
		//To encrypt password    
        String encodedPwd = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        userEntity.setPassword(encodedPwd);
		userEntity.setUserName(user.getUserName());
		return userEntity;
	}

	@Override
	public User loginCheck(User user) {
		User userobj = ur.findByuserNameAndPassword(user.getUserName(), user.getPassword());
		String tempUserName = userobj.getUserName();
		String tempUserPass = userobj.getPassword();
		// User userobj= null;
		System.out.println(tempUserName + "=" + tempUserPass);
		if (tempUserName != null && tempUserPass != null) {

			if (user.getUserName().equals(tempUserName) && user.getPassword().equals(tempUserPass)) {
				return user;
			}
		}
		return userobj;
	}
	
	
	@Override
	public List<UserModel> getAllData() {

		ArrayList<UserModel> userList = new ArrayList<>();
		ArrayList<User> entityList = (ArrayList<User>) ur.findAll();
		entityList.stream().forEach(e -> {
			UserModel umodel = getUserModel(e);
			userList.add(umodel);
		});
		return userList;

	}

	private UserModel getUserModel(User user) {
		UserModel model = new UserModel();
		model.setId(user.getUserId());
		model.setDateOfBirth(user.getDateOfBirth());
		model.setEmail(user.getEmail());
		model.setFirstName(user.getFirstName());
		model.setLastName(user.getLastName());
		model.setGender(user.getGender());
		model.setMobileNumber(user.getMobileNumber());
		model.setUserName(user.getUserName());
		model.setPassword(user.getPassword());
		return model;

	}

	
	@Override
	public void deleteUserDetails(long userId) {
		ur.deleteById(userId);
	}
	
	@Override
	public ResponseModel updateUser(UserModel u, long id) {
		try {
			
			User user = getUserEntity(u);
			Optional<User> userEntity=ur.findById(id);
			
			if(userEntity.isPresent())
			{
				user.setUserId(id);
				ur.save(user);
				responseModel.setResponseCode(StatusCodes.SUCCESS);
				responseModel.setResponseMessage(StatusCodes.REGUPDATESUCCESS);
				return responseModel;
				
			}
			else {
				responseModel.setResponseCode(StatusCodes.ERROR);
				responseModel.setResponseMessage(StatusCodes.REGUPDATEERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseModel.setResponseCode(StatusCodes.ERROR);
			responseModel.setResponseMessage(StatusCodes.REGUPDATEERROR);
		}
		
		return responseModel;
	}

	
	
	
	
	
	
	
	

//	@Override
//	public ResponseModel getUserDetails(String userName, String password) {
//		try {
//			User user = reservationDao.getUserDetails(userName, password);
//			if (user != null) {
//				/*
//				 * // If user in Login Details Table then
//				 * responseModel.setResponseCode(StatusCodes.ERROR);
//				 * responseModel.setResponseMessage(StatusCodes.USER_ALREADY_LOGIN_ERROR);
//				 * 
//				 * // if User not in LoginDetails table then // --- Add entry in Login Details
//				 * table to restrict login access -- loginDao.addLoginDetails(user,
//				 * StatusCodes.ENTER);
//				 */
//				responseModel.setResponseCode(StatusCodes.SUCCESS);
//				responseModel.setResponseMessage(StatusCodes.REGSUCCESS);
//				responseModel.setResponseObj(user);
//			} else {
//				responseModel.setResponseCode(StatusCodes.ERROR);
//				responseModel.setResponseMessage(StatusCodes.INVALID_USER_CREDS);
//			}
//		} catch (NoResultException e) {
//			responseModel.setResponseCode(StatusCodes.ERROR);
//			responseModel.setResponseMessage(StatusCodes.INVALID_USER_CREDS);
//		} catch (Exception e) {
//			responseModel.setResponseCode(StatusCodes.ERROR);
//			responseModel.setResponseMessage(StatusCodes.EXCEPTION_LOGIN);
//		}
//		return responseModel;
//	}

	
	
	

	
	

	
	
	
	
}
