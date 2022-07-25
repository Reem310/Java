package com.reem.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}

	@PostMapping("send")
	public String form(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="comment") String comment,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("comment", comment);
		return "redirect:show";
	}
	@RequestMapping("show")
	public String show(HttpSession session, Model model) {
		Integer sNumber = (Integer) session.getAttribute("number");
		model.addAttribute("number", sNumber);
		String sCity = (String) session.getAttribute("city");
		model.addAttribute("city", sCity);
		String sPerson = (String) session.getAttribute("person");
		model.addAttribute("person", sPerson);
		String sHobby = (String) session.getAttribute("hobby");
		model.addAttribute("hobby", sHobby);
		String sThing = (String) session.getAttribute("thing");
		model.addAttribute("thing", sThing);
		String sComment = (String) session.getAttribute("comment");
		model.addAttribute("comment", sComment);
		return "showOmikuji.jsp";
	}
}
