package edu.techsiel1.controller;

import edu.techsiel1.entity.User;
import edu.techsiel1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);
        return userService.create(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
    }

    @GetMapping("/getAll")
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public User getOne(@PathVariable Integer userId) {
        return userService.getOne(userId);
    }
}
