package com.app.AidNearby.Exceptions;

public class UserNotFoundException extends RuntimeException {
    //status code 404
    public UserNotFoundException(String message) {
        super(message);
    }
}