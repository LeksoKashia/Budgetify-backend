package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
