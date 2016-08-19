package com.crossover.ishim.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.crossover.ishim.dto.City;
import com.crossover.ishim.dto.Flight;
import com.crossover.ishim.dto.User;
import com.crossover.ishim.service.ManageFlightsService;

public class ManageFlightsServiceImpl implements ManageFlightsService{
	public List<Flight> getFlightByFilters(City departureCity, City arrivalCity, Date departureTime, Date arrivalTime){
		List<Flight> flights = new ArrayList<>();
		return flights;
	};
	
	public Boolean cancelFlight(Flight flight, User user){
		return false;
	};
}
