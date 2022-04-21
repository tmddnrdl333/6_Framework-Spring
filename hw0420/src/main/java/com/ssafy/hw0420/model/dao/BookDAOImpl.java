package com.ssafy.hw0420.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.hw0420.model.dto.Book;
import com.ssafy.hw0420.util.DBUtil;

@Repository
public class BookDAOImpl implements BookDAO {

	@Override
	public boolean insertBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into book values (?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setInt(4, book.getPrice());
			stmt.setString(5, book.getDesc());
			stmt.setString(6, book.getImg());
			int rowCount = stmt.executeUpdate();
			return rowCount > 0;
		} finally {
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public List<Book> selectBookList() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from book";
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6)));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt, conn);
		}
		return list;
	}

	@Override
	public Book selectBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from book where isbn=?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt, conn);
		}
		return null;
	}

	@Override
	public boolean updateBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update book set title=?, author=?, price=?, `desc`=?, img=? where isbn=?"; // desc?
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setInt(3, book.getPrice());
			stmt.setString(4, book.getDesc());
			stmt.setString(5, book.getImg());
			stmt.setString(6, book.getIsbn());
			int rowCount = stmt.executeUpdate();
			return rowCount > 0;
		} finally {
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public boolean deleteBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from book where isbn=?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, isbn);
			int rowCount = stmt.executeUpdate();
			return rowCount > 0;
		} finally {
			DBUtil.close(stmt, conn);
		}
	}

}
