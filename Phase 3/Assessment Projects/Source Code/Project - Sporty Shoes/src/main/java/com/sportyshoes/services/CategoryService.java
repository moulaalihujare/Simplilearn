package com.sportyshoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entities.Category;
import com.sportyshoes.repo.CategoryRepository;
import com.sportyshoes.response.CategoryResponse;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(int id)
	{
		categoryRepository.deleteById(id);
	}
	
	public Boolean updateCategory(int id, Category category)
	{
		Category cat1 = categoryRepository.findById(id).get();
		if(cat1.getId()==0)
		{
			return false;
		}
		else
		{
			cat1 = category;
			categoryRepository.save(cat1);
			return true;
		}
	}
	
	public CategoryResponse searchCategory(int id)
	{
		CategoryResponse cr = new CategoryResponse();
		Optional<Category> searchedCategory = categoryRepository.findById(id);
		if(searchedCategory.isPresent())
		{
			Category cat = searchedCategory.get();
			cr.setId(cat.getId());
			cr.setName(cat.getName());
			cr.setDetails(cat.getDetails());
		}
		return cr;
	}
}
