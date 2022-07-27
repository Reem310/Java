package com.reem.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reem.pokebook.models.Expense;
import com.reem.pokebook.services.PokeBookServices;

@Controller
public class PokeBookControllers {

	@Autowired
	PokeBookServices service;

	@RequestMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = service.allPokeBook();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

	@PostMapping("/send")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = service.allPokeBook();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			service.createPokeBooke(expense);
			return "redirect:/expenses";
		}

	}
}
