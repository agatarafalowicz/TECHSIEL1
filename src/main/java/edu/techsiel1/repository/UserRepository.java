package edu.techsiel1.repository;

import edu.techsiel1.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing User entities in the database.
 * Extends Spring Data's CrudRepository to provide basic CRUD operations for User entities.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Retrieve a user by their login username.
     *
     * @param login The login username of the user to retrieve.
     * @return The user with the specified login username, or null if not found.
     */
    User getUserByLogin(String login);

    /**
     * Retrieve a user by their login username wrapped in an Optional.
     *
     * @param login The login username of the user to retrieve.
     * @return An Optional containing the user with the specified login username, or empty if not found.
     */
    Optional<User> findUserByLogin(String login);

}
