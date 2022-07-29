package com.reem.mvc.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reem.mvc.languages.models.Languages;
import com.reem.mvc.languages.repository.LanguageRepository;

@Service
public class LanguagesServices {
	private final LanguageRepository languageRepo;

	public LanguagesServices(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Languages> findLanguages(){
		return languageRepo.findAll();
	}
	public Languages create(Languages languages) {
		return languageRepo.save(languages);
	}
	public Languages getById(Long id) {
		Optional <Languages> value = languageRepo.findById(id);
		if (value.isPresent()) {
			return value.get();
		} else {
			return null;
		}
	}
	public Languages edit(Long id, Languages language) {
		Languages value = languageRepo.findById(id).get();
		value.setName(language.getName());
		value.setCreator(language.getCreator());
		value.setCurrentVersion(language.getCurrentVersion());
		return languageRepo.save(value);
	}
	public void delete(Long id) {
		languageRepo.deleteById(id);
	}
}
