package com.crossover.ishim.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class Purchase extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long purchaseID;
	private User user;
	private Reservation reservation;
	private Date dateOfPurchase;
	private CreditCard creditCard;
	private Double Price;
	private PurchaseStatus purchaseStatus;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		Purchase o = new Purchase();
		//Repeat as similar clases
		o.setStatus(getStatus());
		return o;
	}


	public Long getPurchaseID() {
		return purchaseID;
	}


	public void setPurchaseID(Long purchaseID) {
		this.purchaseID = purchaseID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}


	public CreditCard getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	public Double getPrice() {
		return Price;
	}


	public void setPrice(Double price) {
		Price = price;
	}


	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}


	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
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
