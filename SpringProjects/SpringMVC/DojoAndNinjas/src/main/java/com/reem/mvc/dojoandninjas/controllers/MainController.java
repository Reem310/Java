package com.reem.mvc.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reem.mvc.dojoandninjas.models.Dojos;
import com.reem.mvc.dojoandninjas.models.Ninjas;
import com.reem.mvc.dojoandninjas.services.DojosService;
import com.reem.mvc.dojoandninjas.services.NinjasService;

@Controller
public class MainController {
	@Autowired
	NinjasService ninjaService;
	@Autowired
	DojosService dojoService;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojos dojo, Model model) {
		List<Dojos> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@Valid@ModelAttribute("dojo") Dojos dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninjas ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid@ModelAttribute("ninja") Ninjas ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+ ninja.getDojo().getId();
		}
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojos dojo = dojoService.showDojo(id);
		model.addAttribute("dojos", dojo );
		return "show.jsp";
	}
}
