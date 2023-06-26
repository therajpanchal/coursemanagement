package com.virtusa.coursemanagement.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
