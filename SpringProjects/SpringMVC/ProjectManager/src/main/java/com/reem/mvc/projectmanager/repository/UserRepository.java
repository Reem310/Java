package com.reem.mvc.projectmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.projectmanager.models.Project;
import com.reem.mvc.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
//	List<Project> findProjectByUser(Long id);
	List<Project> findByProjectsNotContaining(Long id);
	List<User> findByProjectsNotContains(Long id);

}