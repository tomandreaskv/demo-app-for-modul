package com.example.demoappformodul.category;

import com.example.demomodule.category.Category;
import com.example.demomodule.category.CategoryRepository;
import com.example.demomodule.item.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);

    Category createCategory(Category newCategory);
    Category updateCategory(Long categoryId, Category updatedCategory);
    boolean deleteCategory(Long categoryItem);
}
