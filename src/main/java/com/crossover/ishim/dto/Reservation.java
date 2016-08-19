package com.crossover.ishim.dto;

import java.io.Serializable;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class Reservation extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long reservationID;
	private User user;
	private ReservationStatus reservationStatus;
	private Flight fromFligth;
	private Flight toFlight;
	private String fromFlightSeat;
	private String toFlightSeat;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		Reservation o = new Reservation();
		//TODO: Finish coding as other DTOs
		return o;
	}

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Flight getFromFligth() {
		return fromFligth;
	}

	public void setFromFligth(Flight fromFligth) {
		this.fromFligth = fromFligth;
	}

	public Flight getToFlight() {
		return toFlight;
	}

	public void setToFlight(Flight toFlight) {
		this.toFlight = toFlight;
	}

	public String getFromFlightSeat() {
		return fromFlightSeat;
	}

	public void setFromFlightSeat(String fromFlightSeat) {
		this.fromFlightSeat = fromFlightSeat;
	}

	public String getToFlightSeat() {
		return toFlightSeat;
	}

	public void setToFlightSeat(String toFlightSeat) {
		this.toFlightSeat = toFlightSeat;
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
