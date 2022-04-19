package com.ssafy.myapp.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dao.UserDAO;
import com.ssafy.myapp.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDao;
	
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String login(String id, String pass) throws SQLException {
		return userDao.login(id, pass);
	}

	@Override
	public void signin(User user) throws SQLException {
		userDao.signin(user);
		return;
	}

	@Override
	public User userInfo(String id) throws SQLException {
		return userDao.userInfo(id);
	}
}
