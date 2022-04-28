package com.ssafy.book.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("도서 정보 REST API")
@RequestMapping("/api/books")
@RestController
public class BookController {
	BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@ApiOperation("도서 리스트를 조회합니다. (도서 번호, 제목으로 검색 가능)")
	@GetMapping
	public ResponseEntity<List<Book>> searchBook(@RequestParam(required = false) String isbn,
			@RequestParam(required = false) String title) {
		HashMap<String, String> condition = new HashMap<>();
		if (isbn != null)
			condition.put("isbn", isbn);
		if (title != null)
			condition.put("title", title);
		List<Book> list = bookService.searchBookList(condition);
		if (list.size() > 0) {
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation("도서 상세정보를 조회합니다. (도서 번호로 조회)")
	@GetMapping("/{isbn}")
	public ResponseEntity<Book> bookDetail(@PathVariable String isbn) {
		Book book = bookService.getBook(isbn);
		if (book != null) {
			return ResponseEntity.ok(book);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("신규 도서를 등록합니다.")
	@PostMapping
	public ResponseEntity registBook(@RequestBody Book book) {
		bookService.registBook(book);
		return ResponseEntity.created(URI.create("/api/books/" + book.getIsbn())).build();
	}

	@ApiOperation("도서 정보를 수정합니다.")
	@PutMapping("/{isbn}")
	public ResponseEntity bookModify(@PathVariable String isbn, @RequestBody Book book) {
		if (bookService.getBook(isbn) != null) {
			bookService.modifyBook(book);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("도서를 목록에서 삭제합니다.")
	@DeleteMapping("/{isbn}")
	public ResponseEntity bookRemove(@PathVariable String isbn) {
		if (bookService.getBook(isbn) != null) {
			bookService.removeBook(isbn);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
