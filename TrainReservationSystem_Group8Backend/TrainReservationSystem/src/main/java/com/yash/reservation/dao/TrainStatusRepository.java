package com.yash.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.TrainStatus;

@Repository
public interface TrainStatusRepository extends CrudRepository<TrainStatus, Long> {

}
