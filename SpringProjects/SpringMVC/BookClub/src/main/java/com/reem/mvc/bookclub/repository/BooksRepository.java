package com.reem.mvc.bookclub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.bookclub.models.Books;
@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {
	List<Books> findAll();
}
