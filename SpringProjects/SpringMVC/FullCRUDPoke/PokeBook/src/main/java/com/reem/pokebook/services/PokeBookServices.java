package com.reem.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reem.pokebook.models.Expense;
import com.reem.pokebook.repositories.PokeBookRepositorie;

@Service
public class PokeBookServices {
	private final PokeBookRepositorie bookRepo;

	public PokeBookServices(PokeBookRepositorie bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Expense> allPokeBook() {
		return bookRepo.findAll();
	}

	public Expense createPokeBooke(Expense expense) {
		return bookRepo.save(expense);
	}

	public Expense find(Long id) {
		Optional<Expense> value = bookRepo.findById(id);
		if (value.isPresent()) {
			return value.get();
		} else {
			return null;
		}
	}

	public Expense update(Expense expense, Long id) {
		Expense value = bookRepo.findById(id).get();
		value.setName(expense.getName());
		value.setVendor(expense.getVendor());
		value.setAmount(expense.getAmount());
		value.setDescription(expense.getDescription());
		return bookRepo.save(value);
	}
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
