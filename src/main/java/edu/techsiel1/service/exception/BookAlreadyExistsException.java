package edu.techsiel1.service.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
