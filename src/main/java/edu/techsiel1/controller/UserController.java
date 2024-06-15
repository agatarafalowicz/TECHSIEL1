package edu.techsiel1.controller;

import edu.techsiel1.entity.User;
import edu.techsiel1.service.UserService;
import edu.techsiel1.service.exception.UserAlreadyExistsException;
import edu.techsiel1.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing User entities via RESTful endpoints.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection for UserService.
     *
     * @param userService The UserService used to interact with User entities.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to add a new User.
     *
     * @param user The User object to be added.
     * @return ResponseEntity containing the newly created User with an HTTP status of CREATED (201),
     *         or an error response if the user already exists (CONFLICT).
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User newUser = userService.create(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }
    }

    /**
     * Get a specific User by ID.
     *
     * @param userId The ID of the User to retrieve.
     * @return ResponseEntity containing the retrieved User,
     *         or an error response if the user is not found (NOT_FOUND) or if the ID is invalid (BAD_REQUEST).
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getOne(@PathVariable Integer userId) {
        try {
            User user = userService.getOne(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Delete a User by ID.
     *
     * @param userId The ID of the User to delete.
     * @return ResponseEntity with NO_CONTENT status if the deletion is successful,
     *         or an error response if the user is not found (NOT_FOUND) or if the ID is invalid (BAD_REQUEST).
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Retrieve all Users.
     *
     * @return Iterable of all Users.
     */
    @GetMapping("/getAll")
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userId = authentication.getName();
            try {
                User user = userService.getOne(Integer.parseInt(userId));
                return ResponseEntity.ok(user);
            } catch (UserNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
