package exadel.budgetify.Budgetify.service;

import exadel.budgetify.Budgetify.exception.UserNotFoundException;
import exadel.budgetify.Budgetify.model.User;
import exadel.budgetify.Budgetify.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo ;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User findUserByEmail(String email) throws Throwable {
        return (User) userRepo.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by id " + email + " was not found"));
    }


}
