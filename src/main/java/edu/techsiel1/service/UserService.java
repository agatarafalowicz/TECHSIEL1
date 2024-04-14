package edu.techsiel1.service;

import edu.techsiel1.entity.User;
import edu.techsiel1.repository.UserRepository;
import edu.techsiel1.service.exception.UserAlreadyExistsException;
import edu.techsiel1.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing users.
 * This class provides methods to perform CRUD operations on users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructs a UserService with the specified UserRepository.
     *
     * @param userRepository The repository used for accessing and managing users.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users.
     *
     * @return An Iterable of all users.
     */
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The user with the specified ID.
     * @throws IllegalArgumentException if the userId is null or not a positive integer.
     * @throws UserNotFoundException if the user with the specified ID is not found.
     */
    public User getOne(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID. User ID must be a positive integer.");
        }
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id '%s' not found", userId)));
    }

    /**
     * Creates a new user.
     *
     * @param user The user to create.
     * @return The created user.
     * @throws UserAlreadyExistsException if a user with the same login already exists.
     */
    public User create(User user) {
        String login = user.getLogin();
        Optional<User> existingUser = userRepository.findUserByLogin(login);
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(String.format("User with login '%s' already exists", login));
        } else {
            return userRepository.save(user);
        }
    }

    /**
     * Deletes a user by their ID.
     *
     * @param userId The ID of the user to delete.
     * @throws IllegalArgumentException if the userId is null or not a positive integer.
     * @throws UserNotFoundException if the user with the specified ID is not found.
     */
    public void delete(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID. User ID must be a positive integer.");
        }
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(String.format("User with id '%s' not found", userId));
        }
        userRepository.deleteById(userId);
    }
}
