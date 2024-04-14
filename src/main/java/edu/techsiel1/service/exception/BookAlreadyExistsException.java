package edu.techsiel1.service.exception;

/**
 * Exception thrown when attempting to create a book that already exists.
 * This exception indicates that a book with the same ID or other unique identifier already exists in the system.
 */
public class BookAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new BookAlreadyExistsException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
