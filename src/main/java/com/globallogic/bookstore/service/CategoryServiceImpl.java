package com.globallogic.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bookstore.entity.Category;
import com.globallogic.bookstore.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryRepository catRepo;

	@Override
	public List<Category> getAllCategorys() {
		return catRepo.findAll();
	}

	@Override
	public Category getCategoryById(int id) throws Exception {
		Optional<Category> response = catRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Category not found");
		return response.get();
	}

	@Override
	public Category addCategory(Category category) {
		return catRepo.save(category);
	}

	@Override
	public String deleteCategoryById(int id) {
		catRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}

	@Override
	public Category updateCategory(Category category) {
		return catRepo.save(category);
	}

	@Override
	public Category updateCategoryById(Category changes, int id) throws Exception {
		Category category = getCategoryById(id);
		return catRepo.save(category);
	}
}