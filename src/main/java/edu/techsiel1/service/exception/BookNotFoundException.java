package edu.techsiel1.service.exception;

/**
 * Exception thrown when a requested book is not found in the system.
 * This exception is typically thrown when attempting to retrieve or manipulate a book
 * that does not exist based on the provided identifier or criteria.
 */
public class BookNotFoundException extends RuntimeException {

    /**
     * Constructs a new BookNotFoundException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public BookNotFoundException(String message) {
        super(message);
    }
}
