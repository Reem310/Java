package com.reem.mvc.pandc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reem.mvc.pandc.models.Category;
import com.reem.mvc.pandc.models.Product;
import com.reem.mvc.pandc.srevices.CategoryService;
import com.reem.mvc.pandc.srevices.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productServ;
	@Autowired
	CategoryService categoryServ;
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allProducts", categoryServ.allCategories());
		model.addAttribute("allCategories", productServ.allProducts());
		return "index.jsp";
	}
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product,Model model) {
		model.addAttribute("newProduct", new Product());
		return "product.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid@ModelAttribute("product")Product product, BindingResult result) {
		productServ.createProduct(product);
		return "redirect:/products/"+product.getId();
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category,Model model) {
		 model.addAttribute("newCategory", new Category());
		return "category.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@Valid@ModelAttribute("category")Category category, BindingResult result) {
		categoryServ.createCategory(category);	
		return "redirect:/categories/"+category.getId();
	}
	@GetMapping("/products/{id}")
	public String showProduct(@ModelAttribute("newProduct")Category category, @PathVariable("id")Long id, Model model) {
		model.addAttribute("product", productServ.findProductById(id)); 
		model.addAttribute("notInList", categoryServ.getNotProductList(productServ.findProductById(id)));
//		model.addAttribute("inList", categoryServ.getProductList(productServ.findProductById(id)));
		return "showProduct.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCat(@ModelAttribute("newProduct")Category category, @PathVariable("id")Long id, @RequestParam("cid")Long cid) {
		categoryServ.addProToCat(cid, id);
		return "redirect:/products/" + id;
	}
	@GetMapping("/categories/{id}")
	public String newCategory(@ModelAttribute("newCategory")Product product, @PathVariable("id")Long id, Model model) {
		model.addAttribute("category", categoryServ.findCategoryById(id));
		model.addAttribute("notInList", productServ.getNotCatgoryList(categoryServ.findCategoryById(id)));
//		model.addAttribute("inList", productServ.getCategoryList(categoryServ.findCategoryById(id)));
		return "showCategory.jsp";
	}
	@PostMapping("/categories/{id}")
	public String addPro(@ModelAttribute("newCategory")Product product, @PathVariable("id")Long id,@RequestParam("pid")Long pid) {
		categoryServ.addProToCat(id, pid);
		return "redirect:/categories/" + id;
	}
	
}
