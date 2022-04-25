package com.ssafy.myapp.model.service;

import java.sql.SQLException;

public interface UserService {

	String[] login(String id, String pass) throws SQLException;

	void modifyProfile(String id, String profile) throws SQLException;
}