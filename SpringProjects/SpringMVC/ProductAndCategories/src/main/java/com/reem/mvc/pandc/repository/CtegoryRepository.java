package com.reem.mvc.pandc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.pandc.models.Category;
import com.reem.mvc.pandc.models.Product;
@Repository
public interface CtegoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findAllByProducts(Product product);
	Category findCategoryById(Long id);
}
