package com.crossover.ishim.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class CreditCard extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private String creditCardNumber;
	private String cardType;
	private Integer cvvNumber;
	private Date expiryDate;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		CreditCard o = new CreditCard();
		//TODO: Code as similar classes
		return o;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(Integer cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
