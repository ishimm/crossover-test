package com.crossover.ishim.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class Flight extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long flightID;
	private City departureCity;
	private City arrivalCity;
	private Date departureTime;
	private Date arrivalTime;
	private Airline airline;
	private Double cost;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		Flight o = new Flight();
		o.setFlightID(getFlightID());
		if(getDepartureCity() !=null){
			o.setDepartureCity((City)getDepartureCity().createDomain());
		}
		if(getArrivalCity() !=null){
			o.setArrivalCity((City)getArrivalCity().createDomain());
		}
		o.setDepartureTime(getDepartureTime());
		o.setArrivalTime(getArrivalTime());
		if(getAirline() !=null){
			o.setAirline((Airline)getAirline().createDomain());
		}
		o.setCost(getCost());
		o.setStatus(getStatus());
		return o;
	}

	public Long getFlightID() {
		return flightID;
	}

	public void setFlightID(Long flightID) {
		this.flightID = flightID;
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
