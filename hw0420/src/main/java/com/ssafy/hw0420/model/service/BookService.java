package com.ssafy.hw0420.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hw0420.model.dto.Book;

public interface BookService {
	boolean registBook(Book book) throws SQLException;

	List<Book> getBookList() throws SQLException;

	Book getBook(String isbn) throws SQLException;
}
