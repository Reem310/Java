package com.reem.mvc.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reem.mvc.bookclub.models.Books;
import com.reem.mvc.bookclub.models.LoginUser;
import com.reem.mvc.bookclub.models.User;
import com.reem.mvc.bookclub.srevices.BooksServices;
import com.reem.mvc.bookclub.srevices.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userServ;
	@Autowired
	BooksServices booksServ;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/books";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/books";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
//    	session.invalidate();	
		session.removeAttribute("user_id");
		return "redirect:/";
	}

	@GetMapping("/books")
	public String books(Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		} else {
			User loggedIn = userServ.getUser(user_id);
			model.addAttribute("loggedIn", loggedIn.getUserName());
			model.addAttribute("books", booksServ.allBooks());
			return "books.jsp";
		}
	}

	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Books book, Model model, HttpSession session) {
		User loggedIn = userServ.getUser((Long) session.getAttribute("user_id"));
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
		User loggedIn = userServ.getUser((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedIn", loggedIn.getUserName());
		Books book = booksServ.findBook(id);
		model.addAttribute("book", book);
		return "details.jsp";
	}

	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedIn = userServ.getUser((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedIn", loggedIn.getUserName());
		Books book = booksServ.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}

	@PutMapping("/books/{id}/edit")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Books book, BindingResult result, HttpSession session, Model model) {
		User loggedIn = userServ.getUser((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedIn", loggedIn.getUserName());
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			book.setUser(loggedIn);
			booksServ.updateBook(book, id);
			return "redirect:/books/" + id + "/edit";
		}
	}

}