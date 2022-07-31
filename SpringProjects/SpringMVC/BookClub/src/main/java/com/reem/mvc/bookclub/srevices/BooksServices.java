package com.reem.mvc.bookclub.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reem.mvc.bookclub.models.Books;
import com.reem.mvc.bookclub.repository.BooksRepository;

@Service
public class BooksServices {
	@Autowired
	BooksRepository booksRepo;
	
	public List<Books> allBooks(){
		return booksRepo.findAll();
	}
	public Books addBook(Books book) {
		return booksRepo.save(book);
	}
	public Books findBook(long id) {
		Optional<Books> book = booksRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}else {
			return null;
		}
	}

	public Books updateBook(Books book, Long id) {
		Books value = booksRepo.findById(id).get();
		value.setTitle(book.getTitle());
		value.setAuthor(book.getAuthor());
		value.setThoughts(book.getThoughts());
		return booksRepo.save(value);
	}
	
}
