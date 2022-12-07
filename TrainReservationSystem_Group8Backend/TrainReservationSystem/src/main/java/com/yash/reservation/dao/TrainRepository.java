package com.yash.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.Train;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {

}
