package com.reem.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.reem.pokebook.models.Expense;

@Repository
public interface PokeBookRepositorie extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
