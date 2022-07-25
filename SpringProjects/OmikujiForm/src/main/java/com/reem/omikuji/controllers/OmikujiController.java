package com.reem.omikuji.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reem.omikuji.models.Omikuji;


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
		ArrayList<Omikuji> form = new ArrayList<Omikuji>();
	        form.add(new Omikuji(number,city,person, hobby, thing, comment));
		session.setAttribute("form", form);
		return "redirect:show";
	}
	@RequestMapping("show")
	public String show(HttpSession session, Model model) {
		ArrayList<Omikuji> forms = (ArrayList<Omikuji>) session.getAttribute("form");
		model.addAttribute("forms", forms);
		return "showOmikuji.jsp";
	}
}
