package com.ecom.service;

import com.ecom.model.Category;

import java.util.List;

public interface CategoryService {

    public boolean isCategoryPresent(String name);
    public List<Category> getAllCategories();
    public Category addCategory(Category category);
}
