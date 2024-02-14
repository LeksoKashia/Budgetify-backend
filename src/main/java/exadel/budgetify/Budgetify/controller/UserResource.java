package exadel.budgetify.Budgetify.controller;

import exadel.budgetify.Budgetify.model.User;
import exadel.budgetify.Budgetify.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/find/{email}")
    public ResponseEntity<User> getUser(@PathVariable("email") String email) throws Throwable {
        User User = userService.findUserByEmail(email);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User User) {
        User newUser = userService.addUser(User);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
