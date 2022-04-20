package com.ssafy.hw0420.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.hw0420.model.dto.Book;
import com.ssafy.hw0420.model.service.BookService;

@RequestMapping("/book")
@Controller
public class BookController {

	BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/regist.do")
	public String registBook(Book book, Model model) throws SQLException {
		bookService.registBook(book);
		return "redirect:/book/list.do";
	}

	@GetMapping("/list.do")
	public String bookList(Model model) throws Exception {
		List<Book> list = bookService.getBookList();
		model.addAttribute("bookList", list);

		return "/book/list";
	}

}
