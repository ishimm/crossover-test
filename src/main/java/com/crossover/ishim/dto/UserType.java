package com.crossover.ishim.dto;

import java.io.Serializable;

/**
 * Class representing a user type DTO
 * @author Ishim Manon
 *
 */
public class UserType extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private Integer userTypeID;
	private String name;
	private String description;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		UserType type = new UserType();
		type.setUserTypeID(getUserTypeID());
		type.setName(getName());
		type.setDescription(getDescription());
		type.setStatus(getStatus());
		return type;
	}

	public Integer getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(Integer userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
