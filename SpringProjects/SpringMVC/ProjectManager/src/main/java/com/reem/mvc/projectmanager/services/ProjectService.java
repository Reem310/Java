package com.reem.mvc.projectmanager.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.reem.mvc.projectmanager.models.Project;
import com.reem.mvc.projectmanager.models.User;
import com.reem.mvc.projectmanager.repository.ProjectRepository;
import com.reem.mvc.projectmanager.repository.UserRepository;
@Service
public class ProjectService {

		@Autowired
		ProjectRepository projectRepo;
		@Autowired
		UserRepository userRepo;
		
		public List<Project> allProjects(){
			return projectRepo.findAll();
		}
		public Project findProjectById(Long id) {
			Optional<Project> potentialProject = projectRepo.findById(id);
			if(potentialProject.isPresent()) {
				return potentialProject.get();
			}
			else return null;
		}
		public Project createProject(Project project) {
			return projectRepo.save(project);
		}
		
		public void deleteProject(Long id) {
			projectRepo.deleteById(id);
		}
		public Project updateP(Project project, Long id) {
			Project value = projectRepo.findById(id).get();
			value.setTitle(project.getTitle());
			value.setDescription(project.getDescription());
			value.setDueDate(project.getDueDate());
			return projectRepo.save(value);
		}

		public Project join(Long pid, Long uid) {
		    // retrieve an instance of a category using another method in the service.
			Project thisProject = findProjectById(pid);
		    
		    // retrieve an instance of a product using another method in the service.
			User thisUser = findUserById(uid);
		    
		    // add the product to this category's list of products
			thisProject.getUsers().add(thisUser);
		    return projectRepo.save(thisProject);	
		}
	    public User findUserById(Long id) {
	    	Optional<User> potentialUser = userRepo.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	else {
	    		return null;    		
	    	}
	    }
		public List<Project> notJoined(User user){
			return projectRepo.findByUsersNotContaining(user);
		}
		public List<Project> joined(User user){
			return projectRepo.findByUsersContaining(user);
		}
		public Project savep(User user) {
			// TODO Auto-generated method stub
			
			user.setProjects_joined(null);
			
			return projectRepo.save(user);
		
		}
	    public void leaveProject(User user , long project_id){
	        Optional<Project> project = projectRepo.findById(project_id);
	        if(project.isPresent()){
	            project.get().getUsers().remove(user);
	            projectRepo.save(project.get());
	        }
	    }

}
