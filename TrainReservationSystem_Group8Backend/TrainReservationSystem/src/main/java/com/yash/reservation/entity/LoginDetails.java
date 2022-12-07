package com.yash.reservation.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN_DETAILS")
public class LoginDetails {
	
	
	@Id
	private Integer id;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;
	
	
	@Column(name="LOGIN_TIME")
	private LocalDateTime loginDate;
	
	
	@Column(name="LOGOUT_TIME")
	private LocalDateTime logOutTime;
	
	@Column(name="LOG_STATUS")
	private String logStatus;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public LocalDateTime getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(LocalDateTime logOutTime) {
		this.logOutTime = logOutTime;
	}

	public String getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}

	

}
