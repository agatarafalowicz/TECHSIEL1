package edu.techsiel1.controller;

import edu.techsiel1.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling specific exceptions with appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle UserAlreadyExistsException and return a CONFLICT response.
     *
     * @param ex The UserAlreadyExistsException that was thrown.
     * @return ResponseEntity with CONFLICT status and exception message.
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    /**
     * Handle BookAlreadyExistsException and return a CONFLICT response.
     *
     * @param ex The BookAlreadyExistsException that was thrown.
     * @return ResponseEntity with CONFLICT status and exception message.
     */
    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<String> handleBookAlreadyExistsException(BookAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    /**
     * Handle UserNotFoundException and return a NOT_FOUND response.
     *
     * @param ex The UserNotFoundException that was thrown.
     * @return ResponseEntity with NOT_FOUND status and exception message.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    /**
     * Handle BookNotFoundException and return a NOT_FOUND response.
     *
     * @param ex The BookNotFoundException that was thrown.
     * @return ResponseEntity with NOT_FOUND status and exception message.
     */
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    /**
     * Handle LoanNotFoundException and return a NOT_FOUND response.
     *
     * @param ex The LoanNotFoundException that was thrown.
     * @return ResponseEntity with NOT_FOUND status and exception message.
     */
    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<String> handleLoanNotFoundException(LoanNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    /**
     * Handle ReviewNotFoundException and return a NOT_FOUND response.
     *
     * @param ex The ReviewNotFoundException that was thrown.
     * @return ResponseEntity with NOT_FOUND status and exception message.
     */
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<String> handleReviewNotFoundException(ReviewNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    /**
     * Handle IllegalArgumentException and return a BAD_REQUEST response.
     *
     * @param ex The IllegalArgumentException that was thrown.
     * @return ResponseEntity with BAD_REQUEST status and exception message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}
