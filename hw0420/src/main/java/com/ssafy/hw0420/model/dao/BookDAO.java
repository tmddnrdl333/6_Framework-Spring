package com.ssafy.hw0420.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hw0420.model.dto.Book;

public interface BookDAO {

	boolean insertBook(Book book) throws SQLException;

	List<Book> selectBookList() throws SQLException;

	Book selectBook(String isbn) throws SQLException;

	boolean updateBook(Book book) throws SQLException;

	boolean deleteBook(String isbn) throws SQLException;
}
