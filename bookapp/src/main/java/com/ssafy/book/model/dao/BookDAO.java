package com.ssafy.book.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.book.model.dto.Book;

public interface BookDAO {

	Book selectBook(String isbn);

	List<Book> selectBookList();

	List<Book> selectBookListByCondition(Map<String, String> condition);

	boolean insertBook(Book book);

	boolean updateBook(Book book);

	boolean deleteBook(String isbn);
}
