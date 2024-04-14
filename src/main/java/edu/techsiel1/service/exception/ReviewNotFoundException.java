package edu.techsiel1.service.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message){
        super(message);
    }
}
