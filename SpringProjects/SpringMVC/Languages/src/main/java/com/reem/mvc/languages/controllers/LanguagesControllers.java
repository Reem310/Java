package com.reem.mvc.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reem.mvc.languages.models.Languages;
import com.reem.mvc.languages.services.LanguagesServices;

@Controller
public class LanguagesControllers {
	@Autowired
	LanguagesServices languagesServices;
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("languages") Languages languages, Model model) {
		List<Languages> language = languagesServices.findLanguages();
		model.addAttribute("language",language);
		return "index.jsp";
	}
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("languages") Languages languages, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Languages> language = languagesServices.findLanguages();
			model.addAttribute("language",language);
			return "index.jsp";
		}else {
			languagesServices.create(languages);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Languages languages = languagesServices.getById(id);
		model.addAttribute("languages",languages);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/edit/{id}")
	public String process(@PathVariable("id") Long id, @Valid @ModelAttribute("languages") Languages languages, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languagesServices.edit(id, languages);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Languages language = languagesServices.getById(id);
		model.addAttribute("language",language);
		return "show.jsp";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languagesServices.delete(id);
		return "redirect:/languages";
	}
}
