package com.sportyshoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.Category;
import com.sportyshoes.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category obj= categoryService.addCategory(category);
		return new ResponseEntity<Category>(obj,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return "Category Deleted";
	}
	
	@PostMapping("/update/")
	public String updateCategory(@RequestBody Category category)
	{
		int categoryId = category.getId();
		if(categoryService.updateCategory(categoryId, category))
		{
			return categoryService.searchCategory(categoryId).toString();
		}
		else
		{
			return "No such Category exists";
		}
	}

}
