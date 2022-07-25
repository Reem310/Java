package com.reem.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class NinjaGoldController {
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("log", log);
		}
		return "index.jsp";
	}

	@PostMapping("/form")
	public String form(@RequestParam(value = "place") String place, HttpSession session, Model model) {
		/**
		 * another way of writing the date DateTimeFormatter date =
		 * DateTimeFormatter.ofPattern("MMMM d, YYYY HH:mm a"); LocalDateTime now =
		 * LocalDateTime.now(); date.format(now);
		 */
		Date now = new Date();
		String date = new SimpleDateFormat("MMMM d, YYYY HH:mm a").format(now);
		@SuppressWarnings("unchecked")
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
		Integer gold = (Integer) session.getAttribute("gold");
		int rand = 0;
		if (place.equals("farm")) {
			rand = 10 + (int) (Math.random() * (20 - 10));
			log.add(new String("You entered a farm and earned " + rand + " gold. (" + date + ")"));
		}
		if (place.equals("cave")) {
			rand = 5 + (int) (Math.random() * (10 - 5));
			log.add(new String("You entered a cave and earned " + rand + " gold. (" + date + ")"));
		}
		if (place.equals("house")) {
			rand = 2 + (int) (Math.random() * (5 - 2));
			log.add(new String("You entered a house and earned " + rand + " gold. (" + date + ")"));
		}
		if (place.equals("casino")) {
			rand = -50 + (int) (Math.random() * (50 - (-50)));
			if (rand > 0) {
				log.add(new String("You entered a casino and earned " + rand + " gold. (" + date + ")"));
			} else {
				log.add(new String("You entered a casino and lost " + rand + " gold. (" + date + ")"));
			}
		}
		session.setAttribute("gold", gold + rand);
		return "redirect:/Gold";
	}

	@RequestMapping("destroy")
	public String destroy(HttpSession session) {
		session.invalidate();
		return "redirect:/Gold";
	}

}
