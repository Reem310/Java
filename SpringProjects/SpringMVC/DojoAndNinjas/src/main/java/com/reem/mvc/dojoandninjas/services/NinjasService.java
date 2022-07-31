package com.reem.mvc.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reem.mvc.dojoandninjas.models.Ninjas;
import com.reem.mvc.dojoandninjas.repository.NinjasRepository;

@Service
public class NinjasService {
	@Autowired
	NinjasRepository ninjasRepo;
	
	public List<Ninjas> allNinjas(){
		return ninjasRepo.findAll();
	}
	public Ninjas createNinja(Ninjas ninja) {
		return ninjasRepo.save(ninja);
	}
}
