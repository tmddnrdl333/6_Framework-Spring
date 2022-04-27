package com.ssafy.book.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.book.model.dto.Book;

public interface BookService {

	Book getBook(String isbn);

	List<Book> getBookList();

	List<Book> searchBookList(Map<String, String> condition);

	boolean registBook(Book book);

	boolean modifyBook(Book book);

	boolean removeBook(String isbn);
}
