package com.crossover.ishim.dto;

import java.io.Serializable;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class Airline extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long airlineID;
	private String name;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		Airline o = new Airline();
		o.setAirlineID(getAirlineID());
		o.setName(getName());
		o.setStatus(getStatus());
		return o;
	}


	public Long getAirlineID() {
		return airlineID;
	}


	public void setAirlineID(Long airlineID) {
		this.airlineID = airlineID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
