package com.crossover.ishim.service;

import java.util.Date;
import java.util.List;

import com.crossover.ishim.dto.City;
import com.crossover.ishim.dto.Flight;
import com.crossover.ishim.dto.User;

public interface ManageFlightsService  {
	List<Flight> getFlightByFilters(City departureCity, City arrivalCity, Date departureTime, Date arrivalTime);
	Boolean cancelFlight(Flight flight, User user);
}
