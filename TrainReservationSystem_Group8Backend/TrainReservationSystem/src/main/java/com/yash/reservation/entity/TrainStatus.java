package com.yash.reservation.entity;

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

@Entity
@Table(name = "TRAIN_STATUS")
public class TrainStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATUS_ID")
	private long statusId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TRAIN_ID")
	private Train train;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "SEAT_STATUS", nullable = false)
	private String seatStatus;

	@Column(name = "IS_CANCELLED")
	private boolean isCancelled;

	public TrainStatus() {
		super();
	}

	public TrainStatus(Train train, Date date, boolean isCancelled) {
		super();
		this.train = train;
		this.date = date;
		this.isCancelled = isCancelled;
	}

	public long getStatusId() {
		return statusId;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
}