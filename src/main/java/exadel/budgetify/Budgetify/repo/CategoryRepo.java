package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
