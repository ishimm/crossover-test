package com.crossover.ishim.service;

import java.util.List;

import com.crossover.ishim.dto.Reservation;
import com.crossover.ishim.dto.ReservationStatus;
import com.crossover.ishim.dto.User;

public interface ReservationService  {
	List<Reservation> getReservationsByUser(User user);
	List<Reservation> getAllConfirmedReservations(ReservationStatus confirmed);
	Boolean cancelReservation(Reservation reservation);
	Boolean cancelReservation(Long reservationId, User user);
	
}
