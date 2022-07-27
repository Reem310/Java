package com.reem.pokebook.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reem.pokebook.models.Expense;
import com.reem.pokebook.repositories.PokeBookRepositorie;

@Service
public class PokeBookServices {
	private final PokeBookRepositorie bookRepo;

	public PokeBookServices(PokeBookRepositorie bookRepo) {
		this.bookRepo = bookRepo;
	}
	public List<Expense> allPokeBook(){
		return bookRepo.findAll();
	}
	public Expense createPokeBooke(Expense expense) {
		return bookRepo.save(expense);
	}
}
