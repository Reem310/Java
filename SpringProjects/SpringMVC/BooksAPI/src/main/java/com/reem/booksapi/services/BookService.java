package com.reem.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reem.booksapi.models.Book;
import com.reem.booksapi.repository.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book book = this.findBook(id);
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
			System.out.println("**** In updateBook ****");
			System.out.println("T: " + book.getTitle() + " D:" + book.getDescription() + " L:" + book.getLanguage() + " P:" + book.getNumberOfPages() );
			return this.bookRepository.save(book);
		}	else {
			return null;
		}
	}
    public String deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    	bookRepository.deleteById(id);
    	return "Book is deleted";
    	}else {
    		return "Book not found";
    	}
    }

}
