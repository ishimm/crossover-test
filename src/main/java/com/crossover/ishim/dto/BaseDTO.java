package com.crossover.ishim.dto;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = -4687520815745655220L;
	
	/**
     * Returns a multi-line String with key=value pairs.
     * @return a String representation of this class.
     */
	@Override
    public abstract String toString();

    /**
     * Compares object equality. When using Hibernate, the primary key should
     * not be a part of this comparison.
     * @param o object to compare to
     * @return true/false based on equality tests
     */
	@Override
    public abstract boolean equals(Object o);

    /**
     * When you override equals, you should override hashCode. See "Why are
     * equals() and hashCode() importation" for more information:
     * http://www.hibernate.org/109.html
     * @return hashCode
     */
	@Override
    public abstract int hashCode();
	
	public Object createDomain(){
		return null;
	}

}