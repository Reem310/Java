package com.reem.mvc.projectmanager.controllers;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reem.mvc.projectmanager.models.Project;
import com.reem.mvc.projectmanager.models.User;
import com.reem.mvc.projectmanager.services.ProjectService;
import com.reem.mvc.projectmanager.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectServ;
	@Autowired
	UserService userServ;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}else {
			User loggedIn = userServ.findUserById(user_id);
			model.addAttribute("loggedIn", loggedIn);
			model.addAttribute("allP", projectServ.allProjects());
			model.addAttribute("joined",projectServ.joined(loggedIn));
			model.addAttribute("notj", projectServ.notJoined(loggedIn));
			return "dashboard.jsp";
		}
	}
	
	@GetMapping("/projects/new")
	public String newProject(HttpSession session, Model model, @ModelAttribute("newProject")Project newP) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}else {
			User loggedIn = userServ.findUserById(user_id);
			model.addAttribute("loggedIn", loggedIn);
			return "newProject.jsp";
		}
	}
	@PostMapping("/projects/create")
	public String createProject(@Valid @ModelAttribute("newProject") Project newP,BindingResult result, Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}else {
			if(result.hasErrors()) {
				return "newProject.jsp";
			}else {
				User loggedIn = userServ.findUserById(user_id);
				model.addAttribute("loggedIn", loggedIn);
				newP.setCreator(loggedIn);
				projectServ.createProject(newP);
				return "redirect:/dashboard";
			}
		}
	}
	@GetMapping("/projects/{id}")
	public String projectDetails(@PathVariable("id") Long id,Model model, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}else {
			User loggedIn = userServ.findUserById(user_id);
			model.addAttribute("loggedIn", loggedIn);
			model.addAttribute("pDetails", projectServ.findProjectById(id));
			return "pDetails.jsp";
		}
	}
	@GetMapping("/projects/edit/{id}")
	public String editPost(@ModelAttribute("updatedProject") Project project, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id != null) {
			User loggedIn = userServ.findUserById(user_id);
			model.addAttribute("loggedIn", loggedIn);
			Project oldProject = projectServ.findProjectById(id);
			model.addAttribute("oldProject", oldProject);
			model.addAttribute("id", id);
			return "edit.jsp";			
		}
		else {
			return "redirect:/";
		}
	}
	@PutMapping("/projects/edit/{id}")
	public String editingPost(@Valid @ModelAttribute("updatedProject") Project project, 
			BindingResult result, @PathVariable("id") Long id, HttpSession session ) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
		Long user_id = (Long) session.getAttribute("user_id");
		User loggedIn = userServ.findUserById(user_id);
		projectServ.updateP(project, id);
		return "redirect:/dashboard";
		}
	}
	@PostMapping("/join/{id}")
	public String addCat(@PathVariable("id")Long id, @RequestParam("uid")Long uid) {
		projectServ.join(id, uid);
		return "redirect:/dashboard";
	}
	@DeleteMapping("/delete/{id}")
	public String deletePost(@PathVariable("id") Long id) {
		projectServ.deleteProject(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/leave/{id}")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		Project uu = projectServ.findProjectById(id);
		User loggedIn = userServ.findUserById(user_id);
		projectServ.leaveProject(loggedIn,id);
		return "redirect:/dashboard";
	}

}
