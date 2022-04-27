package com.ssafy.hw0420.model.dao;

import java.util.Map;

public interface UserDAO {
	String selectUser(Map<String, String> userinfo);
}
