package com.globallogic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bookstore.entity.Category;
import com.globallogic.bookstore.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	//GET requests
	
	//GET request for fetching all Category
	@GetMapping
	public List<Category> getAllCategorys(){
		return categoryService.getAllCategorys();
	}
	
	//GET request for fetching a Category by ID
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) throws Exception {
		return categoryService.getCategoryById(id);
	}
	
	
	//POST requests
	
	//POST request to add a Category
	@PostMapping
	public Category addCategory( @RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Category by id
	@DeleteMapping("/{id}")
	public String deleteCategoryById(@PathVariable int id) {
		return categoryService.deleteCategoryById(id);
	}
	
	//PUT requests
	
	//PUT request to update a Category
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	//PUT request to update a Category by id
	//If any field is missing, it will take default value for the respective field
	@PutMapping("/{id}")
	public Category updateCategoryById(@RequestBody Category changes,@PathVariable int id) throws Exception {
		return categoryService.updateCategoryById(changes,id);
	}
}