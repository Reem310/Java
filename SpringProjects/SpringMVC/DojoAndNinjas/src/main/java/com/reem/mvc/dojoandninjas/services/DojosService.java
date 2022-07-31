package com.reem.mvc.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reem.mvc.dojoandninjas.models.Dojos;
import com.reem.mvc.dojoandninjas.repository.DojosRepository;

@Service
public class DojosService {
	
	@Autowired
	DojosRepository dojosRepo;
	
	public List<Dojos> allDojos(){
		return dojosRepo.findAll();
	}
	public Dojos createDojo(Dojos dojo) {
		return dojosRepo.save(dojo);
	}
	public Dojos showDojo(Long id) {
		Optional <Dojos> value = dojosRepo.findById(id);
		if (value.isPresent()) {
			return value.get();
		} else {
			return null;
		}
	}
}
