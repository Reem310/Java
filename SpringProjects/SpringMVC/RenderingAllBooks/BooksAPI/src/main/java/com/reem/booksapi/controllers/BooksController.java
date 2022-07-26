package com.reem.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reem.booksapi.models.Book;
import com.reem.booksapi.services.BookService;

@Controller
public class BooksController {
	@Autowired
	BookService bookService;

	@RequestMapping("/books")
	public String showBook(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "allBooks.jsp";
	}

	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable(value = "id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute(book);
		return "show.jsp";
	}
}
