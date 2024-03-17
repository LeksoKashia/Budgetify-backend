package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
}
