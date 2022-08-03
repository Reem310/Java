package com.reem.mvc.pandc.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reem.mvc.pandc.models.Category;
import com.reem.mvc.pandc.models.Product;
import com.reem.mvc.pandc.repository.CtegoryRepository;
import com.reem.mvc.pandc.repository.ProductRepository;

@Service
public class CategoryService {
		@Autowired
		CtegoryRepository categoryRepo;
		@Autowired
		ProductRepository productRepo;
		
		public List<Category> allCategories(){
		    return categoryRepo.findAll();
		}
		public Category createCategory(Category category) {
			return categoryRepo.save(category);
		}
		public Category findCategoryById(Long id) {
			Optional<Category> value = categoryRepo.findById(id);
			if (value.isPresent()) {
				return value.get();
			} else {
				return null;
			}
		}
		public List<Category> getNotProductList(Product product){
			return categoryRepo.findByProductsNotContains(product);
		}
		public List<Category> getProductList(Product product){
			return categoryRepo.findAllByProducts(product);
		}
		public Category addProToCat(Long cid, Long pid) {
		    // retrieve an instance of a category using another method in the service.
		    Category thisCategory = findCategoryById(cid);
		    
		    // retrieve an instance of a product using another method in the service.
		    Product thisProduct = findProductById(pid);
		    
		    // add the product to this category's list of products
		    thisCategory.getProducts().add(thisProduct);
		    return categoryRepo.save(thisCategory);	
		}
		public Product findProductById(Long id) {
			Optional<Product> value = productRepo.findById(id);
			if (value.isPresent()) {
				return value.get();
			} else {
				return null;
			}
		}
		public Long getPid(Category category) {
			return category.getId();
		}
}
		
