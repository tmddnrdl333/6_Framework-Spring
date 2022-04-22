package com.ssafy.hw0420.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw0420.model.dao.BookDAO;
import com.ssafy.hw0420.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDao;

	@Autowired
	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public boolean registBook(Book book) {
		if (getBook(book.getIsbn()) != null) {
			throw new IllegalArgumentException("이미 등록된 번호입니다.");
		}
		return bookDao.insertBook(book);
	}

	@Override
	public boolean modifyBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public boolean removeBook(String isbn) {
		return bookDao.deleteBook(isbn);
	}

	@Override
	public Book getBook(String isbn) {
		return bookDao.selectBook(isbn);
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.selectBookList();
	}

}
