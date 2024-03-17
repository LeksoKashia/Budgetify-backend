package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
