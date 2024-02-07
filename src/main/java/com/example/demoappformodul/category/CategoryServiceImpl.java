package com.example.demoappformodul.category;

import com.example.demomodule.category.Category;
import com.example.demomodule.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public Category createCategory(Category newCategory) {
        return repository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> optionalCategory = repository.findById(id);
        if (optionalCategory.isPresent() && optionalCategory.get().getId().equals(id)){
            try {
                return repository.save(updatedCategory);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(Long categoryItem) {
        try {
            repository.deleteById(categoryItem);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
