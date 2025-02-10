package com.wheely.service;

import java.util.List;

import com.wheely.dto.CategoryDTO;

public interface CategoryService_i {
	public List<CategoryDTO> getAllCategories();

    public CategoryDTO getCategoryById(Long id);

    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    public boolean deleteCategory(Long id);
}
