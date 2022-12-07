package com.yash.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByuserNameAndPassword(String tempUserName, String tempUserPass);

}
