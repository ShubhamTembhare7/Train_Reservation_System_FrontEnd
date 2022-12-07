package com.yash.reservation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.reservation.entity.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
