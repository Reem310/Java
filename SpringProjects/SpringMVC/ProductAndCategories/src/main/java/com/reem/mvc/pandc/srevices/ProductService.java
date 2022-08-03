package com.reem.mvc.pandc.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reem.mvc.pandc.models.Category;
import com.reem.mvc.pandc.models.Product;
import com.reem.mvc.pandc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> allProducts(){
	    return productRepo.findAll();
	}
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	public Product findProductById(Long id) {
		Optional<Product> value = productRepo.findById(id);
		if (value.isPresent()) {
			return value.get();
		} else {
			return null;
		}
	}
	public List<Product> getNotCatgoryList(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	public List<Product> getCategoryList(Category category){
		return productRepo.findAllByCategories(category);
	}
}
