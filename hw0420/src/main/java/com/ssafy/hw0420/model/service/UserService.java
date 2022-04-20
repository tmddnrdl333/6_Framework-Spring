package com.ssafy.hw0420.model.service;

import java.sql.SQLException;

public interface UserService {
	String login(String id, String pass) throws SQLException;
}
