package com.reem.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("user","User!");
		if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}else {
			Integer counter = (Integer) session.getAttribute("count");
			session.setAttribute("count",counter+1);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}else {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("count", currentCount);
		}
		return "counter.jsp";
	}
}
