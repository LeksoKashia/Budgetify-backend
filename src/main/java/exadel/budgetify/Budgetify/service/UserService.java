package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.exception.UserNotFoundException;
import exadel.budgetify.Budgetify.model.Account;
import exadel.budgetify.Budgetify.model.User;
import exadel.budgetify.Budgetify.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User findUserByEmail(String email) throws Throwable {
        return (User) userRepo.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by email " + email + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public List<Account> getUserAccounts(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getAccounts();
        } else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

}
