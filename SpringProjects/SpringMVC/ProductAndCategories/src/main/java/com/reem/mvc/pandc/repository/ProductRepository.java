package com.reem.mvc.pandc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reem.mvc.pandc.models.Category;
import com.reem.mvc.pandc.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByCategoriesNotContains(Category category);
	List<Product> findAllByCategories(Category category);
	List<Product> findAll();
	Product findProductById(Long id);
	
}
