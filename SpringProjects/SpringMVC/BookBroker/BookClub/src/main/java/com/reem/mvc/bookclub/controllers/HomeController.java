package com.reem.mvc.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reem.mvc.bookclub.models.Books;
import com.reem.mvc.bookclub.models.User;
import com.reem.mvc.bookclub.srevices.BooksServices;
import com.reem.mvc.bookclub.srevices.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	@Autowired
	BooksServices booksServ;

	@GetMapping("/books")
	public String books(Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		User loggedIn = userServ.getUser(user_id);
		model.addAttribute("loggedIn", loggedIn);
		model.addAttribute("books", booksServ.allBooks());
//		model.addAttribute("unBorrowed", booksServ.unborrowed());
		model.addAttribute("borrowed", booksServ.borrowed());
//			model.addAttribute("borrow", booksServ.findBorrower(user_id));
		return "books.jsp";
	}

	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Books book, Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		User loggedIn = userServ.getUser(user_id);
		model.addAttribute("loggedIn", loggedIn.getUserName());
		return "new.jsp";
	}

	@PostMapping("/books/new")
	public String addBook(@Valid @ModelAttribute("book") Books book, BindingResult result, Model model,
			HttpSession session) {
		User loggedIn = userServ.getUser((Long) session.getAttribute("user_id"));
		if (result.hasErrors()) {
			model.addAttribute("loggedIn", loggedIn.getUserName());
			return "new.jsp";
		} else {
			book.setUser(loggedIn);
			booksServ.addBook(book);
			return "redirect:/books";
		}
	}

	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		User loggedIn = userServ.getUser(user_id);
		model.addAttribute("loggedIn", loggedIn.getUserName());
		Books book = booksServ.findBook(id);
		model.addAttribute("book", book);
		return "details.jsp";
	}

	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("book") Books book, BindingResult result,
			Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		} else {
			User loggedIn = userServ.getUser(user_id);
			model.addAttribute("loggedIn", loggedIn.getUserName());
			Books books = booksServ.findBook(id);
			model.addAttribute("id", id);
			model.addAttribute("book", books);
			return "edit.jsp";
		}
	}

	@RequestMapping(value="/books/{id}/edit",method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Books book, BindingResult result,
			HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedIn = userServ.getUser(user_id);
		if (user_id == null) {
			return "redirect:/";
		} else {
			model.addAttribute("loggedIn", loggedIn.getUserName());
			if (result.hasErrors()) {
				model.addAttribute("id", id);
				return "edit.jsp";
			} else {
				booksServ.updateBook(book, id);
				return "redirect:/books/";
			}
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		booksServ.delete(id);
		return "redirect:/books";
	}

	@PostMapping("/borrow/{id}")
	public String borrow(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		User loggedIn = userServ.getUser(user_id);
		Books book = booksServ.findBook(id);
		book.setBorrower(loggedIn);
//		booksServ.addBorrow(book);
//		book.setUser(book.getUser());
		booksServ.updateBook(book, id);
		return "redirect:/books";
	}

	@PutMapping("/return/{id}")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		Books borrowed = booksServ.findBook(id);
		borrowed.setBorrower(null);
		booksServ.updateBook(borrowed, id);
		return "redirect:/books";
	}

}