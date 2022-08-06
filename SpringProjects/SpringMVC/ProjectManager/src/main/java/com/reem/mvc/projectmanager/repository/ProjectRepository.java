package com.reem.mvc.projectmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.projectmanager.models.Project;
import com.reem.mvc.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	List<Project> findByUsersNotContains(Long id);
	List<Project> findByUsersIsNotNull();
	List<Project> findByUsersIsNull();
	List<Project> findByUsersContains(Long id);
	List<Project> findByUsersNotContaining(User user);
	List<Project> findByUsersContaining(User user);
	Project save(User user);
	}
