package com.ssafy.hw0420.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hw0420.model.dto.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.ssafy.hw0420.model.dao.BookDAO.";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean insertBook(Book book) {
		return sqlSession.insert(NAME_SPACE + "insertBook", book) > 0;
	}

	@Override
	public boolean updateBook(Book book) {
		return sqlSession.update(NAME_SPACE + "updateBook", book) > 0;
	}

	@Override
	public boolean deleteBook(String isbn) {
		return sqlSession.delete("deleteBook", isbn) > 0;
	}

	@Override
	public Book selectBook(String isbn) {
		return sqlSession.selectOne(NAME_SPACE + "selectBook", isbn);
	}

	@Override
	public List<Book> selectBookList() {
		return sqlSession.selectList(NAME_SPACE + "selectBookList");
	}

}
