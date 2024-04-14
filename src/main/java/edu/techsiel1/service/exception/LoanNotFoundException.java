package edu.techsiel1.service.exception;

/**
 * Exception thrown when a requested loan is not found in the system.
 * This exception is typically thrown when attempting to retrieve or manipulate a loan
 * that does not exist based on the provided identifier or criteria.
 */
public class LoanNotFoundException extends RuntimeException {

    /**
     * Constructs a new LoanNotFoundException with the specified error message.
     *
     * @param message The error message describing the specific cause of the exception.
     */
    public LoanNotFoundException(String message) {
        super(message);
    }
}
