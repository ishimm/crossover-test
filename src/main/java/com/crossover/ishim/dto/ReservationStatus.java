package com.crossover.ishim.dto;

import java.io.Serializable;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class ReservationStatus extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Integer reservationStatusID;
	private String description;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		ReservationStatus o = new ReservationStatus();
		o.setReservationStatusID(getReservationStatusID());
		o.setDescription(getDescription());
		o.setStatus(getStatus());
		return o;
	}


	public Integer getReservationStatusID() {
		return reservationStatusID;
	}


	public void setReservationStatusID(Integer reservationStatusID) {
		this.reservationStatusID = reservationStatusID;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
