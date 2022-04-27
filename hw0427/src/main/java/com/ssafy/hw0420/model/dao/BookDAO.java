package com.ssafy.hw0420.model.dao;

import java.util.List;

import com.ssafy.hw0420.model.dto.Book;

public interface BookDAO {

	boolean insertBook(Book book);

	boolean updateBook(Book book);

	boolean deleteBook(String isbn);

	Book selectBook(String isbn);

	List<Book> selectBookList();

}
