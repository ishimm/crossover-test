package com.crossover.ishim.dao;

public interface TableFilter {
	
	void setProperty(String property);
	void setComparison(String property);
	void setValue(Object property);
	void setType(String property);
}
