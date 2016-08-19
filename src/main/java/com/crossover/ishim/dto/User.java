package com.crossover.ishim.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Class representing a user DTO
 * @author Ishim Manon
 *
 */
public class User extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = -8161067367128964968L;
	
	private String userID;
	private String name;
	private String email;
	private String password;
	private UserType userType;
	private List<CreditCard> crediCards;
	private Boolean status;
	
	@Override
	public Object createDomain() {
		User user = new User();
		user.setUserID(getUserID());
		user.setName(getName());
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		user.setStatus(getStatus());
		if(getUserType() !=null){
			user.setUserType((UserType)getUserType().createDomain());
		}
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+getName();
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CreditCard> getCrediCards() {
		return crediCards;
	}

	public void setCrediCards(List<CreditCard> crediCards) {
		this.crediCards = crediCards;
	}
}
