package exadel.budgetify.Budgetify.repo;

import exadel.budgetify.Budgetify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional findUserByEmail(String email);
}
