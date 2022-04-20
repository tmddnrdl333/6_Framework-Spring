package com.ssafy.hw0420.model.service;

import java.sql.SQLException;
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
	public boolean registBook(Book book) throws SQLException {
		if (getBook(book.getIsbn()) != null) {
			throw new IllegalArgumentException("이미 등록된 번호입니다.");
		}
		return bookDao.insertBook(book);
	}

	@Override
	public List<Book> getBookList() throws SQLException {
		return bookDao.selectBookList();
	}

	@Override
	public Book getBook(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
