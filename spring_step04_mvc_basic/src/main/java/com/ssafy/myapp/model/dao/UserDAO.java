package com.ssafy.myapp.model.dao;

import java.sql.SQLException;

public interface UserDAO {

	String login(String id, String pass) throws SQLException;

}