package com.reem.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = service.find(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	@RequestMapping(value = "/expenses/{id}/edit", method = RequestMethod.PUT)
	public String process(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			service.update(expense, id);
			redirectAttributes.addFlashAttribute("success", "Expense was edited successfully");
			return "redirect:/expenses";
		}
	}

	@RequestMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = service.find(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/expenses";
	}
}
