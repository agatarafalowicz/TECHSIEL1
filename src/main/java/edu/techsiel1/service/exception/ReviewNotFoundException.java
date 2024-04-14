package edu.techsiel1.service.exception;

/**
 * Exception thrown when a requested review is not found in the system.
 * This exception is typically thrown when attempting to retrieve or manipulate a review
 * that does not exist based on the provided identifier or criteria.
 */
public class ReviewNotFoundException extends RuntimeException {

    /**
     * Constructs a new ReviewNotFoundException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
