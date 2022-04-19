package com.ssafy.myapp.model.dao;

import java.sql.SQLException;

import com.ssafy.myapp.model.dto.User;

public interface UserDAO {

	String login(String id, String pass) throws SQLException;

	void signin(User user) throws SQLException;

	User userInfo(String id);

}