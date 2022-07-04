package com.johncarter.booksRender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.johncarter.booksRender.models.Book;
import com.johncarter.booksRender.services.BookService;

@Controller 
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model m, @PathVariable("bookId") Long bookId) {
		
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		m.addAttribute("book", book);
		
		return "index.jsp";
	}

}
