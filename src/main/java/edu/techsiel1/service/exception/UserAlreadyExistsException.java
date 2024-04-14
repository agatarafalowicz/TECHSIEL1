package edu.techsiel1.service.exception;

/**
 * Exception thrown when attempting to create a user with a login that already exists in the system.
 * This exception is typically thrown when a user creation operation fails due to a duplicate login.
 */
public class UserAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new UserAlreadyExistsException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
