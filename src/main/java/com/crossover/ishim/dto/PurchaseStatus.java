package com.crossover.ishim.dto;

import java.io.Serializable;

public class PurchaseStatus extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long purchaseStatusID;
	private String description;
	
	public Long getPurchaseStatusID() {
		return purchaseStatusID;
	}
	public void setPurchaseStatusID(Long purchaseStatusID) {
		this.purchaseStatusID = purchaseStatusID;
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
	private Boolean status;

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
