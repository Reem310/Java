package com.reem.mvc.lookify.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reem.mvc.lookify.models.Lookify;
import com.reem.mvc.lookify.rebository.LookifyRepository;

@Service
public class LookifyServices {
	private final LookifyRepository lookifyRepo;

	public LookifyServices(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
	public List<Lookify> getAll(){
		return lookifyRepo.findAll();
	}
	public List<Lookify> search(String artist){
		return 	lookifyRepo.findByArtist(artist);
	}
	public Lookify addSong(Lookify lookify){
		return lookifyRepo.save(lookify);
	}

	public Lookify getById(Long id) {
		Optional <Lookify> value = lookifyRepo.findById(id);
		if (value.isPresent()) {
			return value.get();
		} else {
			return null;
		}
	}
	public List<Lookify> topTen(){
		return lookifyRepo.findTop10ByOrderByRatingDesc();	
	}
	public void delete(Long id) {
		lookifyRepo.deleteById(id);
	}
}
