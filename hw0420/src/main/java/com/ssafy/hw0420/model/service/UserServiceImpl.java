package com.ssafy.hw0420.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw0420.model.dao.UserDAO;

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

}
