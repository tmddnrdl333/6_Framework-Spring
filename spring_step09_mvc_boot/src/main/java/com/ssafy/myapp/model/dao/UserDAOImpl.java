package com.ssafy.myapp.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	private static final String NAME_SPACE = "com.ssafy.myapp.model.dao.UserDAO.";
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public String[] login(String id,String pass)  {
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", id);
		map.put("password", pass);
		
		Map<String,String> rMap= sqlSession.selectOne(NAME_SPACE+"login", map);
		return new String[] {rMap.get("userId"),rMap.get("profile")};
		 
	}


	@Override
	public void updateProfile(String id, String profile)  {
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", id);
		map.put("profile", profile);
		sqlSession.update(NAME_SPACE+"updateProfile", map);
	}

}
