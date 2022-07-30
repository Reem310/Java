package com.reem.mvc.lookify.rebository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.lookify.models.Lookify;
@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtist(String artist);
    List<Lookify> findTop10ByOrderByRatingDesc();
}
