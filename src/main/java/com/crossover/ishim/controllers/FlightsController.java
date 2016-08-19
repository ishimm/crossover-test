package com.crossover.ishim.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crossover.ishim.dto.City;
import com.crossover.ishim.dto.Flight;
import com.crossover.ishim.service.ManageFlightsService;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.http.Resolver;

/**
 * Maps a URI and resolves to a Thymeleaf template
 * @author Ishim Manon
 *
 */
@Controller
public class FlightsController {
	@Autowired
	Application app;

	@Value("#{ @environment['web.cross.link'] }")
	String crossLink;

	@Autowired
	Resolver<String> stormpathOrganizationNameKeyResolver;
	
	@Autowired
	ManageFlightsService manageFlightsService;

	@RequestMapping("/searchFlights")
	public String searchFlights(Model model, HttpServletRequest req) {
		City departureCity = (City)req.getAttribute("js-origin-input");
		City arrivalCity = (City)req.getAttribute("js-destination-input");
		Date departureTime = (Date)req.getAttribute("js-depart-input");
		Date arrivalTime = (Date)req.getAttribute("js-return-input");
		List<Flight> flights = manageFlightsService.getFlightByFilters(departureCity, arrivalCity, departureTime, arrivalTime);
		
		model.addAttribute("flights", flights);
		return "redirect:/flightsResult";
	}
}
