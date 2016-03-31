package com.sumahe.jdbcPractice.dao;

import java.util.List;

import com.sumahe.jdbcPractice.Bean.User;

public interface UserService {
	public void save(User user);

	public void delete(String id);

	public List<User> getUser();
}
