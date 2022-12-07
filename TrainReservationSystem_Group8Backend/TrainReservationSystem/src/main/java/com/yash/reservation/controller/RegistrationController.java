package com.yash.reservation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.reservation.entity.User;
import com.yash.reservation.model.ResponseModel;
import com.yash.reservation.model.UserModel;
import com.yash.reservation.service.RegistrationService;

@RestController
@CrossOrigin("*")
public class RegistrationController {

	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	RegistrationService regService;

	@PostMapping("/userRegistration")
	public ResponseModel userRegistration(@RequestBody UserModel user) {
		log.info("Insied method : userRegistration class: RegistrationController");
		return regService.userRegistration(user);
	}

	// for login check
	@PostMapping("/userLoginCheck")
	public User loginUser(@RequestBody User user) {
		log.info("" + user.toString());
		log.info("Insied method : getUserDetails class: RegistrationController");

		if (verifyUserDetails(user.getUserName(), user.getPassword())) {
			return regService.loginCheck(user);
		} else {

			return user;

		}
	}

	private boolean verifyUserDetails(String userName, String password) {
		log.info("Inside method : verifyUserDetails class: RegistrationController");
		if ((null != userName && !userName.isEmpty()) && (null != password && !password.isEmpty())) {
			return true;
		} else {
			return false;
		}

	}

	@GetMapping("/getAllUserData")
	public List<UserModel> getAllData() {
		return regService.getAllData();

	}

//	@DeleteMapping("/deleteUserDetails/{userId}")
//	public String deleteUserDetails(@PathVariable long userId) {
//		regService.deleteUserDetails(userId);
//		return "delete data successfully";
//
//	}

	@PutMapping("/updateUser/{id}")
	public ResponseModel updateData(@RequestBody UserModel u, @PathVariable long id) {
		return regService.updateUser(u, id);
	}

//	@GetMapping("/getUserDetails/{userName}/{password}")
//	public ResponseModel getUserDetails(@PathVariable("userName") String userName,
//			@PathVariable("password") String password) {
//		log.info("Insied method : getUserDetails class: RegistrationController");
//
//		return regService.getUserDetails(userName, password);
//
//	}

}
