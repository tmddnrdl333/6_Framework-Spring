package com.ssafy.myapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.myapp.util.DBUtil;

@Repository
public class UserDAOImpl implements UserDAO{

	@Override
	public String login(String id,String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select name from userinfo where userid = ? and password= ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2,pass);

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
		return null;
		
	}
}
