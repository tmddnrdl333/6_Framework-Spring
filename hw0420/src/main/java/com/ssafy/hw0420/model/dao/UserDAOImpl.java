package com.ssafy.hw0420.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.ssafy.hw0420.model.dao.UserDAO.";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String login(Map<String, String> userinfo) {
		return sqlSession.selectOne(NAME_SPACE + "selectUser", userinfo);
	}

}
