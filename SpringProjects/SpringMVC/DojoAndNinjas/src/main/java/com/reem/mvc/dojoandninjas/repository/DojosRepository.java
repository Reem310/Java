package com.reem.mvc.dojoandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.dojoandninjas.models.Dojos;
@Repository
public interface DojosRepository extends CrudRepository<Dojos, Long> {
	List<Dojos> findAll();
}
