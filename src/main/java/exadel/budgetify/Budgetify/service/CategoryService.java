package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.model.Category;
import exadel.budgetify.Budgetify.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }

    public List<Category> findAllCategorys(){
        return categoryRepo.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }
}
