package com.example.demoappformodul.category;

import com.example.demomodule.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    ResponseEntity<List<Category>> findAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        if (!categories.isEmpty()){
        return ResponseEntity.ok(categories);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> findOneCategory(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        if (category != null){
            return ResponseEntity.ok(category);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    ResponseEntity<Category> createCategory(@RequestBody Category newCategory){
        Category createdCategory = categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Category> updateCategory(@PathVariable Long id , @RequestBody Category updatedCategory){
        Category category = categoryService.updateCategory(id, updatedCategory);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCategory(@PathVariable Long id){
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.ok("Category deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
