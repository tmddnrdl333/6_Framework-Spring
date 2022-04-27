package com.ssafy.hw0420.model.service;

import java.util.List;

import com.ssafy.hw0420.model.dto.Book;

public interface BookService {
	boolean registBook(Book book);

	boolean modifyBook(Book book);

	boolean removeBook(String isbn);

	Book getBook(String isbn);

	List<Book> getBookList();
}
