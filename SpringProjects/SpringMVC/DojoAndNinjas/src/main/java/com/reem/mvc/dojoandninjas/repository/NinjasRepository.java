package com.reem.mvc.dojoandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.dojoandninjas.models.Ninjas;
@Repository
public interface NinjasRepository extends CrudRepository<Ninjas, Long>{
	List<Ninjas> findAll();
}
