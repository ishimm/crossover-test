package com.crossover.ishim.service;

import java.util.List;

import com.crossover.ishim.dto.Purchase;
import com.crossover.ishim.dto.PurchaseStatus;
import com.crossover.ishim.dto.Reservation;

public interface PurchaseFlightsService  {
	Reservation getReservationsById(Long reservationId);
	List<Purchase> getAllConfirmedPurchases(PurchaseStatus confirmed);
	Boolean setPurchaseOrder(Purchase purchase);
	
}
