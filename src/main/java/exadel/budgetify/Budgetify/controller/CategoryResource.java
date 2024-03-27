package exadel.budgetify.Budgetify.controller;


import exadel.budgetify.Budgetify.model.Category;
import exadel.budgetify.Budgetify.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category Category) {
        Category newCategory = categoryService.addCategory(Category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updateCategory = categoryService.updateCategory(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
