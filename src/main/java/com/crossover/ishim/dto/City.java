package com.crossover.ishim.dto;

import java.io.Serializable;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class City extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Long cityID;
	private String name;
	private Country country;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		City o = new City();
		o.setCityID(getCityID());
		o.setName(getName());
		if(getCountry() !=null){
			o.setCountry((Country)getCountry().createDomain());
		}
		o.setStatus(getStatus());
		return o;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
