package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.TransactionCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoriesRepo extends JpaRepository<TransactionCategories, Long> {
}
