package edu.techsiel1.service.exception;

/**
 * Exception thrown when a requested user is not found in the system.
 * This exception is typically thrown when attempting to retrieve or operate on a non-existing user.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Constructs a new UserNotFoundException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
