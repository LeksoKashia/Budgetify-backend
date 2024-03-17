package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.PiggyBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiggyBankRepo extends JpaRepository<PiggyBank, Long> {
}
