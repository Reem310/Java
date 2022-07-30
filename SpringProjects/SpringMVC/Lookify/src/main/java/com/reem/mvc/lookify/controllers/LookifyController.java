package com.reem.mvc.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reem.mvc.lookify.models.Lookify;
import com.reem.mvc.lookify.services.LookifyServices;

@Controller
public class LookifyController {
	
	@Autowired
	LookifyServices lookifyServices;
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("lookify") Lookify lookify, Model model) {
		List<Lookify> getLookify = lookifyServices.getAll();
		model.addAttribute("lookify", getLookify);
		return "dashboard.jsp";
	}
	   @PostMapping("/search")
	   public String search(@RequestParam("artist") String artist) {			   
		   return "redirect:/search/" + artist;
	   }

	@GetMapping("/search/{artist}")
	public String getSearch(@PathVariable("artist") String artist, Model model, RedirectAttributes msg) {
			List<Lookify> getLookify = lookifyServices.search(artist);
			if(getLookify.size()==0) {
				msg.addFlashAttribute("error", "Search not found");
				return "redirect:/dashboard";
			}else {
				model.addAttribute("artist", artist);
				model.addAttribute("lookify", getLookify);
				return "search.jsp";
			}
	}

	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("songs") Lookify songs, BindingResult result, Model model) {
		return "new.jsp";
	}
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("songs") Lookify songs, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			lookifyServices.addSong(songs);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify show = lookifyServices.getById(id);
		model.addAttribute("show",show);
		return "show.jsp";
	}
	@RequestMapping("/topTen")
	public String topTen(Model model) {
		model.addAttribute("top", lookifyServices.topTen());
		return "topTen.jsp";
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyServices.delete(id);
		return "redirect:/dashboard";
	}
}
