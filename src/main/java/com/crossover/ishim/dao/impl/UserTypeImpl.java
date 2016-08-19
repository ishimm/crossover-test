package com.crossover.ishim.dao.impl;

import java.util.List;
import java.util.Map;

import com.crossover.ishim.dao.GenericDao;
import com.crossover.ishim.dao.TableFilter;
import com.crossover.ishim.dto.UserType;

public class UserTypeImpl implements GenericDao<UserType, String> {

	@Override
	public List<UserType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> getAllDistinct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserType save(UserType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserType> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> findByExample(UserType example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> getPaging(int offset, int limit, String sortDir, String sortField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> getPagingWithFilter(List<TableFilter> filters, int offset, int limit, String sortDir,
			String sortField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getCountWithFilter(List<TableFilter> filters) {
		// TODO Auto-generated method stub
		return null;
	}

}
