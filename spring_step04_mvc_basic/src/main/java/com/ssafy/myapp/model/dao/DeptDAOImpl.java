package com.ssafy.myapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.util.DBUtil;

@Repository
public class DeptDAOImpl implements DeptDAO {

	@Override
	public boolean insertDept0(Dept dept) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into dept values("+dept.getDeptno()+",'"+dept.getDname()+"','"+dept.getLoc()+"')";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			int rowCount = stmt.executeUpdate(sql);
			return rowCount>0;
		}finally {
			DBUtil.close(stmt,conn);
		} 
	}
	
	@Override
	public boolean insertDept(Dept dept) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into dept values(?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			int rowCount = stmt.executeUpdate();
			return rowCount>0;
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
	}
	@Override
	public Dept selectDept(int deptNo) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where deptno = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptNo);

			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3));
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
		return null;
	}
	@Override
	public List<Dept> selectDeptList() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept";
		ArrayList<Dept> list = new ArrayList<Dept>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				 list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
		return list;
	}
	@Override
	public boolean deleteDept(int deptNo) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from dept where deptno =?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, deptNo);

			int rowCount = stmt.executeUpdate();
			return rowCount>0;
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
	}
	@Override
	public boolean updateDept(Dept dept) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update dept set dname=? , loc=? where deptno=?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc());
			stmt.setInt(3, dept.getDeptno());
			int rowCount = stmt.executeUpdate();
			return rowCount>0;
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
	}
	
	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	@Override
	public List<Dept> selectDeptListByName(String dName) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where dname like ? ";
//		String sql = "select deptno,dname,loc from dept where dname like concat('%',?,'%') ";
		ArrayList<Dept> list = new ArrayList<Dept>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+dName+"%");
//			stmt.setString(1, dName);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				 list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		} 
		return list;
	}
}















