package com.crossover.ishim.dao.impl;

import java.util.List;
import java.util.Map;

import com.crossover.ishim.dao.TableFilter;
import com.crossover.ishim.dao.UserDao;
import com.crossover.ishim.dto.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllDistinct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User save(User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByExample(User example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPaging(int offset, int limit, String sortDir, String sortField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPagingWithFilter(List<TableFilter> filters, int offset, int limit, String sortDir,
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
