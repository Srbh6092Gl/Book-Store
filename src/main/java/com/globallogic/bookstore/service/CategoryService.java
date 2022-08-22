package com.globallogic.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.globallogic.bookstore.entity.Category;

@Repository
public interface CategoryService {
	
	public List<Category> getAllCategorys();
	public Category getCategoryById(int id) throws Exception;
	public Category addCategory(Category Category);
	public String deleteCategoryById(int id);
	public Category updateCategory(Category Category);
	public Category updateCategoryById(Category changes,int id) throws Exception;
}