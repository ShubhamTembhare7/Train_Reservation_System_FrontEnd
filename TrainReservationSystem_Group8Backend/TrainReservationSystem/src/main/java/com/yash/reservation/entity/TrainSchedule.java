package com.yash.reservation.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TRAIN_SCHEDULE")
public class TrainSchedule {

	@Id
	@Column(name = "SCHEDULE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long scheduleId;

	/*
	 * @Column(name = "STATION")
	 * 
	 * @Enumerated(EnumType.STRING) private Station stop;
	 */

	@Column(name = "DEPART_TIME_AT_STATION")
	///@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate departTime;

	@Column(name = "DEPART_STATION")
	private String departCity;

	@Column(name = "ARRIVAL_STATION")
	private String arrivalCity;

	@Column(name = "ARRIVAL_TIME_AT_STATION")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate arrivalTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TRAIN_ID")
	private Train train;

	public TrainSchedule() {
		super();
	}

	public TrainSchedule(Station stop, LocalDate departTime, Train train) {
		super();
		this.departTime = departTime;
		this.train = train;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
	

	public LocalDate getDepartTime() {
		return departTime;
	}

	public void setDepartTime(LocalDate departTime) {
		this.departTime = departTime;
	}

	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "TrainSchedule [scheduleId=" + scheduleId + ", departTime=" + departTime + ", departCity=" + departCity
				+ ", arrivalCity=" + arrivalCity + ", arrivalTime=" + arrivalTime + ", train=" + train + "]";
	}

}
