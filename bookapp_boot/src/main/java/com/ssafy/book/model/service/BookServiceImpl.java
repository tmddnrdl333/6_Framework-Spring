package com.ssafy.book.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookDAO;
import com.ssafy.book.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDao;

	@Autowired
	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Book getBook(String isbn) {
		return bookDao.selectBook(isbn);
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.selectBookList();
	}

	@Override
	public List<Book> searchBookList(Map<String, String> condition) {
		return bookDao.selectBookListByCondition(condition);
	}

	@Override
	public boolean registBook(Book book) {
		if (getBook(book.getIsbn()) != null) {
			throw new IllegalArgumentException("이미 등록된 도서입니다.");
		}
		return bookDao.insertBook(book);
	}

	@Override
	public boolean modifyBook(Book book) {
		if (bookDao.selectBook(book.getIsbn()) == null) {
			throw new IllegalArgumentException("등록된 도서가 없습니다.");
		}
		return bookDao.updateBook(book);
	}

	@Override
	public boolean removeBook(String isbn) {
		if (getBook(isbn) == null) {
			return false;
		}
		return bookDao.deleteBook(isbn);
	}

}
