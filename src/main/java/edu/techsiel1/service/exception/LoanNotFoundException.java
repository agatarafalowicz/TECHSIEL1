package edu.techsiel1.service.exception;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String message){
        super(message);
    }
}
